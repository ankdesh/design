package com.dir.service;

import java.util.List;

import com.client.ObjectFactory;
import com.dir.api.Directory;
import com.dir.api.domain.Profile;
import com.dir.api.exceptions.DirectoryException;
import com.dir.api.exceptions.InvalidProfileException;
import com.dir.api.exceptions.ProfileNotFoundException;

public class SimpleDirectory implements Directory {
	private Storage storage;

	public SimpleDirectory() throws DirectoryException {
		storage = (Storage) ObjectFactory.get("storage");
	}

	@Override
	public Profile add(Profile profile) throws InvalidProfileException, DirectoryException {
		if (profile == null || profile.getName() == null || profile.getName().length() < 8)
			throw new InvalidProfileException();
		return storage.create(profile);
	}

	@Override
	public Profile find(String id) throws ProfileNotFoundException, DirectoryException {
		Profile profile = storage.read(id);
		if (profile == null)
			throw new ProfileNotFoundException();
		return profile;
	}

	@Override
	public List<Profile> list() throws DirectoryException {
		return storage.read();
	}

}
