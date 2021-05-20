# Object Oriented Design Patterns

## 1. Creational Patterns

### 1.1. Factory and Factory Method
**1.1.1. Intent** To separate the responsibility of object creation from its user

**1.1.2. Applicability** In all applications while creating an object against an interface

**1.1.3. Benefit** Helps in decoupling the application code from the service implementation

**1.1.4. Class Model**

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
**1.3.1. Intent** To limit the number of instances of a class to a maximum of one

**1.3.2. Applicability** Normally used in configuration, cache and etc., 

**1.3.3. Benefits** Helps in maintaining the application context in memory

**1.3.4. Class Model**

![](models/singleton.png)

**1.3.5. Problem**

***Component.java***
```
package com.glarimy.singleton;

public class Component {
	public void service() {
		System.out.println("Component::execute");
	}

}
```

***Application.java***
```
package com.glarimy.singleton;

public class Application {
	public static void main(String[] args) throws Exception {
		Component component = new Component();
		component.service();
	}
}
```

**1.3.6. Solution**

***Component.java***
```
package com.glarimy.singleton;

public class Component {

	private static Component INSTANCE = null;

	private Component() {

	}

	public static synchronized Component getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Component();
		return INSTANCE;
	}

	public void service() {
		System.out.println("Component::execute");
	}

}
```

***Application.java***
```
package com.glarimy.singleton;

public class Application {
	public static void main(String[] args) throws Exception {
		Component component = Component.getInstance();
		component.service();
	}
}
```
## 2. Structural Patterns

### 2.1. Adapter
**2.1.1. Intent** To provide a known interface to an unknown object

**2.1.2. Applicability** Often used as a protection layer between application and third-party components 

**2.1.3. Benefits** Avoids tight coupling with third-party code

**2.1.4. Class Model**

![](models/adapter-classes.png)

**2.1.5. Collaboration Model**

![](models/adapter-collaborations.png)

**2.1.6. Problem**

***Component.java***
```
package com.glarimy.adapter;

public class Component {

	public void service() {
		System.out.println("Component::service()");
	}

}
```

***Application.java***
```
package com.glarimy.adapter;

public class Application {
	public static void main(String[] args) {
		Component component = new Component();
		component.service();
	}
}
```

**2.1.7. Solution**

***Component.java***
```
package com.glarimy.thirdparty;

public class Component {

	public void service() {
		System.out.println("Component::service()");
	}

}
```

***Adapter.java***
```
package com.glarimy.app;

public interface Adapter {
	public void adapt();
}
```

***ConcreteAdapter.java***
```
package com.glarimy.app;

import com.glarimy.thirdparty.Component;

public class ComponentAdapter implements Adapter {
	private Component component;

	public ComponentAdapter() {
		this.component = new Component();
	}

	@Override
	public void adapt() {
		this.component.service();
	}

}
```

***Application.java***
```
package com.glarimy.app;

public class Application {
	public static void main(String[] args) {
		Adapter adapter = new ComponentAdapter();
		adapter.adapt();
	}
}
```
