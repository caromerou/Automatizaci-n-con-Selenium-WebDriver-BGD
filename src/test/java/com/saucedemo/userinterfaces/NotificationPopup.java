package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class NotificationPopup {
    // Intentamos con varios selectores comunes
    public static final Target ACCEPT_BUTTON = Target.the("botón aceptar de la notificación")
            .locatedBy("//button[contains(text(),'Aceptar') or contains(text(),'Entendido') or contains(text(),'Ok')]");
    
    public static final Target NOTIFICATION = Target.the("contenedor de la notificación")
            .locatedBy("//div[contains(text(),'cambiar') or contains(text(),'password') or contains(text(),'contraseña')]");
}