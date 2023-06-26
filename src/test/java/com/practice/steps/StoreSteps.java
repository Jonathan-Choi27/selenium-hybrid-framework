package com.practice.steps;

import com.practice.constants.Endpoint;
import com.practice.context.TestContext;
import com.practice.objects.Product;
import com.practice.pages.PageFactoryManager;
import com.practice.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreSteps {
    private final StorePage storePage;
    private final TestContext context;

    public StoreSteps(TestContext context) {
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the store page")
    public void iMOnTheStorePage() {
        storePage.load(Endpoint.STORE.url);
    }

    @When("I add it again")
    public void iAddItAgain() {
        storePage.addToCart(context.product.getName());
    }

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        storePage.addToCart(product.getName());
    }
}
