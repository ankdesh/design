package com.glarimy.builder;

public class Application {
	public static void main(String[] args) throws Exception {
		Order order = new Order(1234, 10, "Bengaluru", false, true);
		System.out.println(order);
	}
}
