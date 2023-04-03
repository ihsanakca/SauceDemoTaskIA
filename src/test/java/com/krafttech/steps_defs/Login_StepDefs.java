package com.krafttech.steps_defs;

import com.krafttech.pages.LoginPage;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Login_StepDefs {
    LoginPage loginPage=new LoginPage();
    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user type in valid credentials: {string} and {string}")
    public void theUserTypeInValidCredentialsAnd(String userName, String password) {
    loginPage.loginMtd(userName,password);
    }
}
