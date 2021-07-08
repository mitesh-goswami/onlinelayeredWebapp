package com.phoenix.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.phoenix.data.User;
import com.phoenix.dbconfig.OracleConnection;

public class LoginDaoImpl implements LoginDao {
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
	public User getUserbyId(String username) throws SQLException {
		// TODO Auto-generated method stub
		String sql="SELECT username,password FROM login WHERE username=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			return user;
		}
		else
			return null;
	}
	@Override
	public List<User> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM login";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		List<User> users= new ArrayList<User>();
		while(rs.next())
		{
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			users.add(user);
		}
		
		return users;
	}
	@Override
	public void insert(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="INSERT INTO login(username,password) VALUES(?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPassword());
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
		{
			System.out.println("NEW user added successfully");
		}
		else
			System.out.println("Sorry! user not added");
	}
	@Override
	public void update(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="UPDATE login SET password=? WHERE username=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPassword());
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
		{
			System.out.println(" user updated successfully");
		}
		else
			System.out.println("Sorry! user not updated");
		
	}
	@Override
	public void delete(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM login WHERE username=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, user.getUsername());
	
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
		{
			System.out.println(" user deleted successfully");
		}
		else
			System.out.println("Sorry! user not deleted");
	}
	

}
