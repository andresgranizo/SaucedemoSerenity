package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ViewCart implements Task {

    private static final Target CART_ICON = Target.the("Shopping cart icon")
            .locatedBy(".shopping_cart_link");

    @Override
    @Step("{0} views the cart content")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CART_ICON)
        );
    }

    public static ViewCart content() {
        return new ViewCart();
    }
}
