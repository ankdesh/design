package com.glarimy.composit;

public class Button implements Component {
	@Override
	public void hide() {
		System.out.println("Button hiding");
	}

	@Override
	public void show() {
		System.out.println("Button showing");
	}
}
