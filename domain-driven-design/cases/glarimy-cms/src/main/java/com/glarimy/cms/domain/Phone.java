package com.glarimy.cms.domain;

import java.util.regex.Pattern;

public class Phone {
	long number;

	public Phone(long number) {
		if (Pattern.compile("^[1-9][0-9]{5}$", Pattern.CASE_INSENSITIVE).matcher(Long.toString(number)).find())
			this.number = number;
		else
			throw new RuntimeException();
	}
}
