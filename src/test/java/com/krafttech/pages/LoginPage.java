package com.krafttech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    public WebElement userNameInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    public void loginMtd(String userName, String password){
        userNameInputBox.sendKeys(userName);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
    }
}
