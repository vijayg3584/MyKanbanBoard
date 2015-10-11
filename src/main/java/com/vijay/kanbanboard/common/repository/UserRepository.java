package com.vijay.kanbanboard.common.repository;

import com.vijay.kanbanboard.common.model.Person;
import com.vijay.kanbanboard.common.model.User;

public interface UserRepository {

	Long saveUser(User user);

	Person savePerson(Person person);

//	Person readUser(User user);

}
