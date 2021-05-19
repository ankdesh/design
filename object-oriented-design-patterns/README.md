# Object Oriented Design Patterns

## 1. Creational Patterns

### 1.1. Factory and Factory Method
**Intent** To separate the responsibility of object creation from its user

**Benefit** Helps in decoupling the application code from the service implementation

**Applicability** In all applications while creating an object against an interface

![](models/factory-method.png)

### 1.2. Abstract Factory
**Intent** To choose a factory from several available factories for a given interface

**Benefits** Helps in decoupling client applications from the vendor implementations

**Applicability** In cases where the API and its implementation are done by different vendors

![](models/abstract-factory.png)

### 1.3. Singleton
**Intent** To limit the number of instances of a class to a maximum of one

**Benefits** Helps in maintaining the application context in memory

**Applicability** Normally used in configuration, cache and etc., 

![](models/singleton.png)