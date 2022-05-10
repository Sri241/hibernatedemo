package com.wipro.training.hibernatedemo2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//hibernate2 application to save a student object in DataBase
//using Annotation Configuration - JPA 

@Entity
@Table(name="Student")

public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int rollNumber;
	   
    String name,branch;
    double marks;
    
    
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
    
    
}
