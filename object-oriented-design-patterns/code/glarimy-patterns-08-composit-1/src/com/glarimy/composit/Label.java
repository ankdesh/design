package com.glarimy.composit;

public class Label implements Component {
	@Override
	public void hide() {
		System.out.println("Label hiding");
	}

	@Override
	public void show() {
		System.out.println("Label showing");
	}
}
