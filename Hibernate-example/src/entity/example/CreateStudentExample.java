package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class CreateStudentExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // The file name is not needed. The
								 .addAnnotatedClass(Student.class) 					// cfg.xml file is found in src folder.
								 .buildSessionFactory(); 							// configure() can be used.

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object		
			// create a student object
			System.out.println("Creating new student object..");
			Student student=new Student("Jim","Doyle","jdoyle3@domain.com");
		
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving student..");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}
}
