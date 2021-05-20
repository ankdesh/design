package com.glarimy.decorator;

public class ConcreteComponent implements Component {
	@Override
	public void mandatory() {
		System.out.println("Component::mandatory");
	}
	public void optional() {
		System.out.println("Component::optional");
	}
}
