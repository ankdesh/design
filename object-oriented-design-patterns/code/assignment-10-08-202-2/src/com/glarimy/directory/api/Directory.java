package com.glarimy.directory.api;

public interface Directory {
	public Employee add(NewEmployee e) throws InvalidRequestException, DirectoryException;
}
