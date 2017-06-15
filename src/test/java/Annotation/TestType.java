package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//该注释在运行时可见
@Retention(RetentionPolicy.RUNTIME)
//该注释只能作用于字段
@Target(ElementType.TYPE)
public @interface TestType {

	public Class<?> Type();
	
}
