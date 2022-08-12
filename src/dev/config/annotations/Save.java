package dev.config.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Save {
    boolean enabled() default true;
    boolean shutdown() default true;
    boolean changes() default false;
    Interval interval() default @Interval;
}
