package com.example.patientDatabase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//This will create patients database
@Table(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//Auto generating the ids
	//So these ids are not like index in databases so if you delete one row next id will be selected.
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "date")
	private String date;
	  
	@Column(name = "temp")
	private int temp;
	  
	@Column(name = "symptoms")
	private String symptoms;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_no")
	private long phoneNo;
	
	//Constructors
	public Patient() {
		super();
	}

	public Patient(String name, String email,int age, String date, int temp, String symptoms) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.date = date;
		this.temp = temp;
		this.symptoms = symptoms;
	}
	
	
	//Using getter and setter for future use
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
}
