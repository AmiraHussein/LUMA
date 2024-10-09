package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P01_Register;
import com.nopcommerce.pages.P05_MyAccount;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
1.Open URL: https://magento.softwaretestingboard.com/
2.Click on “Create an Account” button
3.Enter First Name "Amira"
4.Enter Last Name
5.Enter Email “Valid format”
6.Enter Password
7.Leave Confirm Password empty
8.Click on Create an Account
 */




public class T01_Register extends BaseTest {

    SoftAssert softAssert= new SoftAssert();

    @Test
    public void testCase_01()  {
        // test data
        String firstName="Amira";
        String lastName= "Hussein";
        String email= "amira@test.con";
        String password="Aa@12345H";

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        // create object from register page
        P01_Register registerPage=new P01_Register(driver);


//        2.Click on “Create an Account” button
        registerPage.OPenRegisterPage();

//        3.Enter First Name
        registerPage.getFirstName().sendKeys(firstName);
//        4.Enter Last Name
        registerPage.getLastName().sendKeys(lastName);
//        5.Enter Email “Valid format”
        registerPage.getEmail().sendKeys(email);
//        6.Enter Password
        registerPage.getPassword().sendKeys(password);
//        7.Leave Confirm Password empty
        registerPage.getConfirmPassword().click();
        //8.Click on Create an Account
        registerPage.SubmitRegisterForm();


        //Expected Results:
        //1.User navigated to page “https://magento.softwaretestingboard.com/customer/account/create/” after click on Create an Account from Homepage
        Assert.assertEquals(registerPage.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/create/");
        //2.“This is a required field.” This message will be displayed under mandatory fields
        String expectedMessage="This is a required field.";
        String actualMessage=registerPage.getCPError();

        Assert.assertEquals(expectedMessage,actualMessage);
        //softAssert.assertAll();



    }

    @Test
    /*
     TC2: Validate an error message is displayed when user enter password and confirm password does not match each other
        1.    Open URL: https://magento.softwaretestingboard.com/
        2.    Click on “Create an Account” button
        3.    Enter First Name
        4.    Enter Last Name
        5.    Enter Email “Valid format”
        6.    Enter Password
        7.Enter Confirm Password does not match Password
        8.Click on Create an Account
        Expected Results:
        1.User navigated to page “https://magento.softwaretestingboard.com/customer/account/create/” after click on Create an Account from Homepage
        2.“Please enter the same value again.” This message will be displayed under confirm password field
    */
    public void testCase_02()
    {
        // test data
        String firstName="Amira";
        String lastName= "Hussein";
        String email= "amira@test.con";
        String password="Aa@12345H";
        String confirmPassword="Aa@12345";
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        // create object from register page
        P01_Register registerPage=new P01_Register(driver);


        // 2.Click on “Create an Account” button
        registerPage.OPenRegisterPage();
        //Expected Results:
        //1.User navigated to page “https://magento.softwaretestingboard.com/customer/account/create/” after click on Create an Account from Homepage
        softAssert.assertEquals(registerPage.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/create/");

        // 3.Enter First Name
        registerPage.getFirstName().sendKeys(firstName);
        // 4.Enter Last Name
        registerPage.getLastName().sendKeys(lastName);
        // 5.Enter Email “Valid format”
        registerPage.getEmail().sendKeys(email);
        // 6.Enter Password
        registerPage.getPassword().sendKeys(password);
        //7.Enter Confirm Password does not match Password
        registerPage.getConfirmPassword().sendKeys(confirmPassword);
        //8.Click on Create an Account
        registerPage.SubmitRegisterForm();
        //Expected Results:
        //2.“Please enter the same value again.” This message will be displayed under confirm password field
        String expectedMessage="Please enter the same value again.";
        String actualMessage=registerPage.getCPError();

        softAssert.assertEquals(expectedMessage,actualMessage);
        softAssert.assertAll();

    }
   // @Test(groups = {"register"})



    // Validate that user after register with valid data, will be navigated to My Account page
    @Test
    public void register_TC03()
    {

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        // create object from register page
        P01_Register registerPage=new P01_Register(driver);
        // test data
        String firstName="Amira";
        String lastName= "Hussein";
        String email= "amira@test2.con";
        String password="Aa@12345H";
        String confirmPassword="Aa@12345H";



//        2.Click on “Create an Account” button
        registerPage.OPenRegisterPage();
        //Expected Results:
        //1.User navigated to page “https://magento.softwaretestingboard.com/customer/account/create/” after click on Create an Account from Homepage
        softAssert.assertEquals(registerPage.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/create/");

//        3.Enter First Name
        registerPage.getFirstName().sendKeys(firstName);
//        4.Enter Last Name
        registerPage.getLastName().sendKeys(lastName);
//        5.Enter Email “Valid format”
        registerPage.getEmail().sendKeys(email);
//        6.Enter Password
        registerPage.getPassword().sendKeys(password);
        //7.Enter Confirm Password does not match Password
        registerPage.getConfirmPassword().sendKeys(confirmPassword);
        //8.Click on Create an Account
        registerPage.SubmitRegisterForm();

        //Expected Results:
        P05_MyAccount myAccount=new P05_MyAccount(driver);
        //1. User navigated to page “https://magento.softwaretestingboard.com/customer/account/” after click on Create an Account
        softAssert.assertEquals(myAccount.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/");
        /*
            2.In Contact Information
                a.First name
                b.Last name
                c.Email
                It should be the same as user input during registration

         */

        String actualContactInformation=myAccount.getContactInformation();
        softAssert.assertTrue(actualContactInformation.contains(firstName));
        softAssert.assertTrue(actualContactInformation.contains(lastName));
        softAssert.assertTrue(actualContactInformation.contains(email));

        softAssert.assertAll();

    }


}
