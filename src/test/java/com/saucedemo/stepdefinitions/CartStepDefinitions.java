package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.TheCartBadge;
import com.saucedemo.questions.TheConfirmationMessage;
import com.saucedemo.tasks.AddToCart;
import com.saucedemo.tasks.Login;
import com.saucedemo.tasks.ProceedToCheckout;
import com.saucedemo.tasks.RemoveFromCart;
import com.saucedemo.userinterfaces.CheckoutPage;
import com.saucedemo.userinterfaces.InventoryPage;
import com.saucedemo.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class CartStepDefinitions {

    private Actor actor;

    @Given("the actor has logged in as standard user")
    public void theActorHasLoggedInAsStandardUser() {
        actor = OnStage.theActorCalled("Usuario");
        actor.attemptsTo(Login.withCredentials(
                ConfigReader.get("standard.user"),
                ConfigReader.get("password")
        ));
    }

    @Given("has the product {string} in the cart")
    public void hasTheProductInTheCart(String productName) {
        actor.attemptsTo(
                AddToCart.product(productName),
                Click.on(InventoryPage.CART_LINK)
        );
    }

    @When("adds the product {string} to the cart")
    public void addsTheProductToTheCart(String productName) {
        actor.attemptsTo(AddToCart.product(productName));
    }

    @Then("the cart should show {int} product")
    public void theCartShouldShowProduct(int quantity) {
        actor.attemptsTo(
                WaitUntil.the(InventoryPage.CART_BADGE, isVisible()).forNoMoreThan(10).seconds()
        );
        actor.should(seeThat(TheCartBadge.value(), equalTo(String.valueOf(quantity))));
    }

    @When("proceeds to checkout and completes shipping information")
    public void proceedsToCheckoutAndCompletesShippingInformation() {
        actor.attemptsTo(
                Click.on(InventoryPage.CART_LINK),
                ProceedToCheckout.withInfo("Juan", "Perez", "12345")
        );
    }

    @And("finishes the purchase")
    public void finishesThePurchase() {
        // Ya se hace en ProceedToCheckout
    }

    @Then("should see a purchase confirmation message")
    public void shouldSeeAPurchaseConfirmationMessage() {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.CONFIRMATION_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
        actor.should(seeThat(TheConfirmationMessage.displayed(),
                equalTo("Thank you for your order!")));
    }

    @When("adds the products {string} and {string} to the cart")
    public void addsTheProductsAndToTheCart(String product1, String product2) {
        actor.attemptsTo(
                AddToCart.product(product1),
                AddToCart.product(product2)
        );
    }

    @And("removes the product {string} from the cart")
    public void removesTheProductFromTheCart(String productName) {
        actor.attemptsTo(
                Click.on(InventoryPage.CART_LINK),
                RemoveFromCart.product(productName)
        );
    }
}