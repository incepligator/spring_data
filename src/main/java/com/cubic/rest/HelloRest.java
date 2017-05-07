package com.cubic.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.cubic.entity.CustomerEntity;
import com.cubic.test.GetCustomer;
import com.cubic.test.GetCustomerById;
import com.cubic.test.PostCustomer;
import com.cubic.test.PutCustomer;


@Service
@Path("/helloworld")
public class HelloRest {
	
	
	@GET
	public String sayHello(){
		
		
		return "Welcomee to rest world ";
		
	}
	
	
	@GET
	@Path("/getcustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<CustomerEntity> getCustomer(){
		
		GetCustomer gets= new GetCustomer();
		
		
		return gets.Connection();
		
	}

	@GET
	@Path("/getcustomername/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public  List<CustomerEntity> getCustomerById(@PathParam("id")String id){
		
		GetCustomerById gcbid= new GetCustomerById();
		
		
		return gcbid.main(id);
		
	}
	

/*	@GET
	@Path("/emp/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Employee findEmployeeById(@PathParam("id")final String id){
	
	Employee emp= new Employee();
	emp.setName("Shrawan");
	emp.setAge(30);
	
	return emp;
	
	}*/
	
	@GET
	@Path("/emp/{id}/{age}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Employee findEmployeeById(@PathParam("id")String id,
			                         @PathParam("age")int age){
	
	Employee emp= new Employee();
	emp.setName(id);
	emp.setAge(age);
	
	return emp;
	
	}
	
	
	@POST
	@Path("/postcustomer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public   CustomerEntity postCustomer(CustomerEntity cus){
	
		return PostCustomer.addCustomer(cus);
	
	}
	
	@POST
	@Path("/postcustomerparam/{fname}/{lname}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public   CustomerEntity postCustomerParam(@PathParam("fname")String fname,
                                              @PathParam("lname")String lname){
	
		return PostCustomer.addCustomer(fname,lname);
	
	}
	
	@PUT
	@Path("/postcustomerparam/{id}/{fname}/{lname}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public   CustomerEntity postCustomerParam(@PathParam("id")Long id,
											  @PathParam("fname")String fname,
                                              @PathParam("lname")String lname){
	
		return PutCustomer.updateCustomer(id,fname,lname);
	
	}
	
	@PUT
	@Path("/postcustomerparam/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public   CustomerEntity postCustomerParam(@PathParam("id")Long id, CustomerEntity cus ){
	
		return PutCustomer.updateCustomer(id, cus);
	
	}
	
	
	
	
	
	
}
