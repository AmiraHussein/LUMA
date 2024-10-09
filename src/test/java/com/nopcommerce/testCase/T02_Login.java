package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P02_Login;
import com.nopcommerce.pages.P03_LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.testCase.T01_Register;
import org.testng.asserts.SoftAssert;


public class T02_Login extends BaseTest
{


    T01_Register register=new T01_Register();
     /*
    TC1: Validate That user can login with registered email and password
    Depend on TC3 from Scenario 1
    1.open URL: https://magento.softwaretestingboard.com/
    2.Click on “Sign In” button
    3.Enter Email
    4.Enter Password
    5.Click on “Sign In” button

    Expected Results:
    1.User navigated to page “https://magento.softwaretestingboard.com/” after click on Sign In with Valid Email and Password
    2.Welcome, should contain First Name + Last Name

     */


    SoftAssert softAssert=new SoftAssert();
    //@Test (dependsOnGroups = {"register"})
    @Test
    public void testCase_01() throws InterruptedException {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");

        // test data
        String firstName="Amira";
        String lastName= "Hussein";
        String email= "amira@test2.con";
        String password="Aa@12345H";

        P03_LandingPage landingPage=new P03_LandingPage(driver);
        P02_Login login = new P02_Login(driver);


        // 2.Click on “Sign In” button
        landingPage.ClickSignIn();
        // 3.Enter Email
        login.enterEmail(email);
        // 4.Enter Password
        login.enterPassword(password);
        // 5.Click on “Sign In” button
        login.clickSignInButton();


        // Expected Results:
        //    1.User navigated to page “https://magento.softwaretestingboard.com/” after click on Sign In with Valid Email and Password
        String expectedUrl="https://magento.softwaretestingboard.com/";
        String actualUrl=landingPage.getCurrentUrl();
        softAssert.assertEquals(expectedUrl,actualUrl);
        //    2.Welcome, should contain First Name + Last Name
        String welcomeMessage=landingPage.getLoggedUserWelcomeMessage();
        String userFullName=firstName +" "+ lastName;
        softAssert.assertTrue(welcomeMessage.contains(userFullName),"expected: welcome "+ userFullName + " but founded" + welcomeMessage);
        softAssert.assertAll();






    }

}
