package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import java.time.Duration;

public class LoginPage {
    public static final Target USERNAME = Target.the("campo de usuario")
            .located(By.id("user-name"));
    public static final Target PASSWORD = Target.the("campo de contraseña")
            .located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("botón de login")
            .located(By.id("login-button"));
    public static final Target ERROR_MESSAGE = Target.the("mensaje de error")
            .located(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3"))
            .waitingForNoMoreThan(Duration.ofSeconds(10));
}