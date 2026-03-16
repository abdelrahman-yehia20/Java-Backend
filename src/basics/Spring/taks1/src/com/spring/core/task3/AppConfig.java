package com.spring.core.task3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public PersonService personService() {
        return new PersonService();
    }

}
