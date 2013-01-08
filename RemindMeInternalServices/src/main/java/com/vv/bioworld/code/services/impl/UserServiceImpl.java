package com.vv.bioworld.code.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vv.bioworld.code.dao.impl.UserDaoImpl;
import com.vv.bioworld.code.entity.User;
import com.vv.bioworld.code.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("UserDao")
	UserDaoImpl userDao;

	@Override
	public int createUser(String name, String surname, String login,
			String password, Date dob, byte[] picture) {
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setName(name);
		user.setDob(dob);
		user.setSurname(surname);
		user.setPicture(picture);
		userDao.storeUser(user);
		return 0;// TODO add logic
	}

	@Override
	public void addArticle() {
		// TODO Auto-generated method stub

	}

}
