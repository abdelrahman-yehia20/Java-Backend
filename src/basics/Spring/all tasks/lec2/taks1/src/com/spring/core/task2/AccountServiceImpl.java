package com.spring.core.task2;

public class AccountServiceImpl implements AccountService {

	public UserService personService; 
	
	public void setPersonService(UserService personService ) {
		this.personService = personService;
	}
	
	@Override
	public void getSavePerson(String name) {
		personService.save(name);
	}

}
