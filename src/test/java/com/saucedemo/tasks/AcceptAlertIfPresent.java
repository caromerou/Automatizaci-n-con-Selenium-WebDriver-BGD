package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.NoAlertPresentException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AcceptAlertIfPresent implements Task {

    public static AcceptAlertIfPresent now() {
        return instrumented(AcceptAlertIfPresent.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.abilityTo(BrowseTheWeb.class).getDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            // No hay alerta, continuar
        }
    }
}