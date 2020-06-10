package com.glarimy.singleton;

import java.util.Date;

public class Component {

	private static Component INSTANCE = null;

	private Component() {

	}

	public static synchronized Component getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Component();
		return INSTANCE;
	}

	public void execute() {
		System.out.println(new Date() + " - " + this.getClass().getName() + "::execute");
	}

}
