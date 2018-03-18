package io.javabrains.sbs.topic;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { IsCorrectTopicValidator.class })
public @interface IsCorrectTopic {
	String message() default "Address is incorrect";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
