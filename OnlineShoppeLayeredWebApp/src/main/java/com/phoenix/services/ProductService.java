package com.phoenix.services;
import java.util.List;

import com.phoenix.data.Product;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.exceptions.SeviceException;
public interface ProductService {
	List<Product>findAll()throws SeviceException;
	Product findProductById(int id)throws ProductNotFoundException, SeviceException;
	void add(Product product)throws SeviceException;
	void edit(Product product)throws SeviceException;
	void remove(Product product)throws SeviceException;
	List<Product>findByName(String name)throws SeviceException;
	List<Product>findByBrand(String brand)throws SeviceException;
	List<Product>findByPrice(float price)throws SeviceException;
	List<Product>findByPriceRange(float minPrice,float maxPrice)throws SeviceException;
	List<Product>findByNameAndBrand(String name,String Brand)throws SeviceException;
	List<Product>findByNameAndPrice(String name,float price)throws SeviceException;
	List<Product>findByBrandAndPrice(String brand,float price)throws SeviceException;
	List<Product>sortByName()throws SeviceException;
	List<Product>sortByBrand()throws SeviceException;
	List<Product>sortByPrice()throws SeviceException;
	List<Product>sortByPriceDesc()throws SeviceException;

}
