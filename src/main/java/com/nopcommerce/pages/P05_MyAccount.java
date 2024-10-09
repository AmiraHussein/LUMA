package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_MyAccount
{
    WebDriver driver;

    public P05_MyAccount(WebDriver driver) {
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
