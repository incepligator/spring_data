package com.cubic.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.util.StringUtils;


public class EmployeeDB {

	private static final EmployeeDB instance = new EmployeeDB();
	
	private Map<String,Employee> empoyeeTlb = new HashMap<String,Employee>();
	
	private EmployeeDB() {}
	
	public static EmployeeDB get() {
		return instance;
	}
	
	public Employee add(final Employee emp) {
		emp.setId(UUID.randomUUID().toString());
		empoyeeTlb.put(emp.getId(), emp);
		return emp;
	}
	
	public void modify(final Employee emp) {
		if(!StringUtils.isEmpty(emp.getId())) {
			empoyeeTlb.put(emp.getId(), emp);
		}
	}	
	
	public void remove(final String id) {
		empoyeeTlb.remove(id);
	}
	
	public Employee findById(final String id) {
		return empoyeeTlb.get(id);
	}
	
	public Collection<Employee> getAllEmployees() {
		return empoyeeTlb.values();
	}	
	
}
