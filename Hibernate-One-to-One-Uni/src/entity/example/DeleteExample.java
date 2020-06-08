package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;



public class DeleteExample {

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
			
			// get instructor by primary key / id
			int theId=1;
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: "+ tempInstructor);
			// delete the instructors
			if (tempInstructor != null) {
				System.out.println("Deleteing: "+tempInstructor);
				
				// Note: will ALSO delete associated "details" object
				// because of CascadeType.ALL
				//
				session.delete(tempInstructor);
				
			}
				
				
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}
}
