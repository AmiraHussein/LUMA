package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P03_LandingPage
{
    WebDriver driver;

    By signInButtonLocator=By.xpath(" (//li[@class=\"authorization-link\"])[1]");
    By loggedUserWelcomeMessageLocator =
            //By.xpath("(//span[@class=\"logged-in\"])[1]");
            By.xpath("(//li[@class=\"greet welcome\"])[1]");
    By bestSellerLocator=By.cssSelector("h2[class=\"title\"]");


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
        wait.until(ExpectedConditions.textToBePresentInElement(
                welcomeMessage,"Welcome"));
        return welcomeMessage.getText();
    }

    private void scrollToElement(By elementLocator)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement element = driver.findElement(elementLocator);

        //Scroll down the page till the element
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public void scrollToBestsellerSection()
    {
        scrollToElement(bestSellerLocator);
    }

    public List<WebElement> getBestsellerPrices()
    {

        return driver.findElements(By.className("price"));
    }






}
