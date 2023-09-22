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
		person.setName("ABC");
		person.setEmail("abc@mail.com");
		
		Account a1 = new Account();
		a1.setBank_name("SBI");
		a1.setAcc_no(12345678896l);
		a1.setIfsc_code("SBI235678899");
		
		Account a2 = new Account();
		a2.setBank_name("HDFC");
		a2.setAcc_no(12345678896l);
		a2.setIfsc_code("HDFC35678899");
		
		Account a3 = new Account();
		a3.setBank_name("ICICI");
		a3.setAcc_no(12345678896l);
		a3.setIfsc_code("ICICI7678899");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		
		person.setAccounts(accounts);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(a1);
		entityManager.persist(a2);
		entityManager.persist(a3);
		entityTransaction.commit();	
		
		
	}

}
