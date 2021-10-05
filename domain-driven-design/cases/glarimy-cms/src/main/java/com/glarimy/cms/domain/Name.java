package com.glarimy.cms.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class Name {
	@NotNull
	@Length(min = 4, max = 32)
	@Pattern(regexp = "^[(A-Za-z)]")
	private String firstName;

	@NotNull
	@Length(min = 1, max = 32)
	@Pattern(regexp = "^[(A-Za-z)]")
	private String lastName;
}
