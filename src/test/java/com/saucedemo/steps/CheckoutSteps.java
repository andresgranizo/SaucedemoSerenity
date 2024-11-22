package com.saucedemo.steps;

import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

import com.saucedemo.tasks.*;

public class CheckoutSteps {

    @Given("the user logs in with username {string} and password {string}")
    public void logIn(String username, String password) {
        givenThat(OnStage.theActorInTheSpotlight()).wasAbleTo(Login.withCredentials(username, password));
    }

    @When("the user adds products {string} and {string} to the cart")
    public void addProductsToCart(String product1, String product2) {
        when(OnStage.theActorInTheSpotlight()).attemptsTo(AddToCart.theProducts(product1, product2));
    }

    @Then("the user completes the purchase and sees the confirmation message {string}")
    public void completePurchase(String confirmationMessage) {
        then(OnStage.theActorInTheSpotlight()).should(
                seeThat("Order confirmation is visible", CompletePurchase.andSeeConfirmation(), equalTo(confirmationMessage))
        );
    }
}
