package com.glarimy.decorator;

public class Square {
	private int side;

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public void area() {
		System.out.println("Area: " + side * side);
	}

}
