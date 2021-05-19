package com.glarimy.factory;

public class Application {
	public static void main(String[] args) {
		Component component = ComponentFactory.get();
		component.execute();
	}
}
