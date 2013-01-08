package com.vv.bioworld.code.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.vv.bioworld.code.dao.UserDao;
import com.vv.bioworld.code.entity.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	@Qualifier("bworldPU")
	EntityManagerFactory emf;

	@Override
	public int storeUser(User user) {
		EntityManager em = emf.createEntityManager();
		em.persist(user);
		em.flush();
		em.close();
		return 0;
	}

	@Override
	public User getUserById() {
		// TODO Auto-generated method stub
		return null;
	}

}
