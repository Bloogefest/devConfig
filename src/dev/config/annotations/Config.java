package dev.config.annotations;

import dev.config.Flow;
import dev.config.Language;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Config {
    String path();
    Flow flow() default Flow.Strict;
    Language language();
    boolean extension() default true;
    Resource resource() default @Resource;
    Repair repair() default @Repair;
    Save save() default @Save;
}
