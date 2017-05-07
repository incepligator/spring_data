package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cubic.entity.CustomerEntity;





public class GetCustomerById {

	
	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction et;
	
	public static void Connection(){
	
	
	emf=Persistence.createEntityManagerFactory("OracleUnit");
	em=emf.createEntityManager();
	
	et=em.getTransaction();
	et.begin();
	
	System.out.println("Connection Establised Test");
	
}
	
	public static List<CustomerEntity> main(String id) {
		
		
			Connection();
		
		  Query query = em.createNamedQuery("find CustomerEntity by id");
		  query.setParameter("id", id);
		      
		      List<CustomerEntity> list = query.getResultList();
		      
		         for(CustomerEntity e:list ){
		    	  System.out.println(e);
		       
		      }
				return list;
	}
	
}
