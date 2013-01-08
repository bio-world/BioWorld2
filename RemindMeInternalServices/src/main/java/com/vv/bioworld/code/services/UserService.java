package com.vv.bioworld.code.services;

import java.util.Date;

public interface UserService {

	void addArticle();

	int createUser(String name, String surname, String login, String password,
			Date dob, byte[] picture);
}
