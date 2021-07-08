package com.phoenix.daos;

import java.sql.SQLException;
import java.util.List;

import com.phoenix.data.Product;
import com.phoenix.data.User;

public interface ProductDao {

	Product getProductbyId(int id) throws SQLException;
	List<Product> getAllProducts() throws SQLException;
	void insert(Product product)throws SQLException;
	void update(Product product) throws SQLException;
	void delete(Product product) throws SQLException;

}
