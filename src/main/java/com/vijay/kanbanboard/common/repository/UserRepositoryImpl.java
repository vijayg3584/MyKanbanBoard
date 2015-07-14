package com.vijay.kanbanboard.common.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.vijay.kanbanboard.common.model.User;
import com.vijay.kanbanboard.common.model.UserDetail;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Long saveUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user.getId();

	}

	public UserDetail saveUserDetail(UserDetail userDetail) {
		entityManager.persist(userDetail);
		entityManager.flush();
		return userDetail;
	}
}
