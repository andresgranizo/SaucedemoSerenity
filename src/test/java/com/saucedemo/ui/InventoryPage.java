package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {
    public static final Target PRODUCT_BUTTON = Target.the("Add to cart button for product {0}")
            .locatedBy("//div[text()='{0}']/following-sibling::button");
    public static final Target CART_BUTTON = Target.the("Cart button").locatedBy(".shopping_cart_link");
}
