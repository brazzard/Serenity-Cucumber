package org.serenity.example.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import org.serenity.example.steps.GoogleSteps;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/features/check_first_link_title.feature")
public class AppTest {
    private String baseUrl = "https://google.com";
    private String keyword = "automation";

    @Steps
    GoogleSteps google;

    @Given("^I am the user who opens the home page$")
    public void i_am_the_user_who_opens_the_home_page() {
        google.opens_home_page(baseUrl);
    }

    @When("^I searches for keyword$")
    public void i_searches_for_keyword() {
        google.searches_for_items_containing(keyword);
    }

    @And("^I open first link$")
    public void i_open_first_link() {
        google.open_first_link();
    }

    @Then("^I should check page title$")
    public void i_should_check_page_title() {
        google.check_title(keyword);
    }
}