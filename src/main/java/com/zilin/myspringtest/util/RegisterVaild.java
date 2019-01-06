package com.zilin.myspringtest.util;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.regex.Pattern;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RegisterVaild.RegisterChecker.class)
public @interface RegisterVaild {
    String message() default "Info is incorrect";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class RegisterChecker implements ConstraintValidator<RegisterVaild, String>{

        @Override
        public void initialize(RegisterVaild constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if(value == null){
                return true;
            }
            String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9]{8,16}$";
            if(Pattern.matches(pattern, value) == true){
                return true;
            }
            return false;
        }
    }
}
