package com.glarimy.cms.domain;

import java.util.regex.Pattern;

public class PIN {
	int code;

	public PIN(int code) {
		if (Pattern.compile("^[1-9][0-9]{5}$", Pattern.CASE_INSENSITIVE).matcher(Integer.toString(code)).find())
			this.code = code;
		else
			throw new RuntimeException();
	}
}
