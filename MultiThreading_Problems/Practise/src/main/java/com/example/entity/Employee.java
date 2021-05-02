package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee{
	@Id
	String id;
	String name;
	String age;
	String email;
	public String getId() {
		return id;
	}
	public void setId(String data) {
		this.id = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String data) {
		this.age = data;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Employee() {
		super();
		
	}
	
	
	
	public Employee(String id, String name, String age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
}
