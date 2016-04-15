package com.myproject.dao;

import java.util.List;

import com.myproject.model.User;

public interface UserDAO {
	
	List<User> list();

	User get(int id);

	void saveOrUpdate(User user);

	void delete(int id);
}