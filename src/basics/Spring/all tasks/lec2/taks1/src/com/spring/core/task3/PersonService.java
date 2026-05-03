package com.spring.core.task3;

public class PersonService implements UserService {

	@Override
	public void save(String name) {
		System.out.println("person saved " + name);
		
	}

	public void init() {
		System.out.println("init method executed");
	}

	public void destroy() {
		System.out.println("destroy method executed");
	}
}
