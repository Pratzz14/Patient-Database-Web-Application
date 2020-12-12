package com.example.patientDatabase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Using a JPA repository 
//JPA Data is like a lazy version of JDBC.
//It will automatically handle all the database stuff using just annotations
//Hibernate also helps us to futher connect with MySQL

//Similar to CRUDRepository-Create,Read,Upadte,Delete

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	List<Patient> findByName(String name);
}
