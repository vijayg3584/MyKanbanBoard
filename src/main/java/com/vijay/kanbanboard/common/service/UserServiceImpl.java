package com.vijay.kanbanboard.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vijay.kanbanboard.common.model.Person;
import com.vijay.kanbanboard.common.model.User;
import com.vijay.kanbanboard.common.repository.UserRepository;
import com.vijay.kanbanboard.login.NewUserDTO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public Person authenticate(User user) {
		return null;
	}

	@Transactional
	public NewUserDTO saveNewUser(NewUserDTO newUser) {
		User user = new User();
		user.setPassword(newUser.getPassword());
		user.setUsername(newUser.getUsername());
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setEmailId(newUser.getEmailId());
		
		long userId = userRepository.saveUser(user);
		
		newUser.setUserId(String.valueOf(userId));
		
		return newUser;
		
		/*
		System.out.println("LoginController.newUserCreation() Username: " + user.getUsername());
		System.out.println("LoginController.newUserCreation() Password: " + user.getPassword());
		System.out.println("UserServiceImpl.saveNewUser() userId: " + userId);
		Person person = new Person();
		person.setFirstName(newUser.getFirstName());
		person.setLastName(newUser.getLastName());
		person.setEmailId(newUser.getEmailId());
		person.setUser(user);

		System.out.println("LoginController.newUserCreation() FirstName: " + person.getFirstName());
		System.out.println("LoginController.newUserCreation() LastName: " + person.getLastName());
		System.out.println("LoginController.newUserCreation() Email Id: " + person.getEmailId());

		Person detail = userRepository.savePerson(person);

		return detail;*/
	}

//	public Person readUser(User user) {
//
//		return userRepository.readUser(user);
//	}
}
