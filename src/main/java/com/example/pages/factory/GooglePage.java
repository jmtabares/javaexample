package com.example.pages.factory;

import com.example.vars.GoolglePageVars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by jairtabares on 24/10/16.
 */
public class GooglePage {
    WebDriver driver;
    @FindBy(xpath = GoolglePageVars.GMAIL_LINK)
    WebElement link;

    public GooglePage(WebDriver driver){

        this.driver =  driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleLoginPage clickGmail(){
        if (link.isDisplayed()||link.isEnabled())
            link.click();
        return new GoogleLoginPage(driver);
    }
}
