package com.rottentomatoes.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/rotten_tomatoes_login.feature", 
		glue = "com.rottentomatoes.stepdefinitions",
		snippets = SnippetType.CAMELCASE
		)

public class RottenTomatoesLogin {

}
