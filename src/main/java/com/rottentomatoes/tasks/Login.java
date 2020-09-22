package com.rottentomatoes.tasks;

import static com.rottentomatoes.exceptions.FailedLogin.PAGE_NOT_LOADING;
import static com.rottentomatoes.userinterface.RTMainPage.LOGIN_BUTTON;
import static com.rottentomatoes.userinterface.RTMainPage.OPEN_LOGIN_FORM_BUTTON;
import static com.rottentomatoes.userinterface.RTMainPage.PASSWORD_INPUT;
import static com.rottentomatoes.userinterface.RTMainPage.USERNAME_INPUT;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.rottentomatoes.exceptions.FailedLogin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {

	private String username, password;

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.should(eventually(seeThat(the(OPEN_LOGIN_FORM_BUTTON), isPresent())).waitingForNoLongerThan(20).seconds()
				.withNoReporting().orComplainWith(FailedLogin.class, PAGE_NOT_LOADING));
		actor.attemptsTo(
				Click.on(OPEN_LOGIN_FORM_BUTTON), 
				Enter.theValue(username).into(USERNAME_INPUT),
				Enter.theValue(password).into(PASSWORD_INPUT), 
				Click.on(LOGIN_BUTTON));
	}

	public static Login with(String username, String password) {
		return instrumented(Login.class, username, password);
	}

}
