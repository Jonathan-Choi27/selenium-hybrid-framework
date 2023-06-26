package com.practice.steps;

import com.practice.constants.Endpoint;
import com.practice.context.TestContext;
import com.practice.objects.BillingDetails;
import com.practice.pages.PageFactoryManager;
import com.practice.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CustomerSteps {
    private final TestContext context;
    private final StorePage storePage;

    public CustomerSteps(TestContext context) {
        storePage = PageFactoryManager.getStorePage(context.driver);
        this.context = context;
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        storePage.load(Endpoint.STORE.url);
    }
}
