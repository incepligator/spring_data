package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnectionTest {

	static EntityManagerFactory emf=null;
	static EntityManager em=null;
	static EntityTransaction et=null;
	
	
	public static void main(String[] args) {
		
		connect();
		
		
	}
	
	static   void connect() {
		
		
		
		
		try {
			
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			
			et=em.getTransaction();
			et.begin();
			
			System.out.println("Connection Establised Test");
			
			
			
			
	}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(em!=null){
				
				em.close();
			}
			if(emf!=null){
				
				emf.close();
			}
			System.out.println("Connection Closed");
		}

	}

}
