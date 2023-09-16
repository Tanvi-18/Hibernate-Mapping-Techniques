package com.jsp.vehicle.registration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveVehicleRegistration {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("tanvi");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Car");
		vehicle.setBrand("BMW");
		vehicle.setPrice(6500000);
		vehicle.setColour("Black");
		
		Registration registration = new Registration();
		registration.setReg_no(2543);
		registration.setCity("Mumbai");
		
		vehicle.setRegistration(registration);		
		
		entityTransaction.begin();
		entityManager.persist(vehicle);
		entityManager.persist(registration);
		entityTransaction.commit();
						
	}

}
