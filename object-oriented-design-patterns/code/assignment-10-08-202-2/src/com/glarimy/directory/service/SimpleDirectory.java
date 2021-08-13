package com.glarimy.directory.service;

import com.glarimy.directory.api.Directory;
import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.Factory;
import com.glarimy.directory.api.InvalidRequestException;
import com.glarimy.directory.api.NewEmployee;
import com.glarimy.directory.api.SimpleFactory;
import com.glarimy.directory.domain.EmployeeEntity;

public class SimpleDirectory implements Directory {
	private Storage storage;

	public SimpleDirectory() throws Exception {
		Factory<Storage> factory = new SimpleFactory<Storage>();
		storage = factory.get("storage");
	}

	@Override
	public Employee add(NewEmployee e) throws InvalidRequestException, DirectoryException {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setName(e.getName());
		entity.setPhone(e.getPhone());

		entity = storage.save(entity);

		Employee emp = new Employee();
		emp.setId(entity.getId());
		emp.setName(entity.getName());
		emp.setPhone(entity.getPhone());

		return emp;

	}

}
