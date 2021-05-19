package com.glarimy.builder;

public class OrderBuilder {
	private Order order;

	public OrderBuilder(int pid, String address) {
		order = new Order();
		order.pid = pid;
		order.address = address;
	}

	public OrderBuilder quantityOf(int number) {
		order.qty = number;
		return this;
	}

	public OrderBuilder withGiftWrapping() {
		order.gift = true;
		return this;
	}

	public OrderBuilder requirePriorityDelivery() {
		order.priority = true;
		return this;
	}

	public Order build() {
		if (order.qty == 0)
			order.qty = 1;
		return order;
	}

}
