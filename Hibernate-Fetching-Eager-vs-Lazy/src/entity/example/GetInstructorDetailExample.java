package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;



public class GetInstructorDetailExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // The file name is not needed. The
								 .addAnnotatedClass(Instructor.class)				// cfg.xml file is found in src folder.
								 .addAnnotatedClass(InstructorDetail.class)				// configure() can be used.
								 .buildSessionFactory(); 							

		// create session
		Session session = factory.getCurrentSession();

		try {
						
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId=299;
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("tempInstructorDetail: "+tempInstructorDetail);
			
			// print the associated instructor
			System.out.println("the associated Instructor: "+ tempInstructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		catch (Exception exec) {
			exec.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}
}
