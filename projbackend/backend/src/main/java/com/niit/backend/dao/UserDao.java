package com.niit.backend.dao;

import com.niit.backend.model.User;

public interface UserDao {

	User authenticate(User user);
	User registerUser(User user);
	User getUserById(int userid);
}
