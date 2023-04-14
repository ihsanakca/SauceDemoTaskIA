package com.krafttech.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

public class CheckoutOverviewPage extends BasePage{

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement totalPrice;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> listOfTotalItems;

    public void verifyTotalPrice(){
        String totalPriceText = totalPrice.getText().substring(13);
        //double actualTotalPrice = Double.parseDouble(totalPriceText.substring(13));

        double expectedTotalPrice=ProductsPage.totalPrice;
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        String expectedTotal= df.format(expectedTotalPrice);

        System.out.println("totalPriceText = " + totalPriceText);
        System.out.println("expectedTotalPrice = " + expectedTotal);

        Assert.assertEquals(expectedTotal, totalPriceText);

    }

    public void verifyNumberOfItems(){
        int actualNumber=listOfTotalItems.size();
        int expectedNumber=ProductsPage.addedItemNumber;
        Assert.assertEquals(expectedNumber,actualNumber);
    }
}

