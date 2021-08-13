package com.glarimy.directory.client;

import com.glarimy.directory.api.Directory;
import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.Factory;
import com.glarimy.directory.api.InvalidRequestException;
import com.glarimy.directory.api.NewEmployee;
import com.glarimy.directory.api.SimpleFactory;

public class Application {

	public static void main(String[] args) throws Exception {
		Factory<Directory> factory = new SimpleFactory<Directory>();
		Directory dir = factory.get("dir");
		NewEmployee emp = new NewEmployee();
		emp.setName(null);
		emp.setPhone(123456);
		try {
			Employee employee = dir.add(emp);
			System.out.println("Added new employee with ID: " + employee.getId());
			
			dir.sort();
		} catch (InvalidRequestException e) {
			e.printStackTrace();
		} catch (DirectoryException e) {
			e.printStackTrace();
		}
	}

}
