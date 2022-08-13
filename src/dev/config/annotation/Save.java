package dev.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Save {
    boolean value() default true;

    boolean changes() default false;

    long interval() default 0;

    TimeUnit unit() default TimeUnit.MILLISECONDS;
}
