package com.practice.steps;

import com.practice.apis.CartApi;
import com.practice.context.TestContext;
import com.practice.objects.Product;
import com.practice.pages.CartPage;
import com.practice.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartSteps {
    private final CartPage cartPage;
    private final TestContext context;

    public CartSteps(TestContext context) {
        this.context = context;
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

    @And("I have {int} {product} in the cart")
    public void iHaveInTheCart(int quantity, Product product) throws Exception {
         CartApi cartApi = new CartApi(context.cookies.getCookies());
        product = context.productList.getProductByName(product.getName());
        cartApi.addToCart(product.getId(), quantity);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
        context.product = product;
    }
}
