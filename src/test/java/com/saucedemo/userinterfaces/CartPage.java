package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target CART_ITEM = Target.the("ítem en carrito")
            .locatedBy("//div[@class='cart_item']//div[text()='{0}']");
    public static final Target REMOVE_BUTTON = Target.the("botón remover")
            .locatedBy("//div[text()='{0}']/ancestor::div[@class='cart_item']//button");
    public static final Target CHECKOUT_BUTTON = Target.the("botón checkout")
            .located(By.id("checkout"));
}