package com.phoenix.daos;

import java.sql.SQLException;
import java.util.List;

import com.phoenix.data.User;

public interface LoginDao {
	
	User getUserbyId(String username) throws SQLException;
	List<User> getAll() throws SQLException;
	void insert(User user)throws SQLException;
	void update(User user) throws SQLException;
	void delete(User user) throws SQLException;
	
	

}
