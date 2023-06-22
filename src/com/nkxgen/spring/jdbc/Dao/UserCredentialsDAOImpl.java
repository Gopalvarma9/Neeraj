package com.nkxgen.spring.jdbc.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nkxgen.spring.jdbc.model.UserCredentials;

@Repository
public class UserCredentialsDAOImpl implements UserCredentialsDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public boolean userCredentialsCheck(String username, String password) {
		String queryString = "SELECT uc FROM UserCredentials uc WHERE uc.username = :username AND uc.password = :password";
		TypedQuery<UserCredentials> query = entityManager.createQuery(queryString, UserCredentials.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		return query.getResultList().size() > 0;
	}
}
