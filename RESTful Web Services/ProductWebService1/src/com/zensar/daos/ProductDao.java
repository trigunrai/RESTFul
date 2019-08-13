package com.zensar.daos;

import java.util.List;

import com.zensar.entities.Product;
/*
 Author: Trigun Rai
 Creation Date: 26th Jul 2019 10:00AM
 Modification Date: 26th Jul 2019 10:00AM
 Version:1.0
 Copyright:Zensar Technnologies. All rights reserved
 Description: Data Access Object Interface
 It is used to access Product Data from Database.
 */
public interface ProductDao {
	void insert(Product product);
	void update(Product product);
	void delete(Product product);
	Product getbyId(int productId);
	List<Product> getAll();

}
