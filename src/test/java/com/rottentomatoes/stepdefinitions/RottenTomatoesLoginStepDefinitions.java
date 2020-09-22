package com.rottentomatoes.stepdefinitions;

import static com.rottentomatoes.exceptions.FailedLogin.FAILED_LOGIN;
import static com.rottentomatoes.util.ConstantManager.USER;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

import com.rottentomatoes.exceptions.FailedLogin;
import com.rottentomatoes.questions.SuccessfullLogin;
import com.rottentomatoes.tasks.Login;
import com.rottentomatoes.userinterface.RTMainPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class RottenTomatoesLoginStepDefinitions {

	private RTMainPage mainPage;

	@Given("The user enters the Rotten Tomatoes web page")
	public void theUserEntersTheRottenTomatoesWebPage() {
		OnStage.setTheStage(new OnlineCast());
		theActorCalled(USER).attemptsTo(Open.browserOn(mainPage));
	}

	@When("The user logins with {string} and {string}")
	public void theUserLoginsWithAnd(String username, String password) {
		theActorInTheSpotlight().attemptsTo(Login.with(username, password));
	}

	@Then("The user should enter the account")
	public void theUserShouldEnterTheAccount() {
		theActorInTheSpotlight().should(eventually(seeThat(SuccessfullLogin.onThePage(), is(true)))
				.waitingForNoLongerThan(1).seconds().orComplainWith(FailedLogin.class, FAILED_LOGIN));
	}
}
