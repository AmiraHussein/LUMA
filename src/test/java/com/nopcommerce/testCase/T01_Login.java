package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T01_Login extends BaseTest
{




    @Test
    public void testCase_01()
    {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");

        Assert.assertTrue(false);

    }

}
