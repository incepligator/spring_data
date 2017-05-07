package com.cubic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.CustomerEntity;
import com.cubic.repo.CustomerRepo;

@Service("c1")
@Transactional(propagation=Propagation.SUPPORTS)
public class ChildTransaction implements CustomerTransaction {

	@Autowired
	private CustomerRepo repo;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createCustomer() {
	
		save("Child","Transaction");
	}

	
	private void save(final String firstName, final String lastName){
		
		CustomerEntity entity= new CustomerEntity();
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		repo.save(entity);
		
	}
}
