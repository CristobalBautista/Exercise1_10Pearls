package com.rottentomatoes.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RTMainPage extends PageObject {

	public static final Target OPEN_LOGIN_FORM_BUTTON = Target.the("the open login form button")
			.locatedBy("#masthead-show-login-btn");
	public static final Target USERNAME_INPUT = Target.the("the username input").locatedBy("#login-form-username");
	public static final Target PASSWORD_INPUT = Target.the("the password input").locatedBy("#login-form-password");
	public static final Target LOGIN_BUTTON = Target.the("the login input").locatedBy("#login-form-submit-btn");
	public static final Target LOGIN_FORM = Target.the("the login form error message")
			.locatedBy("//div[@class='modal__body login-form__body']");

}
