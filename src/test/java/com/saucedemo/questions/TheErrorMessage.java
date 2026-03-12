package com.saucedemo.questions;

import com.saucedemo.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheErrorMessage {
    public static Question<String> displayed() {
        return actor -> Text.of(LoginPage.ERROR_MESSAGE).answeredBy(actor);
    }
}