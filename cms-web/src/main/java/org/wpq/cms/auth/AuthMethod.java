package org.wpq.cms.auth;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface AuthMethod {
	public String role() default "ADMIN";
}
