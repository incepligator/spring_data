package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.entity.CustomerEntity;

public class PutCustomer {

	public static CustomerEntity updateCustomer(Long id, String fname,String lname) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		EntityTransaction et=null;
		
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			et=em.getTransaction();
			et.begin();
			
			System.out.println("Connection Establised ");
			
			CustomerEntity entity= em.find(CustomerEntity.class, new Long(id));
			
			entity.setFirstName(fname);
			entity.setLastName(lname);
			et.commit();
		
			
				em.close();
				
				emf.close();
				return entity;
			
	}
	
public static CustomerEntity updateCustomer(Long id, CustomerEntity cus) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		EntityTransaction et=null;
		
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			et=em.getTransaction();
			et.begin();
			
			
			System.out.println("Connection Establised ");
			
			CustomerEntity entity= em.find(CustomerEntity.class, new Long(id));
			
			entity.setFirstName(cus.getFirstName());
			entity.setLastName(cus.getLastName());
			et.commit();
		
				em.close();
				
				emf.close();
				return entity;
			
		

	}
}
