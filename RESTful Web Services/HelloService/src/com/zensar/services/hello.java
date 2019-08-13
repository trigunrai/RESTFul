package com.zensar.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/zenhello")
public class hello {

	@GET	
	@Produces(MediaType.TEXT_PLAIN)
		public String sayPlainHello(){
			return "Hello from Zensar";
		}
	@Path("/welcome")
		@GET
		@Produces("text/HTML")
		public String sayHtmlHello(){
			return "<body bgcolor='pink'>"+
		"<p> Welcome to zensar html</p>"+
		"</body>";
		}
	@Path ("/welcomexml")
	@GET
	@Produces(MediaType.APPLICATION_ATOM_XML)
	public String sayXmlHello()
	{
		return "<?xml version='1.0'>"+
				"<messages>"+
				"<message>Hello world from Zensar xml</message>"
				+ "<messages>";
	}
}
