package com.glarimy.proxy;

public class Factory {
	public static  Calculator get(boolean validation) {
		Calculator calc = new ConcreteCalculator();
		if (validation)
			return new ValidationProxy(calc);
		return calc;
	}
}
