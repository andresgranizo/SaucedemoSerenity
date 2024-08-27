package com.saucedemo.steps;

import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Step;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import com.saucedemo.tasks.*;

public class CheckoutSteps {

    @Step("Log in to the application")
    public void logIn() {
        givenThat(OnStage.theActorInTheSpotlight()).wasAbleTo(Login.withCredentials("standard_user", "secret_sauce"));
    }

    @Step("Add products to the cart")
    public void addProductsToCart() {
        when(OnStage.theActorInTheSpotlight()).attemptsTo(AddToCart.theProducts());
    }

    @Step("Complete the purchase")
    public void completePurchase() {
        then(OnStage.theActorInTheSpotlight()).should(
                seeThat("Order confirmation is visible", CompletePurchase.andSeeConfirmation(), equalTo(true))
        );
    }
}
