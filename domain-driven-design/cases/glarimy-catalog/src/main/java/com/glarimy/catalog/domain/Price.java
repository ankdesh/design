package com.glarimy.catalog.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Price {
	private double value;
	private String currency;

	public Price(double value, String currency) {
		super();
		this.value = value;
		this.currency = currency;
	}

	public double getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}
}