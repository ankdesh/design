package com.glarimy.cms.domain;

import java.util.regex.Pattern;

public class Email {
	String value;

	public Email(String value) {
		if (Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(value)
				.find())
			this.value = value;
		else
			throw new RuntimeException();
	}
}