package com.glarimy.directory.service;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.directory.domain.EmployeeEntity;

public class InMemoryStorage implements Storage {
	private Map<Integer, EmployeeEntity> employees;

	public InMemoryStorage() {
		employees = new HashMap<Integer, EmployeeEntity>();
	}

	@Override
	public EmployeeEntity save(EmployeeEntity entity) {
		entity.setId(employees.size() + 1);
		employees.put(entity.getId(), entity);
		return entity;
	}

}
