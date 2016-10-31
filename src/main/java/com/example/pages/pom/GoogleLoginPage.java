package com.example.pages.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jairtabares on 24/10/16.
 */
public class GoogleLoginPage {
    WebDriver driver;
    public GoogleLoginPage(WebDriver webDriver){

        this.driver = webDriver;
    }
    public void enterUsername(String userName){
        WebElement userNameField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Email']")));
        if (userNameField.isDisplayed()){
            userNameField.sendKeys(userName);
        }
    }
    public void enterPassword(String password){
        WebElement passwordNameField = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Passwd']")));

        if (passwordNameField.isDisplayed()){
            passwordNameField.sendKeys(password);
        }
    }

    public void clickContinue(){
        WebElement continueButton  = driver.findElement(By.xpath(".//*[@id='next']"));
        if (continueButton.isDisplayed()||continueButton.isEnabled())
            continueButton.click();
    }
    public GoogleMailPage initSession(){
        WebElement continueButton  = driver.findElement(By.xpath(".//*[@id='signIn']"));
        if (continueButton.isDisplayed()||continueButton.isEnabled())
            continueButton.click();
        return new GoogleMailPage(driver);
    }

    public void goToLogin() {
        try{
            WebElement initSession = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("gmail-sign-in")));
            if (initSession.isDisplayed()||initSession.isEnabled())
                initSession.click();
        }catch(Exception e){

        }
    }
}
