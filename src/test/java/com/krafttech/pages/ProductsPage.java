package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{

   public static int addedItemNumber=0;
    public static double totalPrice=0.0;

    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productPageTitle;


    @FindBy(css = "select")
    public WebElement sortByDropDown;

    public void sortItems(String orderType){
        Select select=new Select(sortByDropDown);
        select.selectByVisibleText(orderType);
        select.getFirstSelectedOption().click();
    }

    public void addItem(String itemName){
        Driver.get().findElement(By.xpath("//div[text()='"+itemName+"']/ancestor::" +
                "div[@class='inventory_item_description']//button")).click();
        addedItemNumber++;
        String itemPriceText = Driver.get().findElement(By.xpath("//div[text()='" + itemName + "']/ancestor::" +
                "div[@class='inventory_item_description']//div[@class='inventory_item_price']")).getText();
        totalPrice+=Double.parseDouble(itemPriceText.substring(1));
    }
}
