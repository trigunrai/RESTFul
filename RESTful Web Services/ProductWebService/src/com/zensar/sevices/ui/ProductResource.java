package com.zensar.sevices.ui;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	@Produces({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
public List<Product> getAllProducts(){
	return productService.findAllProducts();
}
}
