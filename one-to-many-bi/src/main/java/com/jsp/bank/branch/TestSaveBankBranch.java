package com.jsp.bank.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveBankBranch {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("tanvi");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Bank bank = new Bank();
		bank.setName("HDFC");
		
		Branch b1 = new Branch();
		b1.setAddress("Dadar");
		
		Branch b2 = new Branch();
		b2.setAddress("Matunga");
		
		Branch b3 = new Branch();
		b3.setAddress("Andheri");
		
		Branch b4 = new Branch();
		b4.setAddress("Kurla");
		
		List<Branch>branchs  = new ArrayList<Branch>() ;
		branchs.add(b1);
		branchs.add(b2);
		branchs.add(b3);
		branchs.add(b4);
		
		bank.setBranchs(branchs);
		b1.setBank(bank);
		b2.setBank(bank);
		b3.setBank(bank);
		b4.setBank(bank);
	
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(b1);
		entityManager.persist(b2);
		entityManager.persist(b3);
		entityManager.persist(b4);
		entityTransaction.commit();
		
		
	}

}
