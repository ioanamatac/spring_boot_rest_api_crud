package com.im.crud.api.spring.mysql.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.crud.api.spring.mysql.entity.User;
import com.im.crud.api.spring.mysql.repository.UserRepository;
import com.im.crud.api.spring.mysql.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUserById(int userId) {

		return userRepository.findById(userId).get();
	}

	@Override
	public void updateUserById(User user) {
		User u = userRepository.findById(user.getUserId()).orElseThrow();
		userRepository.save(user);

	}

	@Override
	public void deleteUserById(int userId) {

		try {
			userRepository.deleteById(userId);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
