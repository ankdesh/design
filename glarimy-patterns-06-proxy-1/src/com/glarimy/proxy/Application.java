package com.glarimy.proxy;

public class Application {
	public static void main(String[] args) throws Exception {
		Calculator calc = Factory.get(true);
		System.out.println(calc.compute(1000, 4, 6));
	}
}