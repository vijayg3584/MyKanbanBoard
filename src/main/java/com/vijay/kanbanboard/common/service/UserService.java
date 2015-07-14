package com.vijay.kanbanboard.common.service;

import com.vijay.kanbanboard.common.model.User;
import com.vijay.kanbanboard.common.model.UserDetail;
import com.vijay.kanbanboard.login.NewUser;

public interface UserService {

	UserDetail authenticate(User user);

	UserDetail saveNewUser(NewUser newUser);

}
