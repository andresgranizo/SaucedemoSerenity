package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target PRODUCT_ONE = Target.the("First product").located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target PRODUCT_TWO = Target.the("Second product").located(By.id("add-to-cart-sauce-labs-bike-light"));
    public static final Target CART_BUTTON = Target.the("Cart button").located(By.id("shopping_cart_container"));
}
