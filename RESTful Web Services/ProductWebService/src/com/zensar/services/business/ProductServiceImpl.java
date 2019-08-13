package com.zensar.services.business;

import java.util.ArrayList;
import java.util.List;

import com.zensar.DAO.ProductDao;
import com.zensar.DAO.ProductDaoImpl;
import com.zensar.entities.Product;
/*
Author: Trigun Rai
Creation Date: 26th Jul 2019 11:40AM
Modification Date: 26th Jul 2019 11:40AM
Version:1.0
Copyright:Zensar Technnologies. All rights reserved
Description:Data Access Onject Implementor Class
it encapsulates business logic of application component.
It interacts with Dao layer to get data form database
it interacts with presentation layer
it give data as per business requirement.
*/
public class ProductServiceImpl implements ProductServices {
private ProductDao dao;
	public ProductServiceImpl() {
	// TODO Auto-generated constructor stub
		dao=new ProductDaoImpl();
}
	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		dao.insert(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		Product dbProduct=findProductById(product.getProductid());
		
		if(dbProduct!=null){
			dbProduct.setName(product.getName());
			dbProduct.setBrand(product.getBrand());
			dbProduct.setPrice(product.getPrice());
			dao.update(dbProduct);
			
		}else{
			System.out.println("Product Not Found");
		}
	}

	@Override
	public void remove(Product product) {
		// TODO Auto-generated method stub
		Product dbproduct=findProductById(product.getProductid());
		if(dbproduct!=null)
			dao.delete(dbproduct);
		else
			System.out.println("Product not found");
	}

	@Override
	public Product findProductById(int productId) {
		// TODO Auto-generated method stub
		return dao.getbyId(productId);
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public int getProductCount() {
		// TODO Auto-generated method stub
		return findAllProducts().size();
	}

	@Override
	public List<Product> findProductsByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Product> pList=findAllProducts();
		List<Product> pBList=new ArrayList<>();
		for(Product p:pList)
		{
		if(p.getBrand().equals(brand))
			pBList.add(p);
		}
		return pBList;
	}

	@Override
	public List<Product> findProductsByPriceRange(float minPrice, float maxPrice) {
		// TODO Auto-generated method stub
		List<Product> pList=findAllProducts();
		List<Product> pPList=new ArrayList<>();
		for(Product p:pPList){
			if(p.getPrice()<maxPrice && p.getPrice()>minPrice )
			{
				pPList.add(p);
			}
		}
		return pPList;
	}

}