package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class RemoveFromCart {
    public static Performable product(String productName) {
        return Task.where("{0} elimina el producto " + productName + " del carrito",
                Click.on(CartPage.REMOVE_BUTTON.of(productName))
        );
    }
}