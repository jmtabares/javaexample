package com.example.test;

import com.example.base.TestBase;
import com.example.pages.factory.GoogleLoginPage;
import com.example.pages.factory.GoogleMailPage;
import com.example.pages.factory.GooglePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by jairtabares on 24/10/16.
 */
public class SeleniumPFTest extends TestBase {

    private WebDriver driver;
    @BeforeMethod(alwaysRun=true)
    public void setUp(){
        driver =  getDriver();
    }

    @Test(description = "test selenium",
            groups = {"test3"})
    @Parameters({"username","password"})
    public void gmailTest(String username , String password){
        GooglePage googlePage =  new GooglePage(driver);
        GoogleLoginPage googleLoginPage = googlePage.clickGmail();
        googleLoginPage.goToLogin();
        googleLoginPage.enterUsername(username);
        googleLoginPage.clickContinue();
        googleLoginPage.enterPassword(password);
        GoogleMailPage googleMailPage = googleLoginPage.initSession();

        Assert.assertTrue(googleMailPage.getMailCounter()==5);

    }
    @Test(description = "test selenium",
            groups = {"test3"})
    @Parameters({"username","password"})
    public void gmailTest2(String username , String password){
        GooglePage googlePage =  new GooglePage(driver);
        GoogleLoginPage googleLoginPage = googlePage.clickGmail();
        googleLoginPage.goToLogin();
        googleLoginPage.enterUsername(username);
        googleLoginPage.clickContinue();
        googleLoginPage.enterPassword(password);
        GoogleMailPage googleMailPage = googleLoginPage.initSession();
        Assert.assertTrue(googleMailPage.getMailCounter()==5);

    }

}
