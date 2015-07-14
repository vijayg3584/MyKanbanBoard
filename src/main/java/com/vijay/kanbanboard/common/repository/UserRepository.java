package com.vijay.kanbanboard.common.repository;

import com.vijay.kanbanboard.common.model.User;
import com.vijay.kanbanboard.common.model.UserDetail;

public interface UserRepository {

	Long saveUser(User user);

	UserDetail saveUserDetail(UserDetail userDetail);

}
