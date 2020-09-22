package com.rottentomatoes.exceptions;

@SuppressWarnings("serial")
public class FailedLogin extends AssertionError {
	public static final String FAILED_LOGIN = "The login failed. The username or the password are invalid.";
	public static final String PAGE_NOT_LOADING = "The web is not loading. There is slow internet or server is down.";

	public FailedLogin(String message, Throwable cause) {
		super(message, cause);
	}
}
