package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mukscode.hibernate.entity.Course;
import com.mukscode.hibernate.entity.Instructor;
import com.mukscode.hibernate.entity.InstructorDetail;


public class FetchJoin {

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

			//start transaction
			session.beginTransaction();

			//get the instructor from db
			int theId = 1;

			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId",
					Instructor.class);

			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor
			Instructor theInstructor = query.getSingleResult();
			
			System.out.println("Found Instructor: "+theInstructor);

			//commit the transaction
			session.getTransaction().commit();

			//

			//close the session
			session.close();

			//get related courses
			System.out.println("Courses:" +theInstructor.getCourses());


			System.out.println("Done!!!");

		}
		finally 
		{
			factory.close();
		}

	}

}
