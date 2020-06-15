package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class FetchJoinExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// option 2: Hibernate query with HQL

			// get the instructor from db
			int theId = 2;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);

			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();

			System.out.println("Fetching example: Instructor: " + tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			// close session
			session.close();

			System.out.println("\nFetching example: The session is now closed.\n");
			System.out
					.println("Fetching LAZY emample: Created a HQL Query to retrieve ALL info: Instructor and courses");
			System.out.println("Fetching LAZY emample: The data is stored in the variable");
			System.out.println("Fetching LAZY emample: The code can call the getter and retrieve the data");
			System.out.println("Fetching LAZY example: after the session is closed\n");

			// get course for the instructor
			System.out.println("Fetching HQL example: Courses: " + tempInstructor.getCourses());
			System.out.println("Fetching example: Done!");

		} finally {
			session.close();
			factory.close();
		}
	}
}
