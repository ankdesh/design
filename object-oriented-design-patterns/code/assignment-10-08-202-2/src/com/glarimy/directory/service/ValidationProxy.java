package com.glarimy.directory.service;

import com.glarimy.directory.api.Directory;
import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.InvalidRequestException;
import com.glarimy.directory.api.NewEmployee;

public class ValidationProxy implements Directory {
	private Directory target;

	public ValidationProxy(Directory target) {
		this.target = target;
	}

	@Override
	public Employee add(NewEmployee e) throws InvalidRequestException, DirectoryException {
		System.out.println("Validating");
		if (e == null || e.getName() == null || e.getPhone() < 0)
			throw new InvalidRequestException();
		return target.add(e);
	}

}