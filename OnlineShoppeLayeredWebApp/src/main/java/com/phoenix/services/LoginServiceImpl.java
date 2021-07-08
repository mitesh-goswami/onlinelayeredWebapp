package com.phoenix.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phoenix.daos.LoginDao;
import com.phoenix.daos.LoginDaoImpl;
import com.phoenix.data.User;

public class LoginServiceImpl implements LoginService {
	private LoginDao logindao;
	public LoginServiceImpl()
	{
		logindao= new LoginDaoImpl();
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users= new ArrayList<User>();
		try {
			users= logindao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	@Override
	public User findUserById(String username) {
		// TODO Auto-generated method stub
		User user=new User();
		try {
			 user =  logindao.getUserbyId(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		try {
			logindao.insert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void edit(User user) {
		// TODO Auto-generated method stub
		try {
			logindao.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub
		try {
			logindao.delete(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String changePassword() {
		// TODO Auto-generated method stub
		//logindao.update(null);
		return null;
	}
	

}
