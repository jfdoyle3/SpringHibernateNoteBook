package example.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy= CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	// define default course code
	public String value() default "101";
	
	// define default error message
	public String message() default "must start with 101, You have to start somewhere.";
	// define default groups, not using groups. using a 'boilerplate' line.
	public Class<?>[] groups() default {};
	// define default payloads, not using payloads. using a 'boilerplate' line.
	public Class<? extends Payload>[]  payload() default {}; 
}
