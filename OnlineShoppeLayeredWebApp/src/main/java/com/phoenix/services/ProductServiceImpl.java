package com.phoenix.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phoenix.daos.ProductDao;
import com.phoenix.daos.ProductDaoImpl;
import com.phoenix.data.Product;
import com.phoenix.exceptions.SeviceException;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	public ProductServiceImpl()
	{
		productDao=new ProductDaoImpl();
	}
	@Override
	public List<Product> findAll() throws SeviceException {
		// TODO Auto-generated method stub
		
		try {
			return productDao.getAllProducts();
		} catch (SQLException e) {
			throw new SeviceException(e.getMessage());
		}
	}
	@Override
	public Product findProductById(int id) throws SeviceException {
		// TODO Auto-generated method stub
		try {
			return productDao.getProductbyId(id);
		} catch (SQLException e) {
			throw new SeviceException(e.getMessage());
		} 
		//return null;
	}
	@Override
	public void add(Product product) throws SeviceException {
		// TODO Auto-generated method stub
		try {
			productDao.insert(product);
		} catch (SQLException e) {
			throw new SeviceException(e.getMessage());
		}
	}
	@Override
	public void edit(Product product) throws SeviceException {
		// TODO Auto-generated method stub
		try {
			productDao.update(product);
		} catch (SQLException e) {
			throw new SeviceException(e.getMessage());
		}
	}
	@Override
	public void remove(Product product) throws SeviceException {
		// TODO Auto-generated method stub
		try {
			productDao.delete(product);
		} catch (SQLException e) {
			throw new SeviceException(e.getMessage());
		}
	}
	@Override
	public List<Product> findByName(String name) throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		List<Product> productsByName = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getName().equals(name)) {
				productsByName.add(product);
			}
		}
		
		return productsByName;
		//return null;
	}
	@Override
	public List<Product> findByBrand(String brand) throws SeviceException {
		// TODO Auto-generated method stub
List<Product> dbProducts = findAll();
		
		List<Product> productsByBrand = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getBrand().equals(brand)) {
				productsByBrand.add(product);
			}
		}
		return productsByBrand;
		//return null;
	}
	@Override
	public List<Product> findByPrice(float price) throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		
		List<Product> productsByPrice = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getPrice() == price) {
				productsByPrice.add(product);
			}
		}
		return productsByPrice;
		//return null;
	}
	@Override
	public List<Product> findByPriceRange(float minPrice, float maxPrice) throws SeviceException {
		// TODO Auto-generated method stub
List<Product> dbProducts = findAll();
		
		List<Product> productsByPriceRange = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getPrice() >= maxPrice && product.getPrice() <= minPrice) {
				productsByPriceRange.add(product);
			}
		}
		return productsByPriceRange;
		//return null;
	}
	@Override
	public List<Product> findByNameAndBrand(String name, String Brand) throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		
		List<Product> productsByBrand = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getBrand().equals(Brand)) {
				productsByBrand.add(product);
			}
		}
		return productsByBrand;
		//return null;
	}
	@Override
	public List<Product> findByNameAndPrice(String name, float price) throws SeviceException {
		// TODO Auto-generated method stub
List<Product> dbProducts = findAll();
		
		List<Product> productsByNameAndPrice = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getName().equals(name) && product.getPrice() == price) {
				productsByNameAndPrice.add(product);
			}
		}
		return productsByNameAndPrice;
		//return null;
	}
	@Override
	public List<Product> findByBrandAndPrice(String brand, float price) throws SeviceException {
		// TODO Auto-generated method stub
List<Product> dbProducts = findAll();
		
		List<Product> productsByBrandAndPrice = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getBrand().equals(brand) && product.getPrice() == price) {
				productsByBrandAndPrice.add(product);
			}
		}
		return productsByBrandAndPrice;
		//return null;
	}
	@Override
	public List<Product> sortByName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> sortByBrand() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> sortByPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> sortByPriceDesc() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
