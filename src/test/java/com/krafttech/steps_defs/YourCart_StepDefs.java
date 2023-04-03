package com.krafttech.steps_defs;

import com.krafttech.pages.YourCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class YourCart_StepDefs {
    YourCartPage yourCartPage =new YourCartPage();
    @And("The user should see the items on the page that added before")
    public void theUserShouldSeeTheItemsOnThePageThatAddedBefore(List<String> addedItemsList) {
        yourCartPage.verifyAddedItemsToCart(addedItemsList);
    }
    @When("The user should be able to delete items from cart with item name :{string}")
    public void theUserShouldBeAbleToDeleteItemsFromCartWithItemName(String itemName) {
        yourCartPage.deleteItemFromCart(itemName);
    }

    @When("The user navigate to page with related button: {string}")
    public void theUserNavigateToPageWithRelatedButton(String relatedButton) {
        yourCartPage.navigateToPage(relatedButton);
    }
}
