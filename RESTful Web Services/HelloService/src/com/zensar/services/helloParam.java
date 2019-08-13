package com.zensar.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/zenParam")
public class helloParam {
	@Path("/welcome/{nm}")
	@GET
	@Produces("text/html")
	public Response getMessage(@PathParam("nm") String name)
	{
		return Response
				.status(200)
				.entity("<p> Hello <b><i>" + name +"Welcome to zensar for hello service </p>")
				.build();
	}
	
	
	@Path("/birthday/{dd}/{mm}/{yyyy}")
	@GET
	@Produces("text/html")
	public Response getMsg(@PathParam("dd") int date,@PathParam("mm") int month,@PathParam("yyyy") int year)
	{
		return Response
				.status(200)
				.entity("<p> Birthday " + date +"" +month+""+year+ "</p>")
				.build();
	}
}
