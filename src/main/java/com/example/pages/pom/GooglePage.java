package com.example.pages.pom;

import com.example.vars.GoolglePageVars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jairtabares on 24/10/16.
 */
public class GooglePage {
    WebDriver driver;
    public GooglePage(WebDriver driver){
        this.driver =  driver;
    }
    public GoogleLoginPage clickGmail(){
        WebElement link = driver.findElement(By.xpath(GoolglePageVars.GMAIL_LINK));
        if (link.isDisplayed()||link.isEnabled())
            link.click();
        return new GoogleLoginPage(driver);
    }
}
