package com.glarimy.directory.service;

import com.glarimy.directory.api.Directory;
import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.InvalidRequestException;
import com.glarimy.directory.api.NewEmployee;

public class LoggingProxy implements Directory {
	private Directory target;

	public LoggingProxy(Directory target) {
		this.target = target;
	}

	@Override
	public Employee add(NewEmployee e) throws InvalidRequestException, DirectoryException {
		System.out.println("Invoking add method");
		Employee result = target.add(e);
		System.out.println("Returning employee");
		return result;
	}

}