package com.vv.bioworld.code.dao;

import java.util.List;

import com.vv.bioworld.code.entity.Article;
import com.vv.bioworld.code.entity.Tag;
import com.vv.bioworld.code.entity.User;

public interface ArticleDao {
	
	void storeArticle(Article article);

	List<Article> getArticlesByAuthor(User author);

	List<Article> getArticlesByTag(Tag tag);
	
	void removeArticle();
	
	void editArticle();
	
	List<Article> getLatestArticles();

}
