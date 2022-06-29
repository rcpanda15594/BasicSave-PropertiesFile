package com.nt.entity;

import java.lang.reflect.Constructor;

import lombok.Data;

@Data
public class EmpDetails {
	
	private int no;
	private String fname;
	private String lname;
	private String mail;
	
public EmpDetails() {
	System.out.println("EmpDetails:0-param constructor");
}
	

}
