package com.vv.bioworld.code.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import com.vv.bioworld.code.entity.Article;
import com.vv.bioworld.code.entity.Tag;
import com.vv.bioworld.code.entity.User;

@NamedQuery(name = "findAllCustomersWithName", query = "SELECT c FROM Customer c WHERE c.name LIKE :custName")
public class MainTester {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Tag tag1 = new Tag();tag1.setName("q");
		Tag tag2 = new Tag();tag2.setName("q");
		
		Set <Tag> set = new HashSet<Tag>();
		set.add(tag1);
		set.add(tag2);
		
		
		File pic = new File("D:/rabbit.jpg");
		System.out.println(pic.exists());
		FileInputStream picio = null;
		byte[] picture = new byte[3];
		
		try {
			picio = new FileInputStream(pic);
			picio.read(picture);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("bworldPU");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		User user = new User();
		user.setLogin("ferfax@gmail.com");
		user.setPassword("qwqwwqweqw");
		user.setName("name");
		user.setDob(new Date());
		user.setSurname("surname");
		user.setPicture(picture);

		Article article = new Article();
		article.setAuthor(user);
		article.setCreationDate(new Date());
		article.setName("My Article");
		article.setText("A long time ago.....");

		
		Tag tag = new Tag();
		tag.setName("Tag1");
		Tag tag4 = new Tag();
		tag4.setName("Tag4");

		article.getTags().add(tag);
		article.getTags().add(tag4);
//		tag.getArticles().add(article);
		
		
		manager.persist(user);
		manager.persist(article);
		manager.persist(tag);
		manager.persist(tag4);
		
		
		manager.flush();
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Done");
	}

}
