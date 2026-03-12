package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AddToCart {
    public static Performable product(String productName) {
        return Task.where("{0} añade el producto " + productName + " al carrito",
                Click.on(InventoryPage.ADD_TO_CART_BUTTON.of(productName))
        );
    }
}