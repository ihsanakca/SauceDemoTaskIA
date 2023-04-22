package com.krafttech.steps_defs;

import com.krafttech.pages.CheckoutYourInformationPage;
import com.krafttech.utilities.ExcelUtil;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CheckoutInfo_StepDefs {
    CheckoutYourInformationPage checkoutYourInformationPage=new CheckoutYourInformationPage();
    @When("The user should be able to fill form with: {string}, {string} and {string}")
    public void theUserShouldBeAbleToFillFormWithAnd(String firstName, String lastName, String postalCode) {
        checkoutYourInformationPage.fillInfoForm(firstName,lastName,postalCode);
    }

    @When("The user should be able to fill form with: {string}, {string} and {int}")
    public void the_user_should_be_able_to_fill_form_with_and(String firstName, String lastName, Integer zipCode) {
        checkoutYourInformationPage.fillInfoForm(firstName,lastName,zipCode);
    }

    @When("The user should be able to fill form with: {string} and {int}")
    public void the_user_should_be_able_to_fill_form_with_and(String sheetName, Integer rowNumber) {
        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/automationCucumber.xlsx",sheetName);

        List<Map<String, String>> dataList = excelUtil.getDataList();

        checkoutYourInformationPage.fillInfoForm(dataList.get(rowNumber).get("First Name"),
                dataList.get(rowNumber).get("Last Name"),dataList.get(rowNumber).get("Zip Code"));

    }

    @When("The user should be able to fill form with excel data: {string} {string} and {int}")
    public void the_user_should_be_able_to_fill_form_with_excel_data_and(String path, String sheetName, Integer rowNumber) {
        ExcelUtil excelUtil=new ExcelUtil(path,sheetName);

        List<Map<String, String>> dataList = excelUtil.getDataList();

        checkoutYourInformationPage.fillInfoForm(dataList.get(rowNumber).get("First Name"),
                dataList.get(rowNumber).get("Last Name"),dataList.get(rowNumber).get("Zip Code"));
    }

    @When("The user should be able to fill form with path: {string}, {string} and {int}")
    public void the_user_should_be_able_to_fill_form_with_path_and(String path, String sheetName, Integer rowNumber) {

        ExcelUtil excelUtil=new ExcelUtil(path,sheetName);
        List<Map<String, String>> dataList = excelUtil.getDataList();

        checkoutYourInformationPage.fillInfoForm(dataList.get(rowNumber).get("First Name"),
                dataList.get(rowNumber).get("Last Name"),dataList.get(rowNumber).get("Zip Code"));

    }


}
