package com.vv.bioworld.code.dao;

import com.vv.bioworld.code.entity.User;

public interface UserDao {

	int storeUser(User user);

	User getUserById(int id);

	void removeUser();
	
	void editUser();

}
