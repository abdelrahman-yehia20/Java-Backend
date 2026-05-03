package com.spring.core.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		                                          With XML
		
		PersonService person = (PersonService) applicationContext.getBean("personService");
		person.save("Ali");
		person.update("Ahmed");
		
		 UserService manager = (UserService) applicationContext.getBean("managerService");
	        manager.save("momo");
	        manager.update("roro");
	        
	        
	        								// Without XML 
	        
	        ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
	        
	        UserService person1 = context.getBean("personService", UserService.class);
	        person1.save("new person xml");
	        person1.update("new person updated ");
	        
	        UserService person2 = context.getBean("managerService", UserService.class);
	        person1.save("new person xml");
	        person1.update("new person updated ");

	}

}
	