package com.cubic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.CustomerEntity;
import com.cubic.repo.CustomerRepo;

@Service("p1")
@Transactional(propagation=Propagation.SUPPORTS)
public class ParentTransaction implements CustomerTransaction {

	@Autowired
	private CustomerRepo repo;
	
	
	@Autowired
	@Qualifier("c1")
	private CustomerTransaction ct;
	
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void createCustomer() {
	
		save("Parent","Transaction");
		
		ct.createCustomer();
		
		throw new RuntimeException("Failed");
	}

	private void save(final String firstName, final String lastName){
		
		CustomerEntity entity= new CustomerEntity();
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		repo.save(entity);
		
	}
}
