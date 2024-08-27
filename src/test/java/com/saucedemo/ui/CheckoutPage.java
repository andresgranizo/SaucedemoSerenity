package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target FIRST_NAME = Target.the("First name field").located(By.id("first-name"));
    public static final Target LAST_NAME = Target.the("Last name field").located(By.id("last-name"));
    public static final Target ZIP_CODE = Target.the("Zip code field").located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("Continue button").located(By.id("continue"));
    public static final Target FINISH_BUTTON = Target.the("Finish button").located(By.id("finish"));
    public static final Target THANK_YOU_MESSAGE = Target.the("Thank you message")
            .located(By.cssSelector(".complete-header"));
}

