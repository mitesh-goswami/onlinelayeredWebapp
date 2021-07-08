package com.phoenix.services;
import com.phoenix.exceptions.SeviceException;
import com.phoenix.exceptions.UserNotFoundException;

import java.util.List;

import com.phoenix.data.User;

public interface LoginService {
	List<User> findAll() throws SeviceException;
	User findUserById(String username)throws UserNotFoundException, SeviceException;
	void add(User user)throws SeviceException;
	void edit(User user)throws SeviceException;
	void remove(User user)throws SeviceException;
	String changePassword()throws SeviceException;

}
