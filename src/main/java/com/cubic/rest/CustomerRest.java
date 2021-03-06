package com.cubic.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.service.CustomerService;
import com.cubic.vo.CustomerSearchResult;
import com.cubic.vo.CustomerVO;

@Service
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerRest{
	
	@Autowired
	private CustomerService service;
	
	@POST
	public Response create(final CustomerVO vo){
		
		CustomerVO result=service.save(vo);
		return Response.ok().entity(result).build();
		
	}
	
	@PUT
	public Response update(final CustomerVO vo){
		CustomerVO result=service.save(vo);
		return Response.ok().entity(result).build();
	}
	
	@GET
	@Path("/{id}")
	public Response findCustomer(@PathParam("id") final Long pk){
		CustomerVO result=service.findCustomer(pk);
		return Response.ok().entity(result).build();
	}
	
	@GET
	public Response searchCustomer(@QueryParam("searchStr") final String name){
		List<CustomerVO> customers=service.search(name);
		CustomerSearchResult entity=new CustomerSearchResult();
		
		entity.setCustomers(customers);
		
		return Response.ok().entity(entity).build();
	}
	
	
	
	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") final Long pk){
		service.remove(pk);
		return Response.noContent().build();
	}
	
	
}