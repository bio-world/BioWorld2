package com.vv.bioworld.code.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.vv.bioworld.code.dao.UserDao;
import com.vv.bioworld.code.entity.Article;
import com.vv.bioworld.code.entity.User;

@Repository("UserDao")
@NamedQueries({ @NamedQuery(name = "GetArticlesByAuthor", query = "SELECT article FROM Article article WHERE article.user_id = :userId"),
		@NamedQuery(name = "GetArticlesByTag", query = "SELECT article FROM Article article WHERE ") })

//"SELECT article FROM Article article WHERE article.id = (SELECT ART_ID FROM `bioworld`.`art_tags`WHERE TAG_ID = (SELECT ID FROM `bioworld`.`bw_article_tags` WHERE NAME='Tag1'));"

//"SELECT article FROM Article article LEFT JOIN table_name2 ON table_name1.column_name = stable_name2.column_name"


//SELECT * FROM bw_articles
//INNER JOIN art_tags ON bw_articles.ID = art_tags.ART_ID
//INNER JOIN bw_article_tags ON art_tags.TAG_ID = bw_article_tags.ID 
//WHERE bw_article_tags.NAME='Tag6';"

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

	@Override
	public void storeArticle(Article article) {
		EntityManager em = emf.createEntityManager();
		em.persist(article);
		em.flush();
		em.close();
	}

	@Override
	public void getArticlesByAuthor() {
		EntityManager em = emf.createEntityManager();
		em.createNamedQuery("GetArticlesByAuthor", Article.class).getResultList();
	}

	@Override
	public void getArticlesByTag() {
		EntityManager em = emf.createEntityManager();
		em.createNamedQuery("GetArticlesByTag", Article.class).getResultList();
	}
}
