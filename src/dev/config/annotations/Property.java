package dev.config.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Property {
    String value() default "";
    boolean optional() default false;
    boolean nullable() default false;
    Save save() default @Save;
}
