package com.glarimy.factory;

public class Application {
	public static void main(String[] args) throws Exception {
		ObjectFactory factory = new ObjectFactory("conf.properties");
		Component component = (Component) factory.get("component");
		component.execute();
	}
}
