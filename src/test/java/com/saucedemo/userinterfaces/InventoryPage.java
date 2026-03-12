package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {
    public static final Target PRODUCT_TITLE = Target.the("título del producto")
            .located(By.cssSelector(".title"));
    public static final Target ADD_TO_CART_BUTTON = Target.the("botón añadir al carrito")
            .locatedBy("//div[text()='{0}']/ancestor::div[@class='inventory_item']//button");
    public static final Target CART_BADGE = Target.the("contador del carrito")
            .located(By.cssSelector(".shopping_cart_badge"));
    public static final Target CART_LINK = Target.the("enlace al carrito")
            .located(By.cssSelector(".shopping_cart_link"));
}