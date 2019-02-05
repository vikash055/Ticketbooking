package com.example.demo.model;

//import java.io.Serializable;
//import java.io.Serializable;
import java.sql.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.IdClass;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;


//import org.hibernate.validator.constraints.Length;


@Entity
public class Pessanger {
	
//	@Column
//	@NotNull
	//@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	//@NotEmpty(message = "id may not be empty")
	//@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") 
	private int id;
	
	//@NotEmpty(message = "fName may not be empty")
	//@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") 
//	@Column
//	@NotNull
	private String fname;
	
//	@NotEmpty(message = "lName may not be empty")
//	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") 
//	@Column
//	@NotNull
	private String lname;
	
	
	//@NotEmpty(message = "passportno may not be empty")
	
//@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") 
	
//	@Size(min=2,message="size grater than 2")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private int passportNo;
  
	//@NotEmpty(message = "doj may not be empty")
	//@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") 
//	@Column
	 
//	 @NotNull
	private Date doj;
	

	@Override
	public String toString() {
		return "Pessanger [id=" + id + ", fname=" + fname + ", lname=" + lname + ", passportNo=" + passportNo + ", doj="
				+ doj + "]";
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessanger()
	{
		
	}

}
