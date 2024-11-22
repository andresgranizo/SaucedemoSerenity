package com.saucedemo.features;

import com.saucedemo.tasks.ViewCart;
import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.saucedemo.tasks.Login;
import com.saucedemo.tasks.AddToCart;
import com.saucedemo.tasks.CompletePurchase;

import static com.google.common.base.Predicates.equalTo;
import static com.saucedemo.utils.UserData.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com.saucedemo.steps"
)
public class CheckoutTest {

    private Actor user;

    @Managed
    WebDriver driver;

    @BeforeEach
    void setUp() {
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("User");
        user.can(BrowseTheWeb.with(driver));
    }
    @Test
    void userShouldBeAbleToCompletePurchase() {
        String product1 = "Sauce Labs Backpack";
        String product2 = "Sauce Labs Bike Light";
        givenThat(user).wasAbleTo(Login.withCredentials(USERNAME, PASSWORD));
        when(user).attemptsTo(AddToCart.theProducts(product1, product2));
        when(user).attemptsTo(ViewCart.content());
        when(user).attemptsTo(CompletePurchase.form("FirstName", "LastName", "12345"));
        String confirmationMessage = Text.of(CheckoutPage.THANK_YOU_MESSAGE).answeredBy(user);
        System.out.println("Confirmation Message: " + confirmationMessage);
    }
}