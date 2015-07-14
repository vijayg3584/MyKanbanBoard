package com.vijay.kanbanboard.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vijay.kanbanboard.common.model.User;
import com.vijay.kanbanboard.common.model.UserDetail;
import com.vijay.kanbanboard.common.repository.UserRepository;
import com.vijay.kanbanboard.login.NewUser;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public UserDetail authenticate(User user) {
		return null;
	}

	@Transactional
	public UserDetail saveNewUser(NewUser newUser) {
		User user = new User();
		user.setPassword(newUser.getPassword());
		user.setUsername(newUser.getUsername());
		long userId = userRepository.saveUser(user);
		System.out.println("LoginController.newUserCreation() Username: " + user.getUsername());
		System.out.println("LoginController.newUserCreation() Password: " + user.getPassword());
		System.out.println("UserServiceImpl.saveNewUser() userId: " + userId);
		UserDetail userDetail = new UserDetail();
		userDetail.setUserId(userId);
		userDetail.setFirstName(newUser.getFirstName());
		userDetail.setLastName(newUser.getLastName());

		System.out.println("LoginController.newUserCreation() FirstName: " + userDetail.getFirstName());
		System.out.println("LoginController.newUserCreation() LastName(): " + userDetail.getLastName());

		UserDetail detail = userRepository.saveUserDetail(userDetail);

		return detail;
	}
}
