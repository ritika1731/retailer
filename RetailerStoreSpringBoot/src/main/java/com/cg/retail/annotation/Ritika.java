package com.cg.retail.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.TYPE)  
 public @interface Ritika {

	String author() default "Pankaj";
}	



