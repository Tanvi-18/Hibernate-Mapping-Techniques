package com.jsp.person.account;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonBankAccount {
	
public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("tanvi");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Person person = new Person();
		person.setName("ABC");
		person.setEmail("abc@mail.com");
		person.setCno(354577909653l);
		person.setGender('F');

		
		BankAccount bankAcoount1 = new BankAccount();
		bankAcoount1.setBank_name("SBI");
		bankAcoount1.setAcc_no(245568878985l);
		bankAcoount1.setIfsc_code("SBI1234556789");
		
		BankAccount bankAcoount2 = new BankAccount();
		bankAcoount2.setBank_name("HDFC");
		bankAcoount2.setAcc_no(232447989865l);
		bankAcoount2.setIfsc_code("HDFC12345689");
		
		BankAccount bankAcoount3 = new BankAccount();
		bankAcoount3.setBank_name("HSBC");
		bankAcoount3.setAcc_no(245568878965l);
		bankAcoount3.setIfsc_code("HSBC12366789");
		
		ArrayList<BankAccount> acoounts = new ArrayList<BankAccount>();
		acoounts.add(bankAcoount3);
		acoounts.add(bankAcoount2);
		acoounts.add(bankAcoount1);
		
		
		// set a person with multiple bank accounts
		bankAcoount1.setPerson(person);
		bankAcoount2.setPerson(person);
		bankAcoount3.setPerson(person);
			
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bankAcoount1);
		entityManager.persist(bankAcoount2);
		entityManager.persist(bankAcoount3);
		entityTransaction.commit();
		
	}

}
