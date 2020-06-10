package com.glarimy.builder;

public class Order {
	int pid;
	int qty;
	String address;
	boolean gift;
	boolean priority;

	Order() {
	}

	@Override
	public String toString() {
		return "Order [pid=" + pid + ", qty=" + qty + ", address=" + address + ", gift=" + gift + ", priority="
				+ priority + "]";
	}

}
