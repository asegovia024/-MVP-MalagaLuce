package BBDD.anotaciones;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Attribute {

	boolean isPrimaryKey() default false;
	boolean isAutoIncrement() default false;
	boolean isUnique() default false;
	boolean allowNull() default true;
}
