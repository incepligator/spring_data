package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.entity.CustomerEntity;


public class GetCustomer {
	
	
	public static  List<CustomerEntity> Connection() {
		
		
				
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		
		
			
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			
			
			
			System.out.println("Connection Establised ");
			
						
			TypedQuery<CustomerEntity> query = em.createQuery("select x from CustomerEntity x", CustomerEntity.class);
			
			List<CustomerEntity> results=query.getResultList();
			
			for (CustomerEntity entity:results){
				
				System.out.println(entity);
			}
			
			
			return results;
		
		
		
		
		
		

	}

}
