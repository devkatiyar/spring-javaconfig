package com.myproject.services;

import java.util.List;

import com.myproject.model.User;

public interface UserService {

	List<User> list();

	User get(int id);

	void saveOrUpdate(User user);

	void delete(int id);
}
