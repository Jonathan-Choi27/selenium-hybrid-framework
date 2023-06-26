package com.practice.steps;

import com.practice.constants.Endpoint;
import com.practice.context.TestContext;
import com.practice.pages.CheckoutPage;
import com.practice.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutSteps {
    private final TestContext context;
    private final CheckoutPage checkoutPage;

    public CheckoutSteps(TestContext context) {
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.load(Endpoint.CHECKOUT.url);
    }
}
