package com.phoenix.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import com.phoenix.data.Product;
import com.phoenix.data.User;
import com.phoenix.dbconfig.OracleConnection;

public class ProductDaoImpl implements ProductDao {
	private static Connection con;
	static {
		try {
			con= OracleConnection.getOracleConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("oracle connection is established");
		
	}
	@Override
	public Product getProductbyId(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product WHERE id=?";
		
		//Preparing the statement
		PreparedStatement stmt = con.prepareStatement(sql);
		
		//setting the user-name in statement
		stmt.setInt(1, id);
		
		//resultant dataset received
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setBrand(rs.getString(3));
			product.setPrice(rs.getFloat(4));
			return product;
		} else {
			return null;
		}
		
		
	}
	@Override
	public List<Product> getAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		String sql= "SELECT * FROM product";
		Statement stmt = con.createStatement();
		//stmt.setInt(1,2);
		ResultSet rs= stmt.executeQuery(sql);
		List<Product> products= new ArrayList<Product>();
		while(rs.next())
		{
			Product product= new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setBrand(rs.getString(3));
			product.setPrice(rs.getFloat(4));
			products.add(product);
		}
		return products;
	}
	@Override
	public void insert(Product product) throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String sql="INSERT INTO product VALUES(?,?,?,?)";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1, product.getId());
				stmt.setString(2, product.getName());
				stmt.setString(3, product.getBrand());
				stmt.setFloat(4, product.getPrice());
				int updateCount=stmt.executeUpdate();
				if(updateCount>0)
				{
					System.out.println("NEW product added successfully");
				}
				else
					System.out.println("Sorry! product not added");
		
	}
	@Override
	public void update(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String sql="UPDATE product SET name=?,brand=?,price=? WHERE id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, product.getId());
		/*
		 * stmt.setString(2, product.getName()); stmt.setString(3, product.getBrand());
		 * stmt.setFloat(4, product.getPrice());
		 */
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
		{
			System.out.println(" product deleted successfully");
		}
		else
			System.out.println("Sorry! product not deleted");

	}
	@Override
	public void delete(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM product WHERE id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setString(2, product.getName());
		stmt.setString(3, product.getBrand());
		stmt.setFloat(4, product.getPrice());
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
		{
			System.out.println(" product updated successfully");
		}
		else
			System.out.println("Sorry! product not updated");

	}
	

}
