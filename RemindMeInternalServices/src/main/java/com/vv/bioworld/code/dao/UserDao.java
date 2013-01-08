package com.vv.bioworld.code.dao;

import com.vv.bioworld.code.entity.User;

public interface UserDao {
	
	User getUserById();

	int storeUser(User user);
}
