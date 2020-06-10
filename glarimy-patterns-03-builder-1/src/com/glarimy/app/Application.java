package com.glarimy.app;

import com.glarimy.builder.Order;
import com.glarimy.builder.OrderBuilder;

public class Application {
	public static void main(String[] args) throws Exception {
		Order order = new OrderBuilder(123, "Bengaluru").withGiftWrapping().requirePriorityDelivery().build();
		System.out.println(order);
	}
}
