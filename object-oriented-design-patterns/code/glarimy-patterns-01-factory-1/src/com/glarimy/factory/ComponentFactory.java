package com.glarimy.factory;

public class ComponentFactory {
	public static Component get() {
		return new ConcreteComponent();
	}
}
