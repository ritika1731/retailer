package com.cg.retail.annotation;

import java.lang.annotation.Annotation;

public class Hello  {

	public static void main(String[] args) {
		HelloClass hello = new HelloClass();
		Class<? extends HelloClass> c=hello.getClass();
		Annotation an = c.getAnnotation(Ritika.class);
		Ritika ritika = (Ritika) an;
		System.out.println(ritika.author());
		System.out.println(hello.bookName);
	}
}
