package com.glarimy.directory.service;

import com.glarimy.directory.api.Directory;
import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.InvalidRequestException;
import com.glarimy.directory.api.NewEmployee;

public class SecurityProxy implements Directory {
	private Directory target;

	public SecurityProxy(Directory target) {
		this.target = target;
	}

	@Override
	public Employee add(NewEmployee e) throws InvalidRequestException, DirectoryException {
		if(!SecurityManager.isAuthenticated())
			SecurityManager.authenticate();
		
		Employee result = target.add(e);
		
		SecurityManager.logout();

		return result;
	}

}