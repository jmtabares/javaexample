package com.example.pages.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jairtabares on 24/10/16.
 */
public class GoogleLoginPage {
    WebDriver driver;
    @FindBy(xpath=".//*[@id='Email']")
    WebElement userNameField;
    @FindBy(xpath=".//*[@id='Passwd']")
    WebElement passwordNameField;
    @FindBy(xpath=".//*[@id='next']")
    WebElement continueButton;
    @FindBy(xpath=".//*[@id='signIn']")
    WebElement sigInButton;
    @FindBy(id="gmail-sign-in")
    WebElement initSession;

    public GoogleLoginPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15),this);
    }
    public void enterUsername(String userName){

        if (userNameField.isDisplayed()){
            userNameField.sendKeys(userName);
        }
    }
    public void enterPassword(String password){
        if (passwordNameField.isDisplayed()){
            passwordNameField.sendKeys(password);
        }
    }

    public void clickContinue(){

        if (continueButton.isDisplayed()||continueButton.isEnabled())
            continueButton.click();
    }
    public GoogleMailPage initSession(){

        if (sigInButton.isDisplayed()||sigInButton.isEnabled())
            sigInButton.click();
        return new GoogleMailPage(driver);
    }

    public void goToLogin() {
        try{

            if (initSession.isDisplayed()||initSession.isEnabled())
                initSession.click();
        }catch(Exception e){

        }
    }
}
