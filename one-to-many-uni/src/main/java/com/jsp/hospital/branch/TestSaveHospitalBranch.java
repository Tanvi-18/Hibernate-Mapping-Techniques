package com.jsp.hospital.branch;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalBranch {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("tanvi");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital = new Hospital();
		hospital.setName("Jupiter");
		hospital.setType("private");
	
		
		Branch branch1 = new Branch();
		branch1.setLoc("Pune");
		branch1.setCno(254458096786l);
				
		Branch branch2 = new Branch();
		branch2.setLoc("Mumbai");
		branch2.setCno(243078909646l);
		
		Branch branch3 = new Branch();
		branch3.setLoc("Banglore");
		branch3.setCno(352577674865l);
		
		ArrayList<Branch> branches = new ArrayList<Branch>();
		branches.add(branch3);
		branches.add(branch2);
		branches.add(branch1);
		
		hospital.setBranches(branches);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();
				
		
	}

}
