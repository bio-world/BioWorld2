package com.vv.bioworld.code.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BW_ARTICLES")
public class Article {

	public Article() {
		this.tags = new ArrayList<Tag>();
	}

	@Id()
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CONTENT", length = 4096)
	private String text;

	// @Column(name = "GALLERY")
	// @Basic(fetch = FetchType.LAZY)
	// @Lob
	// byte[] pics;

	// @OneToMany(mappedBy="depaarticlertment")
	// private List<Student> students;

	@Basic(fetch = FetchType.LAZY)
	@ManyToMany(cascade = CascadeType.ALL, targetEntity = Tag.class)
	@JoinTable(name = "ART_TAGS", joinColumns = { @JoinColumn(name = "ART_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "TAG_ID", referencedColumnName = "ID") })
	@OrderBy("name ASC")
	private List<Tag> tags;

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getAuthor() {
		return user;
	}

	public void setAuthor(User author) {
		this.user = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
