package com.glarimy.directory.api;

public interface Factory<T> {
	T get(String key) throws Exception;
}