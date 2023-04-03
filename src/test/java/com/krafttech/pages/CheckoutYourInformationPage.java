package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends BasePage{

    @FindBy(id = "first-name")
    public WebElement firstNameInputBar;

    public void fillInfoForm(String firstName, String lastName, String postalCode){
        Actions actions=new Actions(Driver.get());
        actions.click(firstNameInputBar)
                .sendKeys(firstName+Keys.TAB)
                .sendKeys(lastName+ Keys.TAB)
                .sendKeys(postalCode).perform();
    }

}
