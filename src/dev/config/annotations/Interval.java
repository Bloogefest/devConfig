package dev.config.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Interval {
    long value() default -1;
    TimeUnit unit() default TimeUnit.MILLISECONDS;
}
