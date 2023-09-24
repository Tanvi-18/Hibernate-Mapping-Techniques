package com.jsp.customer.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveCustomerProduct {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("tanvi");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Customer c1 = new Customer();
		c1.setName("ABC");
		c1.setEmail("abc@mail.com");
		
		Customer c2 = new Customer();
		c2.setName("PQR");
		c2.setEmail("pqr@mail.com");
		
		Customer c3 = new Customer();
		c3.setName("XYZ");
		c3.setEmail("xyz@mail.com");
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		
		Product p1 = new Product();
		p1.setName("Earphones");
		p1.setQuantity(2);
		
		Product p2 = new Product();
		p2.setName("Laptop");
		p2.setQuantity(1);
		
		Product p3 = new Product();
		p3.setName("Shirt");
		p3.setQuantity(4);
		
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		c1.setProducts(products);
		c2.setProducts(products);
		c3.setProducts(products);
		p1.setCustomers(customers);
		p2.setCustomers(customers);
		p3.setCustomers(customers);
		
		entityTransaction.begin();
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityTransaction.commit();		
		
		
	}

}
