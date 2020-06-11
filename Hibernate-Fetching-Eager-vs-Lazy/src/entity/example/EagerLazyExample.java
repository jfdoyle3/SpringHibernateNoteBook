package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class EagerLazyExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Fetching example: Instructor: "+ tempInstructor);
			// get course for the instructor
			System.out.println("Fetching example: Courses: "+tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Fetching example: Done!");

		} finally {
			session.close();
			factory.close();
		}
	}
}
