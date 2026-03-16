package com.spring.core.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        AccountService accountService =
//                (AccountService) context.getBean("accountService");
//
//        accountService.getSavePerson("Ali");
        
//      without XML
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService accountService =
                context.getBean(AccountService.class);

        accountService.getSavePerson("AMR");
        
    }
    

    

    

 }

