package com.vv.bioworld.code.dao;

import com.vv.bioworld.code.entity.Article;
import com.vv.bioworld.code.entity.User;

public interface UserDao {
	
	User getUserById();

	int storeUser(User user);

	void storeArticle(Article article);

	void getArticlesByAuthor();

	void getArticlesByTag();
}
