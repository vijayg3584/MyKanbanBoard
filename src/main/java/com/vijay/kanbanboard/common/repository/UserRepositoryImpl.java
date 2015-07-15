package com.vijay.kanbanboard.common.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.vijay.kanbanboard.common.model.Person;
import com.vijay.kanbanboard.common.model.User;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Long saveUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user.getId();

	}

	public Person savePerson(Person person) {
		entityManager.persist(person);
		entityManager.flush();
		return person;
	}

	public Person readUser(User user) {
		return entityManager.find(User.class, user.getId()).getPerson();
	}
}
