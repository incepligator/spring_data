package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.entity.CustomerEntity;


public class PostCustomer {
	
	

	public static CustomerEntity addCustomer(CustomerEntity cus ) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		EntityTransaction et=null;
		
		
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			et=em.getTransaction();
			et.begin();
			
			System.out.println("Connection Establised ");
			
			CustomerEntity entity= new CustomerEntity();
			
			entity.setFirstName(cus.getFirstName());
			entity.setLastName(cus.getLastName());
			
			em.persist(entity);
			
			et.commit();
			
			return entity;
			
			
			
			
	}
	
	public static CustomerEntity addCustomer(String fname, String lname ) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		EntityTransaction et=null;
		
		
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			et=em.getTransaction();
			et.begin();
			
			System.out.println("Connection Establised ");
			
			CustomerEntity entity= new CustomerEntity();
			
			entity.setFirstName(fname);
			entity.setLastName(lname);
			
			em.persist(entity);
			
			et.commit();
			
			return entity;
			
			
			
			
	}

}
