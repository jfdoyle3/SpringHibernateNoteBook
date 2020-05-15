package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class DeleteStudentExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 3;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id:  " + studentId);

			Student deleteStudent = session.get(Student.class, studentId);
			
			// delete the student by integer Id variable 
			// System.out.println("Deleting student: "+deleteStudent);
			// session.delete(deleteStudent);

			// delete student by query
			System.out.println("Deleting student id=4");
			session.createQuery("delete from Student where id=4").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}
}
