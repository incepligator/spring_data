package com.cubic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cubic.entity.CustomerEntity;

public interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {
	
	@Query("select c from CustomerEntity c where UPPER(c.firstName) like UPPER(?1) or UPPER(c.lastName) like UPPER(?1)")
	List<CustomerEntity> searchCustomers(final String name);
	

}
