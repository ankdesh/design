package com.glarimy.decorator;

public class Decorator extends Square {
	private Square target;

	public Decorator(Square target) {
		this.target = target;
	}

	@Override
	public void area() {
		target.area();
	}

	public void perimeter() {
		System.out.println("Perimeter: " + 4 * target.getSide());
	}
}
