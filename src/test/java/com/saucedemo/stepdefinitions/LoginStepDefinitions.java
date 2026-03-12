package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.TheErrorMessage;
import com.saucedemo.questions.TheInventoryTitle;
import com.saucedemo.tasks.CloseNotificationTask;
import com.saucedemo.tasks.Login;
import com.saucedemo.userinterfaces.InventoryPage;
import com.saucedemo.userinterfaces.LoginPage;
import com.saucedemo.utils.ConfigReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {

    @Managed
    private WebDriver hisBrowser;
    private Actor actor;

    @Before
    public void setTheStage(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Usuario");
    }

    @Given("the actor is on the login page")
    public void theActorIsOnTheLoginPage() {
        actor.attemptsTo(Open.url(ConfigReader.get("base.url")));
    }

    @Given("the actor closes any browser notification")
    public void theActorClosesAnyBrowserNotification() {
       // actor.attemptsTo(CloseNotificationTask.ifPresent());
    }

    @When("the actor logs in with valid credentials")
    public void theActorLogsInWithValidCredentials() {
        actor.attemptsTo(Login.withCredentials(
                ConfigReader.get("standard.user"),
                ConfigReader.get("password")
        ));
    }

    @Then("the actor should see the product catalog")
    public void theActorShouldSeeTheProductCatalog() {
        actor.attemptsTo(
                WaitUntil.the(InventoryPage.PRODUCT_TITLE, isVisible()).forNoMoreThan(10).seconds()
        );
        actor.should(seeThat(TheInventoryTitle.displayed(), equalTo("Products")));
    }

    @When("the actor tries to log in with user {string} and password {string}")
    public void theActorTriesToLogInWithUserAndPassword(String user, String pass) {
        actor.attemptsTo(Login.withCredentials(user, pass));
    }

    @Then("should see an error message indicating incorrect credentials")
    public void shouldSeeAnErrorMessageIndicatingIncorrectCredentials() {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.ERROR_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
        actor.should(seeThat(TheErrorMessage.displayed(),
                containsString("Epic sadface: Username and password do not match")));
    }
}