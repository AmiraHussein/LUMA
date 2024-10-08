package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login
{
    WebDriver driver;

    By emailLocator=By.id("email");
    By passwordLocator=By.id("pass");
    By signInButtonLocator=By.id("send2");

    public P02_Login(WebDriver driver)
    {
        this.driver = driver;
    }

    public void enterEmail(String email)
    {
        driver.findElement(emailLocator).sendKeys(email);
    }
    public void enterPassword(String password)
    {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickSignInButton()
    {
        driver.findElement(signInButtonLocator).click();
    }


}
