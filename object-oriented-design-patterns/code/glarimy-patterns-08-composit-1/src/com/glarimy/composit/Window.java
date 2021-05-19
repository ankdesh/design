package com.glarimy.composit;

public class Window extends AbstractContainer {
	@Override
	public void hide() {
		super.hide();
		System.out.println("Window hiding");
	}

	@Override
	public void show() {
		System.out.println("Window showing");
		super.show();
	}
}
