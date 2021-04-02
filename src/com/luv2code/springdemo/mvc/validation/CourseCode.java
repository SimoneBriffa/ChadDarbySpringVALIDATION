package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
		
	/*
	 * Constraint specifica dove quale sia la classe dove sono presenti
	 * le specifiche.
	 * 
	 * Target specifica che questa annotazione può essere applicata
	 * a campi e metodi
	 * 
	 * Retention specifica che questa annotazione entra in azione a runtime
	 */
	
	public String value() default "LUV";
	
	public String message() default "must start with LUV";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {}; 
	/*payload riguarda la fornitura di informazioni addizionali per eventuali errori */
	
}
