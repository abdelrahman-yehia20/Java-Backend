package com.spring.core.task1;

public class ManagerService implements UserService {

	@Override
	public void save(String name) {

		System.out.println("manager saved " + name);
	}

	@Override
	public void update(String name) {
		System.out.println("manager updated " + name);
		
	}

}
