package com.vv.bioworld.code.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.vv.bioworld.code.dao.UserDao;
import com.vv.bioworld.code.entity.User;

@Repository("UserDao")
@NamedQueries({ @NamedQuery(name = "GetUserById", query = "SELECT user FROM User user WHERE user.id = :userId") })
// GetArticlesByTag
// "SELECT article FROM Article article WHERE article.id = (SELECT ART_ID FROM `bioworld`.`art_tags`WHERE TAG_ID = (SELECT ID FROM `bioworld`.`bw_article_tags` WHERE NAME='Tag1'));"
// SELECT * FROM bw_articles
// INNER JOIN art_tags ON bw_articles.ID = art_tags.ART_ID
// INNER JOIN bw_article_tags ON art_tags.TAG_ID = bw_article_tags.ID
// WHERE bw_article_tags.NAME='Tag6';"
// SELECT * FROM entity_organization AS o
// INNER JOIN entity_role r ON r.organization_id = o.id
// INNER JOIN entity_user_role ur ON ur.role_id=r.id
// WHERE ur.user_id = 1
// SELECT DISTINCT o
// FROM Organization o, User u
// JOIN o.roles oRole
// JOIN u.roles uRole
// WHERE oRole.id = uRole.id AND u.id = :uId
// SELECT article from Article article, Tag tag
// JOIN article.tags aTags
// JOIN tag.articles tArts
// WHERE aTags.id = tArts.id AND tag.name = ''
// ************************************************************
// GetArticlesByAuthor
// SELECT * FROM bw_articles WHERE user_id='56';
// SELECT article FROM Article article WHERE article.user = :userId
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
	public User getUserById(int id) {
		EntityManager em = emf.createEntityManager();
		Query userById = em.createNamedQuery("GetUserById", User.class);
		userById.setParameter("userId", id);
		User user = (User) userById.getSingleResult();
		em.close();
		return user;
	}

	@Override
	public void removeUser() {
		// TODO add functionality
	}

	@Override
	public void editUser() {
		// TODO add functionality

	}

}
