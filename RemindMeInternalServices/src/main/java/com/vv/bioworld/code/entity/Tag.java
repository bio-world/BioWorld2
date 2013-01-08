package com.vv.bioworld.code.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "BW_ARTICLE_TAGS")
public class Tag implements Comparable<Tag> {

	public Tag() {
		articles = new ArrayList<Article>();
		name = "";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL, targetEntity = Article.class)
	@OrderBy("name ASC")
	private List<Article> articles;

	@Column(name = "NAME")
	private String name;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	
	public boolean equals(Object another) {
	      if (this == another) return true;
	        if (!(another instanceof Tag)) return false;

	        Tag tag = (Tag) another;

	        if (!this.name.equalsIgnoreCase(tag.name)) return false;

	        return true;
	}

	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(Tag o) {
		if (this.name.equals(o.name))
			return 0;
		else
			return 1;
	}

}
