package com.spring.core.task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		                                          With XML
		
		PersonService person = (PersonService) applicationContext.getBean("personService");
		person.save("with xml ");
		applicationContext.close();
	        								// Without XML 
	        
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.save("witout xml");

        context.close();

	}

}
	