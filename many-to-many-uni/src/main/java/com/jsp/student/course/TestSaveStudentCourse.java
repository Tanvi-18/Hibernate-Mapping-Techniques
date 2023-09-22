package com.jsp.student.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("tanvi");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student s = new Student();
		s.setName("XYZ");
		s.setEmail("xyz@mail.com");
		
		Course c1 = new Course();
		c1.setName("SQL");
		c1.setDuration(1);
		
		Course c2 = new Course();
		c2.setName("Java");
		c2.setDuration(2);
		
		Course c3 = new Course();
		c3.setName("Web Tech");
		c3.setDuration(1);
		
		List<Course> courses = new ArrayList<Course>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		
		s.setCourses(courses);
	
		entityTransaction.begin();
		entityManager.persist(s);
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityTransaction.commit();		
		
	}
	
}
