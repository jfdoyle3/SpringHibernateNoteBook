package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import entity.Student;

public class AddCoursesForJimExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse= new Course("Learn Java coding");
			
			// save the course
			System.out.println("\n||Saving the course ...");
			session.save(tempCourse);
			System.out.println("||Saved the course:  "+tempCourse);
			
			// create the students 
			Student tempStudent1=new Student("Jim","Doyle","jdoyle@careerdevs.com");
			Student tempStudent2=new Student("Sasha","Smith","ssmith@careerdevs.com");
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save students
			System.out.println("\n||Saving the students ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("||Saved the students:  "+tempCourse.getStudents());
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}
}
