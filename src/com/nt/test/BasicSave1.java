package com.nt.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.EmpDetails;

import oracle.net.aso.f;

public class BasicSave1 {

	public static void main(String[] args) {
		
		int idVal=0;
		
		try {
		//locate properties file
		InputStream is=new FileInputStream("src/com/nt/commons/hibernate.properties");
      	
		//create properties file obj
		Properties props=new Properties();
		
		//load prop content in to properties file obj
		props.load(is);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//activate hibernate 
		Configuration cfg=new Configuration();
		
		//Set hibernate cfg properties
	cfg.setProperties(props);
	
		//add mapping files
		cfg.addFile("src/com/nt/entity/Employee.hbm.xml");
		
		//build sessionFactory
		SessionFactory factory=cfg.buildSessionFactory();
		
		//open session
		Session ses=factory.openSession();
		
		//Prepare entity class obj having data
		EmpDetails details= new EmpDetails();
		
		details.setNo(991);
		details.setFname("raja31");
		details.setLname("rao");
		details.setMail("rao@gmail.com");
		
		//save obj
		ses.save(details);
		ses.flush();
		
		//close obj
		ses.close();
	    factory.close();
		
	 }

}
