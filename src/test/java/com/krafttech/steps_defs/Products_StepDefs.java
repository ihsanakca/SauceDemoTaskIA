package com.krafttech.steps_defs;

import com.krafttech.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Products_StepDefs {
    ProductsPage productsPage = new ProductsPage();

    @Then("The user should be able to see page title: {string}")
    public void theUserShouldBeAbleToSeePageTitle(String pageTitle) {
        String actualPageTitle =   productsPage.getPageTitle(pageTitle);
        Assert.assertEquals(pageTitle,actualPageTitle);
    }

    @When("The user should be able to sort items order type: {string}")
    public void theUserShouldBeAbleToSortItemsOrderType(String orderType) {
        productsPage.sortItems(orderType);
    }

    @And("The user should be able to add items to cart with item name: {string}")
    public void theUserShouldBeAbleToAddItemsToCartWithItemName(String itemName) {
        productsPage.addItem(itemName);
    }

    @Then("The number on the basket icon should show the added item number")
    public void theNumberOnTheBasketIconShouldShowTheAddedItemNumber() {
        Assert.assertEquals(ProductsPage.addedItemNumber,productsPage.getAddedItemNumber());
    }
    @When("The user navigate to your cart page")
    public void theUserNavigateToYourCartPage() {
        productsPage.yourCartLink.click();
    }
}
