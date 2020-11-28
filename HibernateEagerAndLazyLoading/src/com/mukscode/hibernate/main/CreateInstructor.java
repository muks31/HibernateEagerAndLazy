package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Course;
import com.mukscode.hibernate.entity.Instructor;
import com.mukscode.hibernate.entity.InstructorDetail;


public class CreateInstructor {

public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{
			//create the objects
			Instructor theInstructor = new Instructor("Chandler", "Bing", "bing@yahoo.com");
			
			InstructorDetail theInstructorDetail = new InstructorDetail("youtube.com/chandler","Sarcasm");
			
			
			//associate the objects
			theInstructor.setInstructorDetailId(theInstructorDetail);
			
			//start transaction
			session.beginTransaction();
			
			//save the transaction
			//This will also save Instructor detail
			System.out.println("Saving Instructor "+theInstructor);
			session.save(theInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally 
		{
			factory.close();
		}
		
	}

}
