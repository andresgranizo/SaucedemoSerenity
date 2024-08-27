package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static com.saucedemo.ui.CartPage.*;

public class AddToCart implements Task {

    public static AddToCart theProducts() {
        return new AddToCart();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PRODUCT_ONE),
                Click.on(PRODUCT_TWO),
                Click.on(CART_BUTTON)
        );
    }
}
