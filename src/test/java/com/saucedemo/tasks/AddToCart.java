package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


import static com.saucedemo.ui.InventoryPage.CART_BUTTON;
import static com.saucedemo.ui.InventoryPage.PRODUCT_BUTTON;

public class AddToCart implements Task {

    private final String product1;
    private final String product2;

    public AddToCart(String product1, String product2) {
        this.product1 = product1;
        this.product2 = product2;
    }

    public static AddToCart theProducts(String product1, String product2) {
        return new AddToCart(product1, product2);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PRODUCT_BUTTON.of(product1)),
                Click.on(PRODUCT_BUTTON.of(product2)),
                Click.on(CART_BUTTON)
        );
    }
}
