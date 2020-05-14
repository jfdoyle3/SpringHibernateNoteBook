package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class ReadStudentExample {

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
			Student student=new Student("Bugs","Bunny","bbunny@domain.com");
		
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving student..");
			System.out.println(student);
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+student.getId());
			
			// now get a new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id:  "+student.getId());
			Student getStudent=session.get(Student.class, student.getId());
			System.out.println("Get complete: "+getStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}
}
