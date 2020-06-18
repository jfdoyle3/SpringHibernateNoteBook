package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;

public class CreateCoursesAndReviewsExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse= new Course("Learn Java coding");
			
			// add some reviews
			tempCourse.addReview(new Review("Great Course ... Love it!"));
			tempCourse.addReview(new Review("Excellent Course, I enjoyed it"));
			tempCourse.addReview(new Review("To Simple, Doesn't cover enough material"));
			
			// save the course .. and leverage the cascade all.
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}
}
