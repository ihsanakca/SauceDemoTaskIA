package com.krafttech.steps_defs;

import com.krafttech.pages.CheckoutYourInformationPage;
import io.cucumber.java.en.When;

public class CheckoutInfo_StepDefs {
    CheckoutYourInformationPage checkoutYourInformationPage=new CheckoutYourInformationPage();
    @When("The user should be able to fill form with: {string}, {string} and {string}")
    public void theUserShouldBeAbleToFillFormWithAnd(String firstName, String lastName, String postalCode) {
        checkoutYourInformationPage.fillInfoForm(firstName,lastName,postalCode);
    }
}
