package com.glarimy.directory.api;

import java.io.FileReader;
import java.util.Properties;

public class SimpleFactory<T> implements Factory<T> {
	Properties config;

	public SimpleFactory() throws Exception {
		config = new Properties();
		config.load(new FileReader("config.properties"));
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T get(String key) throws Exception {
		String className = config.getProperty(key);
		Class claz = Class.forName(className);
		Object obj = claz.newInstance(); // Simple Directory
		String logger = config.getProperty(key + "." + "logging");
		if (logger != null) {
			Class loggerClaz = Class.forName(logger);
			Object loggingProxy = loggerClaz.getConstructor(claz.getInterfaces()[0]).newInstance(obj);
			obj = (T) loggingProxy; // Logger
		}
		String validator = config.getProperty(key + "." + "validation");
		if (validator != null) {
			Class validationClaz = Class.forName(validator);
			Object validationProxy = validationClaz.getConstructor(claz.getInterfaces()[0]).newInstance(obj);
			return (T) validationProxy; // Validator
		}
		return (T) obj;
	}
}
