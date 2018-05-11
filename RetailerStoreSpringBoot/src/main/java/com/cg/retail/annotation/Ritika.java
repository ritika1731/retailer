package com.cg.retail.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
 public @interface Ritika {

	String author() default "Pankaj";
}	



