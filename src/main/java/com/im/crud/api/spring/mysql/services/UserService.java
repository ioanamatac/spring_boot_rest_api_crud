package com.im.crud.api.spring.mysql.services;

import java.util.List;

import com.im.crud.api.spring.mysql.entity.User;

public interface UserService {

	User addUser(User user);

	User getUserById(int userId);

	void updateUserById(User user);

	void deleteUserById(int userId);

	List<User> getAllUsers();

}
