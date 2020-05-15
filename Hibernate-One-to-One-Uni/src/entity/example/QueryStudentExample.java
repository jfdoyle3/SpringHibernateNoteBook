package entity.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class QueryStudentExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // The file name is not needed. The
								 .addAnnotatedClass(Student.class) 					// cfg.xml file is found in src folder.
								 .buildSessionFactory(); 							// configure() can be used.

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> students=session.createQuery("from Student").getResultList();
			
			// display all students
			System.out.println(">>--> All students in database <--<<");
			displayStudents(students);
			
			// query students: lastname='Doyle'
			students=session.createQuery("from Student s where s.lastName='Doyle'").getResultList();
			
			// display queried student
			System.out.println("\n\n>>--> Students who have last name of Doyle <--<<");
			displayStudents(students);
			
			// query students: lastName='Smith' OR firstName='Bugs'
			students=session.createQuery("from Student s where"
											+" s.lastName='Smith' OR s.firstName='Bugs'").getResultList();
			System.out.println("\n\n>>--> Students who have last name of Smith OR first name of Bugs <--<<");
			displayStudents(students);
	  		
			// query students where email LIKE '%domain.com'
			students=session.createQuery("from Student s where"
												+" s.email LIKE '%domain.com'").getResultList();
			System.out.println("\n\n>>--> Students who's email ends with domain.com <--<<");
			
			displayStudents(students);
			
			// query students where email LIKE '%gmail.com'
			students=session.createQuery("from Student s where"
												+" s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\n>>--> Students who's email ends with gmail.com <--<<");
			displayStudents(students);
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for  (Student student : students) {
			System.out.println(student);
		}
	}
}
