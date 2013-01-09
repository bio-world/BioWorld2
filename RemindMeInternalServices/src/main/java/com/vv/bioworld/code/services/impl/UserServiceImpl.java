package com.vv.bioworld.code.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vv.bioworld.code.dao.impl.UserDaoImpl;
import com.vv.bioworld.code.entity.Article;
import com.vv.bioworld.code.entity.Tag;
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
	public void addArticle(User author, Date creationDate, String name, String text, List<Tag> tags) {
		Article article = new Article();
		article.setAuthor(author);
		article.setCreationDate(creationDate);
		article.setName(name);
		article.setTags(tags);
		article.setText(text);
		
	}
	
	

}
