package com.myproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.UserDAO;
import com.myproject.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	public List<User> list() {
		return userDAO.list();
	}

	public User get(int id) {
		return userDAO.get(id);
	}

	public void saveOrUpdate(User user) {
		userDAO.saveOrUpdate(user);
	}

	public void delete(int id) {
		userDAO.delete(id);

	}

}
