package org.serenity.example.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.serenity.example.pages.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSteps {

    HomePage homePage;
    SearchResultPage searchResultsPage;
    OpenedPage openedPage;

    @Step
    public void opens_home_page(String baseUrl) {
        homePage = open(baseUrl, HomePage.class);
    }

    @Step
    public void searches_for_items_containing(String keyword) {
        searchResultsPage = homePage.search(keyword);
    }

    @Step
    public void open_first_link() {
        openedPage = searchResultsPage.firstPage();
    }

    @Step
    public void check_title(String keyword) {
        String title = openedPage.getTitle();
        Assert.assertTrue("First link doesn't contain searched word", title.toLowerCase().contains(keyword));
    }


}