package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class PrimaryKeyExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating 3 student object..");
			Student student1 = new Student("Paul", "Jones", "pjones@xyzzy.com");
			Student student2 = new Student("Sam", "Smith", "ssmith@piper.net");
			Student student3 = new Student("Mary", "Kaye", "mkaye@domain.com");

			session.beginTransaction();

			System.out.println("Saving students..");
			session.save(student1);
			session.save(student2);
			session.save(student3);

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
