#include <iostream>
#include <map>

using namespace std;

class Object
{
};

class Message : public Object
{
private:
    string topic;
    string body;

public:
    Message(string header, string payload)
    {
        topic = header;
        body = payload;
    }

    string getTopic()
    {
        return topic;
    }

    string getBody()
    {
        return body;
    }
};

class Employee : public Object
{
private:
    int id;
    string name;
    long phone;

public:
    Employee(string n, long p)
    {
        name = n;
        phone = p;
    }
    void setId(int value)
    {
        id = value;
    }

    int getId()
    {
        return id;
    }

    string getName()
    {
        return name;
    }

    long getPhone()
    {
        return phone;
    }
};

class DirectoryException
{
private:
    string message;

public:
    DirectoryException(string msg)
    {
        message = msg;
    }
    string getMessage()
    {
        return message;
    }
};

class InvalidEmployeeException : public DirectoryException
{
public:
    InvalidEmployeeException(string msg) : DirectoryException(msg)
    {
    }
};

class EmployeeNotFoundException : public DirectoryException
{
public:
    EmployeeNotFoundException(string msg) : DirectoryException(msg)
    {
    }
};

class Directory : public Object
{
public:
    virtual int add(Employee *e) = 0;
    virtual Employee *find(int id) = 0;
};

class Cache : public Object
{
public:
    virtual void put(int key, Object *value) = 0;
    virtual Object *get(int key) = 0;
};

class Handler : public Object
{
public:
    virtual void handle(Message *message) = 0;
};

class AuditHandler : public Object
{
private:
    Auditor* auditor;
public:
    AuditHandler(Auditor* auditor)
    {
        this->auditor = auditor;
    }
    void handle(Message *message)
    {
        if(message->getTopic() == "audit")
            auditor->log(message->getBody());
    }
};

class EmailHandler : public Object
{
private:
    Notifier* notifier;
public:
    EmailHandler(Notifier* notifier)
    {
        this->notifier = notifier;
    }
    void handle(Message *message)
    {
        if(message->getTopic() == "directory")
            notifier->notify(message->getBody());
    }
};

class Auditor : public Object
{
public:
    virtual void log(string record) = 0;
};

class SimpleAuditor : public Auditor
{
public:
    void log(string record)
    {

    }
};

class Notifier : public Object
{
public:
    virtual void notify(string message) = 0;
};

class EmailNotifier : public Notifier
{
public:
    void notify(string message)
    {

    }
};

class Broker : public Object
{
public:
    virtual int subscribe(string tipic, Handler *handler) = 0;
    virtual void unsubscribe(int id) = 0;
    virtual void publish(Message *message) = 0;
};

class MapCache : public Cache
{
private:
    map<int, Object *> entries;
    static MapCache *INSTANCE;
    MapCache() {}

public:
    static MapCache *getInstance()
    {
        if (INSTANCE == nullptr)
            INSTANCE = new MapCache();
        return INSTANCE;
    }
    void put(int key, Object *value)
    {
        entries.insert(pair<int, Object *>(key, value));
    }
    Object *get(int key)
    {
        return entries.at(key);
    }
};

MapCache *MapCache::INSTANCE = nullptr;

class SimpleBroker : public Broker
{
private:
    static SimpleBroker *INSTANCE;
    SimpleBroker() {}

public:
    static SimpleBroker *getInstance()
    {
        if (INSTANCE == nullptr)
            INSTANCE = new SimpleBroker();
        return INSTANCE;
    }

    int subscribe(string topic, Handler *handler)
    {
        return 0;
    }
    void unsubscribe(int id)
    {

    }
    void publish(Message *message)
    {

    }

};

SimpleBroker *SimpleBroker::INSTANCE = nullptr;

class InMemoryDirectory : public Directory
{
private:
    Cache *cache;
    int id;

public:
    InMemoryDirectory(Cache *cache)
    {
        this->cache = cache;
        id = 1;
    }
    int add(Employee *e)
    {
        e->setId(id++);
        cache->put(e->getId(), e);
        return e->getId();
    }
    Employee *find(int id)
    {
        return (Employee *)cache->get(id);
    }
};

class LoggingProxy : public Directory
{
private:
    Directory *target;

public:
    LoggingProxy(Directory *target)
    {
        this->target = target;
    }
    int add(Employee *e)
    {
        try
        {
            cout << "entering add: " << e->getName() << endl;
            int value = target->add(e);
            cout << "exiting add: " << value << endl;
            return value;
        }
        catch (DirectoryException *e)
        {
            cout << "handling add" << endl;
            throw e;
        }
    }

    Employee *find(int id)
    {
        try
        {
            cout << "entering find: " << id << endl;
            Employee *e = (Employee *)target->find(id);
            cout << "exiting find: " << e->getName() << endl;
            return e;
        }
        catch (DirectoryException *e)
        {
            cout << "handling find" << endl;
            throw e;
        }
    }
};

class ValidationProxy : public Directory
{
private:
    Directory *target;

public:
    ValidationProxy(Directory *target)
    {
        this->target = target;
    }
    int add(Employee *e)
    {
        try
        {
            if (e->getName() == "" || e->getPhone() < 0)
            {
                throw new InvalidEmployeeException("Invalid Employee");
            }
            return target->add(e);
        }
        catch (DirectoryException *e)
        {
            throw e;
        }
    }

    Employee *find(int id)
    {
        try
        {
            return (Employee *)target->find(id);
        }
        catch (DirectoryException *e)
        {
            cout << "handling find" << endl;
            throw e;
        }
    }
};

class AsyncDirectory : public Directory
{
private:
    Directory *target;
    Broker *broker;

public:
    AsyncDirectory(Directory *target, Broker *broker)
    {
        this->target = target;
    }

    int add(Employee *e)
    {
        broker->publish(new Message("audit", "add-employee attempted"));
        int id = target->add(e);
        broker->publish(new Message("directory", e->getName()));
        return id;
    }

    Employee *find(int id)
    {
        broker->publish(new Message("audit", "find-employee attempted"));
        return (Employee *)target->find(id);
    }
};

class ObjectFactory
{
public:
    static Object *get(string key)
    {
        if (key == "auditor")
        {
            return new SimpleAuditor();
        }

        if (key == "notifier")
        {
            return new EmailNotifier();
        }

        if (key == "directory")
        {
            Cache *cache = (Cache *)get("cache");
            return new InMemoryDirectory(cache);
        }

        if (key == "cache")
        {
            return MapCache::getInstance();
        }

        if (key == "broker")
        {
            return SimpleBroker::getInstance();
        }

        if (key == "logger-directory")
        {
            Directory *target = (Directory *)get("directory");
            return new LoggingProxy(target);
        }

        if (key == "validator-directory")
        {
            Directory *target = (Directory *)get("directory");
            return new ValidationProxy(target);
        }

        if (key == "logger-validator-directory")
        {
            Directory *target = (Directory *)get("directory");
            target = new ValidationProxy(target);
            target = new LoggingProxy(target);
            return target;
        }

        if (key == "validator-logger-directory")
        {
            Directory *target = (Directory *)get("directory");
            target = new LoggingProxy(target);
            target = new ValidationProxy(target);
            return target;
        }

        if (key == "full-system")
        {
            Directory *target = (Directory *)get("directory");
            Broker* broker = (Broker* )get("broker");
            target = new AsyncDirectory(target, broker);
            target = new LoggingProxy(target);
            target = new ValidationProxy(target);
            return target;
        }

        throw new DirectoryException("Object not available");
    }
};

int main()
{
    try
    {
        Directory *dir = (Directory *)ObjectFactory::get("logger-validator-directory");
        Broker* broker = (Broker*)ObjectFactory::get("broker");
        Auditor* auditor = (Auditor*)ObjectFactory::get("auditor");
        Notifier* notifier = (Notifier*)ObjectFactory::get("notifier");
        Handler* aHandler =(Handler*) new AuditHandler(auditor);
        Handler* nHandler =(Handler*) new EmailHandler(notifier);

        broker->subscribe("audit", aHandler);
        broker->subscribe("directory", nHandler);

        int id1 = dir->add(new Employee("Krishna", 1234));
        dir->find(id1);

        int id2 = dir->add(new Employee("Koyya", -2345));
        dir->find(id2);
    }
    catch (DirectoryException *d)
    {
        cout << d->getMessage() << endl;
    }
    return 0;
}