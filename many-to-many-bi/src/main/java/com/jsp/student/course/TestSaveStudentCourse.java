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
		
		Student s1 = new Student();
		s1.setName("ABC");
		s1.setEmail("abc@mail.com");
		
		Student s2 = new Student();
		s2.setName("PQR");
		s2.setEmail("pqr@mail.com");
		
		Student s3 = new Student();
		s3.setName("XYZ");
		s3.setEmail("xyz@mail.com");
		
		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		
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
		
		s1.setCourses(courses);
		s2.setCourses(courses);
		s3.setCourses(courses);
		c1.setStudents(students);
		c2.setStudents(students);
		c3.setStudents(students);		
			
		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityTransaction.commit();		
		
	}

}
