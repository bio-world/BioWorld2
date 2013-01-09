package com.vv.bioworld.code.services;

import java.util.Date;
import java.util.List;

import com.vv.bioworld.code.entity.Tag;
import com.vv.bioworld.code.entity.User;

public interface UserService {

	int createUser(String name, String surname, String login, String password,
			Date dob, byte[] picture);

	void addArticle(User author, Date creationDate, String name, String text,
			List<Tag> tags);
}
