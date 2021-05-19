package com.glarimy.factory;

import java.util.Date;

public class ConcreteComponent implements Component {

	@Override
	public void execute() {
		System.out.println(new Date() + " - " + this.getClass().getName() + "::execute");
	}

}
