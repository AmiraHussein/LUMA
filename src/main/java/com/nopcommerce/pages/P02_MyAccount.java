package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_MyAccount
{
    WebDriver driver;

    public P02_MyAccount(WebDriver driver) {
        this.driver = driver;
    }

    public String getContactInformation()
    {

         return driver.findElement(By.xpath("(//div[@class=\"box-content\"])[1]")).getText();
    }
    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }

}
