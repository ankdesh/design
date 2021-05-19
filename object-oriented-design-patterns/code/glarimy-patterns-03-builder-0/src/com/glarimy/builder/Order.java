package com.glarimy.builder;

public class Order {
	private int pid;
	private int qty;
	private String address;
	private boolean gift;
	private boolean priority;

	public Order(int pid, int qty, String address, boolean gift, boolean priority) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.address = address;
		this.gift = gift;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Order [pid=" + pid + ", qty=" + qty + ", address=" + address + ", gift=" + gift + ", priority="
				+ priority + "]";
	}

}
