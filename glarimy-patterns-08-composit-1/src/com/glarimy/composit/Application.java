package com.glarimy.composit;

public class Application {
	public static void main(String[] args) throws Exception {
		Form form = new Form();
		form.add(new Label());
		form.add(new Button());
		Window window = new Window();
		window.add(form);
		window.show();
		window.hide();
	}
}