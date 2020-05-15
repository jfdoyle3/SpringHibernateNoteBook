package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class EntityTemplate {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // The file name is not needed. The
								 .addAnnotatedClass(Student.class) 					// cfg.xml file is found in src folder.
								 .buildSessionFactory(); 							// configure() can be used.

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			//session = factory.getCurrentSession();   // Use this line if using multiple sessions in one class
			session.beginTransaction();
			

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Transaction Completed!");
			
		} finally {
			factory.close();
		}
	}
}
