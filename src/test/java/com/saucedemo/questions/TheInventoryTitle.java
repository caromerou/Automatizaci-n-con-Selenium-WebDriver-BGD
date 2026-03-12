package com.saucedemo.questions;

import com.saucedemo.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheInventoryTitle {
    public static Question<String> displayed() {
        return actor -> Text.of(InventoryPage.PRODUCT_TITLE).answeredBy(actor);
    }
}