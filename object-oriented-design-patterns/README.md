# Object Oriented Design Patterns

## 1. Creational Patterns

### 1.1. Factory and Factory Method
**1.1.1. Intent** To separate the responsibility of object creation from its user

**1.1.2. Benefit** Helps in decoupling the application code from the service implementation

**1.1.3. Applicability** In all applications while creating an object against an interface

**1.1.4. Model**
![](models/factory-method.png)

#### 1.1.5. Problem ####
***Component.java***
```
package com.glarimy.factory;

public class Component {

	public void service() {
		System.out.println("Component::service()");
	}

}
```
***Application.java***
```
package com.glarimy.factory;

public class Application {
	public static void main(String[] args) {
		Component component = new Component();
		component.service();
	}
}
```
#### 1.1.6. Solution ####
***Component.java***

```
package com.glarimy.factory;

public interface Component {
	public void service();
}
```

***ConcreteComponent.java***

```
package com.glarimy.factory;

public class ConcreteComponent implements Component {

	@Override
	public void service() {
		System.out.println("ConcreteComponent::service");
	}

}
```

***Factory.java***
```
package com.glarimy.factory;

public interface Factory<T> {
	T get(String key) throws Exception;
}
```
***ConcreteFactory.java***
```
package com.glarimy.factory;

import java.io.FileReader;
import java.util.Properties;

public class ConcreteFactory<T> implements Factory<T> {
	private Properties props;

	public ConcreteFactory() throws Exception {
		props = new Properties();
		props.load(new FileReader("config.properties"));
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T get(String key) throws Exception {
		Class claz = Class.forName(props.getProperty(key));
		return (T)claz.newInstance();
	}
}
```

***config.properties***
```
component=com.glarimy.factory.ConcreteComponent
```

***Application.java***
```
package com.glarimy.factory;

public class Application {
	public static void main(String[] args) throws Exception {
		Factory<Component> factory = new ConcreteFactory<>();
		Component component = factory.get("component");
		component.service();
	}
}
```


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