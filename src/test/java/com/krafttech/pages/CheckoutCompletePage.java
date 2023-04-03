package com.krafttech.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{

    @FindBy(tagName = "h2")
    public WebElement successShoppingMessage;

    public void verifySuccessShoppingWithMessage(String expectedMessage){
        String actualMessage= successShoppingMessage.getText();
        Assert.assertEquals("should be same",expectedMessage,actualMessage);
    }
}
