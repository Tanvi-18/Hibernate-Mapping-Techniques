package com.jsp.person.account;

import java.util.ArrayList;

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
		person.setName("XYZ");
		person.setEmail("xyz@mail.com");
		person.setCno(354577909653l);
		person.setGender('M');

		
		BankAccount bankAcoount1 = new BankAccount();
		bankAcoount1.setBank_name("BOI");
		bankAcoount1.setAcc_no(242457789865l);
		bankAcoount1.setIfsc_code("BOI345654789");
		
		BankAccount bankAcoount2 = new BankAccount();
		bankAcoount2.setBank_name("UNION");
		bankAcoount2.setAcc_no(232808094865l);
		bankAcoount2.setIfsc_code("UNIB14454689");
		
		BankAccount bankAcoount3 = new BankAccount();
		bankAcoount3.setBank_name("IDBI");
		bankAcoount3.setAcc_no(245688976565l);
		bankAcoount3.setIfsc_code("IDBI24674589");
		
		ArrayList<BankAccount> acoounts = new ArrayList<BankAccount>();
		acoounts.add(bankAcoount3);
		acoounts.add(bankAcoount2);
		acoounts.add(bankAcoount1);
		
		
		// set a person with multiple bank accounts
		person.setAccounts(acoounts);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bankAcoount1);
		entityManager.persist(bankAcoount2);
		entityManager.persist(bankAcoount3);
		entityTransaction.commit();
		
	}

}
