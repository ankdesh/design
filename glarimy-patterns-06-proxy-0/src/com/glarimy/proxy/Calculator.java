package com.glarimy.proxy;

public class Calculator {

	public double compute(double p, double t, double r) throws Exception {
		if (p < 0 || t < 0 || r < 0)
			throw new Exception("Invalid input");
		return p*t*r/100;
	}

}
