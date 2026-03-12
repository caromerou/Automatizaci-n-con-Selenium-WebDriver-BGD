package com.saucedemo.questions;

import com.saucedemo.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheCartBadge {
    public static Question<String> value() {
        return actor -> Text.of(InventoryPage.CART_BADGE).answeredBy(actor);
    }
}