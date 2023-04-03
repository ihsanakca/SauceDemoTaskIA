package com.krafttech.steps_defs;

import com.krafttech.pages.CheckoutOverviewPage;
import io.cucumber.java.en.When;

public class CheckoutOverview_StepDefs {
    CheckoutOverviewPage checkoutOverviewPage=new CheckoutOverviewPage();
    @When("The user should be able to verify total price and number of items")
    public void theUserShouldBeAbleToVerifyTotalPriceAndNumberOfItems() {
        checkoutOverviewPage.verifyTotalPrice();
        checkoutOverviewPage.verifyNumberOfItems();
    }
}
