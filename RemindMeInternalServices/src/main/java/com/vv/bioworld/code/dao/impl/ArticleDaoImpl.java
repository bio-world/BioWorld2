package com.vv.bioworld.code.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.vv.bioworld.code.dao.ArticleDao;
import com.vv.bioworld.code.entity.Article;
import com.vv.bioworld.code.entity.Tag;
import com.vv.bioworld.code.entity.User;

@Repository("ArticleDao")
@NamedQueries({
		@NamedQuery(name = "GetArticlesByAuthor", query = "SELECT article FROM Article article WHERE article.user.id = :userId"),
		@NamedQuery(name = "GetArticlesByTag", query = "SELECT article from Article article, Tag tag JOIN article.tags aTags JOIN tag.articles tArts WHERE aTags.id = tArts.id AND tag.name = :tagName"),
		@NamedQuery(name = "GetLatestArticles", query = "SELECT article FROM Article article ORDER BY article.creationDate") })
public class ArticleDaoImpl implements ArticleDao {

	@PersistenceContext
	@Qualifier("bworldPU")
	EntityManagerFactory emf;

	@Override
	public void storeArticle(Article article) {
		EntityManager em = emf.createEntityManager();
		em.persist(article);
		em.flush();
		em.close();
	}

	@Override
	public List<Article> getArticlesByAuthor(User author) {
		EntityManager em = emf.createEntityManager();
		Query articlesByAuthor = em.createNamedQuery("GetArticlesByAuthor",
				Article.class);
		articlesByAuthor.setParameter("userId", author.getId());
		List<Article> articles = articlesByAuthor.getResultList();
		em.close();
		return articles;
	}

	@Override
	public List<Article> getArticlesByTag(Tag tag) {
		EntityManager em = emf.createEntityManager();
		Query articlesByTag = em.createNamedQuery("GetArticlesByTag",
				Article.class);
		articlesByTag.setParameter("tagName", tag.getName());
		List<Article> articles = articlesByTag.getResultList();
		em.close();
		return articles;
	}

	@Override
	public void removeArticle() {
		// TODO add functionality
	}

	@Override
	public void editArticle() {
		// TODO add functionality
	}

	@Override
	public List<Article> getLatestArticles() {
		EntityManager em = emf.createEntityManager();
		Query latestArticles = em.createNamedQuery("GetLatestArticles",
				Article.class);
		List<Article> articles = latestArticles.getResultList();
		em.close();
		return articles;
	}
}
