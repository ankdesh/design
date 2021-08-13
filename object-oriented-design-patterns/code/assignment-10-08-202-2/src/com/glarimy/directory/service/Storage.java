package com.glarimy.directory.service;

import com.glarimy.directory.domain.EmployeeEntity;

public interface Storage {
	public EmployeeEntity save(EmployeeEntity entity);
}
