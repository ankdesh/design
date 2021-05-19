package com.glarimy.decorator;

public class Application {
	public static void main(String[] args) throws Exception {
		Square square = new Square();
		square.setSide(10);
		square.area();
		Decorator decorator = new Decorator(square);
		decorator.perimeter();
	}
}