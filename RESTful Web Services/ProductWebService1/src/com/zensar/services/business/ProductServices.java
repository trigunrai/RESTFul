package com.zensar.services.business;

import java.util.List;

import com.zensar.entities.Product;

/*
Author: Trigun Rai
Creation Date: 26th Jul 2019 11:25AM
Modification Date: 26th Jul 2019 11:25AM
Version:1.0
Copyright:Zensar Technnologies. All rights reserved
Description: Business Object Interface
it focuses on business logic of Product.
*/
public interface ProductServices {
	void create (Product product);
	void update (Product product);
	void remove (Product product);
	Product findProductById(int productId);
	List<Product> findAllProducts();
	int getProductCount();
	List<Product> findProductsByBrand(String brand);
	List<Product> findProductsByPriceRange(float minPrice,float maxPrice);
}
