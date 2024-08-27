package com.saucedemo.tasks;

import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class CompletePurchase {

    public static Task form(String firstName, String lastName, String zipCode) {
        return Task.where("{0} completes the form",
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),
                Enter.theValue(zipCode).into(CheckoutPage.ZIP_CODE),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }

    public static Task confirm() {
        return Task.where("{0} completes the purchase",
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }

    public static Question<Boolean> andSeeConfirmation() {
        return actor -> {
            String actualMessage = Text.of(CheckoutPage.THANK_YOU_MESSAGE).answeredBy(actor);
            System.out.println("Actual confirmation message: " + actualMessage);
            return actualMessage.equalsIgnoreCase("Thank you for your order!");
        };
    }
}
