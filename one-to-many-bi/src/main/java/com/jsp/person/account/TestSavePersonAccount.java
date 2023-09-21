package com.jsp.person.account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonAccount {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("tanvi");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Person person = new Person();
		person.setName("Tanvi");
		person.setEmail("tanvi@mail.com");

		Account a1 = new Account();
		a1.setAcc_no(12345678936l);
		a1.setIfsc("SBI00534376");
		
		Account a2 = new Account();
		a2.setAcc_no(12345633936l);
		a2.setIfsc("HDFC0534376");
		
		Account a3 = new Account();
		a3.setAcc_no(12234489836l);
		a3.setIfsc("HSBC5343376");
		
		Account a4 = new Account();
		a4.setAcc_no(17767893886l);
		a4.setIfsc("PNB00434376");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		accounts.add(a4);
		
		person.setAccounts(accounts);
		a1.setPerson(person);
		a2.setPerson(person);
		a3.setPerson(person);
		a4.setPerson(person);
		
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();

		
	}

}
