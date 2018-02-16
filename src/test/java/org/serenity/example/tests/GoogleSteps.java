package org.serenity.example.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.serenity.example.pages.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSteps {

    HomePage homePage;
    SearchResultPage searchResultsPage;
    OpenedPage openedPage;
    String expectedTitle;

    private String baseUrl = "https://google.com";
    private String keyword = "automation";

    @Given("^I am the user who opens the home page$")
    public void i_am_the_user_who_opens_the_home_page() {
        homePage = open(baseUrl, HomePage.class);
    }

    @When("^I searches for keyword$")
    public void i_searches_for_keyword() {
        searchResultsPage = homePage.search(keyword);
        expectedTitle = $("#res h3 a").getText();
    }

    @And("^I open first link$")
    public void i_open_first_link() {
        openedPage = searchResultsPage.firstPage();
    }

    @Then("^I should check page title$")
    public void i_should_check_page_title() {
        String title = openedPage.getTitle();
        Assert.assertEquals(expectedTitle, title);
        //Assert.assertTrue("First link doesn't contain searched word", title.toLowerCase().contains(keyword));
    }

}