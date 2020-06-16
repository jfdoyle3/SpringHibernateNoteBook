package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;



public class CreateExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // The file name is not needed. The
								 .addAnnotatedClass(Instructor.class)				// cfg.xml file is found in src folder.
								 .addAnnotatedClass(InstructorDetail.class)				// configure() can be used.
								 .buildSessionFactory(); 							

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			// create the objects
			Instructor tempInstructor= new Instructor("Doyle","Jim","jdoyle@school.edu");
			InstructorDetail tempInstructorDetail=new InstructorDetail("MyYouTube Channel","coding");
			//Instructor tempInstructor= new Instructor("Smith","Sam","ssmith@school.edu");
			//InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com","hiking");
			
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
			factory.close();
		}
	}
}
