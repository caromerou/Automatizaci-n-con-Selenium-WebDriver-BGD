package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.NotificationPopup;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CloseNotificationTask implements Task {

    public static CloseNotificationTask ifPresent() {
        return instrumented(CloseNotificationTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(NotificationPopup.NOTIFICATION, isVisible()).forNoMoreThan(3).seconds(),
                Check.whether(NotificationPopup.NOTIFICATION.resolveFor(actor).isVisible())
                        .andIfSo(Click.on(NotificationPopup.ACCEPT_BUTTON))
        );
    }
}