package com.example.customvalidator.player.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PlayersPositionValidator.class)
public @interface Dictionary {
    public String message() default "Invalid playersPosition";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}
