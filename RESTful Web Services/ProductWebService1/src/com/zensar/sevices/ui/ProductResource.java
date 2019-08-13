package com.zensar.sevices.ui;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zensar.entities.Product;
import com.zensar.services.business.ProductServiceImpl;
import com.zensar.services.business.ProductServices;

/*
Author: Trigun Rai
Creation Date: 26th Jul 2019 12:15PM
Modification Date: 26th Jul 2019 12:15PM
Version:1.0
Copyright:Zensar Technnologies. All rights reserved
Description:Product Web Service
itprovides through RESTful Web Services
*/
@Path("/products")
public class ProductResource {
	private ProductServices productService;
	public ProductResource() {
		// TODO Auto-generated constructor stub
		productService=new ProductServiceImpl();
	}
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public List<Product> getAllProducts(){
	return productService.findAllProducts();
}
	@Path("/{id}")
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public Response getProduct(@PathParam("id") int productid){
		Product product=productService.findProductById(productid);
				if(product!=null)
					return Response.status(200).entity(product.toString()).build();
				else
					return Response.status(200).entity("Product" + productid + "not found").build();
	}
	@Path("/product/{id}")
	@GET
	@Produces({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public Product getProductById(@PathParam("id")int productid){
		return productService.findProductById(productid);
	}
	@Path("/count")
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	/*public Response getProductCount(){
		return Response.status(200).entity("Number of Products:"+productService.getProductCount()).build();
	}*/
	public String getProductCount(){
		return "Number of Products:"+productService.getProductCount();
	}
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createProduct(@FormParam("id")int productid,@FormParam("name")String name,@FormParam("brand")String brand,@FormParam("price") float price){
		Product product=new Product(productid,name,brand,price);
		productService.create(product);
		return Response.ok().build();
	}
	@Path("/delete/{id}")
	@DELETE
	@Produces("text/html")
	public String removeProduct(@PathParam("id")int productid){
		Product product=productService.findProductById(productid);
		if(product!=null)
		{
			productService.remove(product);
			return "Product" + productid + "deleted";
		}else{
			return "Product" +productid+ "not removed";
				
		}
	}
}
