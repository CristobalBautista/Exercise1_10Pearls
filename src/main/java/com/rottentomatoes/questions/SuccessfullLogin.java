package com.rottentomatoes.questions;

import static com.rottentomatoes.userinterface.RTMainPage.LOGIN_FORM;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;

public class SuccessfullLogin implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		return !Presence.of(LOGIN_FORM).viewedBy(actor).asBoolean();
	}

	public static SuccessfullLogin onThePage() {
		return new SuccessfullLogin();
	}
}
