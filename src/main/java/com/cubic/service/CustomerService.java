package com.cubic.service;

import java.util.List;

import com.cubic.vo.CustomerVO;

public interface CustomerService {

	CustomerVO save(final CustomerVO vo);
	
	List<CustomerVO> search(final String name);
	
	void remove(final Long pk);
	
	CustomerVO findCustomer(final Long pk);
	
	
}