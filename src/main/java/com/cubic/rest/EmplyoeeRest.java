package com.cubic.rest;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.cubic.util.Employee;
import com.cubic.util.EmployeeDB;


@Service
@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmplyoeeRest {

	
	
	@GET
	@Path("/{id}")
	public Response findEmployeeBYID(@PathParam("id") final String empId){
		Employee entity=EmployeeDB.get().findById(empId);
		return Response.ok().entity(entity).build();
	}
	

	@POST
	public Response createEmployee(final Employee employee){
		Employee result=EmployeeDB.get().add(employee);
		return Response.ok().entity(result).build();
	}
	
	
	
	@PUT
	public Response updateEmployee(final Employee employee){
		EmployeeDB.get().modify(employee);
		return Response.noContent().build();
	}
	
	
	@PUT
	@Path("/xml")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	
	public Response updateEmployeeXML(final Employee employee){
		EmployeeDB.get().modify(employee);
		
		Response.ResponseBuilder rb= Response.ok();
		
		
				
		if(employee.getAge()<30){
			rb=rb.entity(employee).type(MediaType.APPLICATION_JSON);
			
		}
		else{
			rb=rb.entity(employee).type(MediaType.APPLICATION_XML);
		}
		
		return rb.build();
	}
		
	@GET
	@Path("/xml/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response findEmployeeBYIDXML(@PathParam("id") final String empId){
		Employee entity=EmployeeDB.get().findById(empId);
		return Response.ok().entity(entity).build();
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response removeEmployee(@PathParam("id") final String empId){
		EmployeeDB.get().remove(empId);
		return Response.noContent().build();
		
	}
	

	
	@GET
	
	public Response employeeById(@QueryParam("name") final String name,
			@QueryParam("age")final Integer age ){
		
		Employee entity=new Employee();
		
		entity.setAge(age);
		entity.setName(name);
		entity.setId(UUID.randomUUID().toString());
		
		return Response.ok().entity(entity).build();
		
	}
	
	@GET
	@Path("/matrix")
	public Response employeeMatrixQuery(@MatrixParam("name") final String name,
										@MatrixParam("age")final Integer age ){
		
		
		
		Employee entity=new Employee();
		
		entity.setAge(age);
		entity.setName(name);
		entity.setId(UUID.randomUUID().toString());
		return Response.ok().entity(entity).build();
		
	}
}
