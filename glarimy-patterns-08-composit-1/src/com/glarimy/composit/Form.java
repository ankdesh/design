package com.glarimy.composit;

public class Form extends AbstractContainer {
	@Override
	public void hide() {
		super.hide();
		System.out.println("Form hiding");
	}

	@Override
	public void show() {
		System.out.println("Form showing");
		super.show();
	}
}
