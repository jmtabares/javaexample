package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jairtabares on 24/10/16.
 */
public class GoogleMailPage {
    WebDriver driver;
    public GoogleMailPage(WebDriver driver) {
        this.driver = driver;
    }
    public Integer getMailCounter(){
        String match="-1";
        Pattern p = Pattern.compile("-?\\d+");
        WebElement inbox = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(".//*[@class='aio UKr6le']/span[@class='nU n1']/a")));
        inbox.getText();
        Matcher m = p.matcher(inbox.getText());
        while(m.find()){
            match = m.group();
        }
        return Integer.valueOf(match);
    }
}
