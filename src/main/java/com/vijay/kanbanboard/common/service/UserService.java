package com.vijay.kanbanboard.common.service;

import com.vijay.kanbanboard.common.model.Person;
import com.vijay.kanbanboard.common.model.User;
import com.vijay.kanbanboard.login.NewUserDTO;

public interface UserService {

	Person authenticate(User user);

	NewUserDTO saveNewUser(NewUserDTO newUser);

//	Person readUser(User user);

}
