package org.serenity.example.pages;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    public SearchResultPage search(String query) {
        $("[name = 'q']").setValue(query).pressEnter();
        return page(SearchResultPage.class);
    }

}
