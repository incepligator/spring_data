package com.cubic.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

	public static void main(String[] args) {
		

		
		ApplicationContext context= new ClassPathXmlApplicationContext("SpringJPA.xml");
		
		CustomerTransaction trans = context.getBean("p1", CustomerTransaction.class);
		
		trans.createCustomer();
	}

}
