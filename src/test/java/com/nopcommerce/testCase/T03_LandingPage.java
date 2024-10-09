package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P03_LandingPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.nopcommerce.config.BaseConfig.extent;
import static com.nopcommerce.config.BaseConfig.test;

public class T03_LandingPage extends BaseTest
{
    SoftAssert softAssert= new SoftAssert();
    /*
    TC1: Validate That Hot Sellers is displayed and each card contains Price in $
    1.open URL: https://magento.softwaretestingboard.com/
    2.Scroll Down to Hot Sellers Section
    3.Observe each card is displayed with Price
    Expected Results:
    1.Each card should display price in $
    2.Each card should display price as Double not Integer (Advanced Level)
     */
    @Test
    public void testCase_01()
    {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");


        P03_LandingPage landingPage = new P03_LandingPage(driver);

        // 2.Scroll Down to Hot Sellers Section
        landingPage.scrollToBestsellerSection();

        List<WebElement> bestsellerPrices=landingPage.getBestsellerPrices();

        //Expected Results:
        //1.Each card should display price in $
        String expectedCurrency="$";
        for (WebElement bestsellerPrice : bestsellerPrices) {
            String actualPriceText = bestsellerPrice.getText();
            softAssert.assertTrue(actualPriceText.contains(expectedCurrency));

        //2. Each card should display price as Double not Integer (Advanced Level)

            actualPriceText=actualPriceText.replaceAll("[^0-9.]","");

            softAssert.assertTrue(actualPriceText.contains("."));
        }
        softAssert.assertAll();

    }
    public void testCase_02()
    {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");

    }
    public void testCase_03()
    {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");

    }

}
