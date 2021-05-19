package com.glarimy.proxy;

public class Application {
	public static void main(String[] args) throws Exception {
		Calculator calc = new Calculator();
		System.out.println(calc.compute(10000, 4, 6));
	}
}