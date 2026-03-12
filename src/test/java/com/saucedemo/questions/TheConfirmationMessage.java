package com.saucedemo.questions;

import com.saucedemo.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheConfirmationMessage {
    public static Question<String> displayed() {
        return actor -> Text.of(CheckoutPage.CONFIRMATION_MESSAGE).answeredBy(actor);
    }
}