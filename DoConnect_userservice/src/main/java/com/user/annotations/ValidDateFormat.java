package com.user.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidDateFormatValidator.class)
@Documented
public @interface ValidDateFormat {
	String message() default "Invalid date format";

	String pattern() default "dd-MM-yyyy";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

class ValidDateFormatValidator implements ConstraintValidator<ValidDateFormat, String> {

	private String pattern;

	@Override
	public void initialize(ValidDateFormat constraintAnnotation) {
		this.pattern = constraintAnnotation.pattern();
	}

	@Override
	public boolean isValid(String date, ConstraintValidatorContext context) {
		if (date == null || date.trim().isEmpty()) {
			return true;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
		dateFormat.setLenient(false);

		try {
			Date parsedDate = dateFormat.parse(date);
			Date currentDate = new Date();
			return (parsedDate.equals(currentDate) || parsedDate.before(currentDate)) && date.length() == 10;

		} catch (ParseException e) {
			return false;
		}
	}
}