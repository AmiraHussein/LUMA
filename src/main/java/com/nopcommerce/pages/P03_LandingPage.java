package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_LandingPage
{
    WebDriver driver;

    By signInButtonLocator=By.xpath(" (//li[@class=\"authorization-link\"])[1]");
    By loggedUserWelcomeMessageLocator =
            //By.xpath("(//span[@class=\"logged-in\"])[1]");
            By.xpath("(//li[@class=\"greet welcome\"])[1]");


    public P03_LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void ClickSignIn()
    {
        driver.findElement(signInButtonLocator).click();
    }
    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }
    public String getLoggedUserWelcomeMessage()
    {

        WebElement welcomeMessage= driver.findElement(loggedUserWelcomeMessageLocator);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElements(
                welcomeMessage));
        return welcomeMessage.getText();
    }
}
