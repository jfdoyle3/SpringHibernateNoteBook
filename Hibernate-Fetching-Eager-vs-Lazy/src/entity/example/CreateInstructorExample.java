package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;



public class CreateInstructorExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure() 
								 .addAnnotatedClass(Instructor.class)				
								 .addAnnotatedClass(InstructorDetail.class)	
								 .addAnnotatedClass(Course.class)	      
								 .buildSessionFactory(); 							

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			// create the objects
			Instructor tempInstructor= new Instructor("Jim","Doyle","jdoyle@careerdevs.com");
			InstructorDetail tempInstructorDetail=new InstructorDetail("https://www.youtube.com","Coding");
			//Instructor tempInstructor= new Instructor("Sasha","Smith","ssmith@careerdevs.com");
			//InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com","Video Games");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
		
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving Instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
