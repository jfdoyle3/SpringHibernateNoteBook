package example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimCoachConfigExampleApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());

		// call our new swim coach methods ... has props value injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		System.out.println("name: " + theCoach.getName());

		// close the context
		context.close();
	}

}
