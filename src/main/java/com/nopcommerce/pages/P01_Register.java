package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1.Open URL: https://magento.softwaretestingboard.com/
2.Click on “Create an Account” button
3.Enter First Name
4.Enter Last Name
5.Enter Email “Valid format”
6.Enter Password
7.Leave Confirm Password empty
8.Click on Create an Account
 */

public class P01_Register
{
    WebDriver driver;

    // Constructor

    public P01_Register(WebDriver driver) {
        this.driver = driver;
    }

    // Elements locators
    By CreateAnAccountButtonL = By.xpath("(//a[@href=\"https://magento.softwaretestingboard.com/customer/account/create/\"])[1]");
    By firstNameLocator =By.id("firstname");
    By lastNameLocator=By.id("lastname");
    By emailLocator=By.id("email_address");
    By passwordLocator=By.id("password");
    By confirmPasswordLocator=By.id("password-confirmation");
    By submitButtonLocator =By.xpath("(//button[@type=\"submit\"])[2]");
    String currentUrl;



    // Actions
    public void OPenRegisterPage()
    {
        driver.findElement(CreateAnAccountButtonL).click();
        currentUrl=driver.getCurrentUrl();

    }
    public String getCurrentUrl()
    {
        return currentUrl;
    }

    public WebElement getFirstName()
    {
        return driver.findElement(firstNameLocator);

    }
    public WebElement getLastName()
    {
        return driver.findElement(lastNameLocator);

    }
    public WebElement getEmail()
    {
        return driver.findElement(emailLocator);

    }
    public WebElement getPassword()
    {
        return driver.findElement(passwordLocator);

    }
    public WebElement getConfirmPassword()
    {
        return driver.findElement(confirmPasswordLocator);

    }
    public String  getCPError()
    {
        return driver.findElement(By.id("password-confirmation-error")).getText();

    }

    public void SubmitRegisterForm()
    {
        driver.findElement(submitButtonLocator).click();
    }




}
