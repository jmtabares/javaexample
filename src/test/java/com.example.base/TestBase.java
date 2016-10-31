package com.example.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Created by jairtabares on 24/10/16.
 */
public class TestBase {
    private WebDriver driver;

    @Parameters({"browserType","appURL"})
    @BeforeClass(alwaysRun = true)
    public void setDriver(int browserType, String appURL) {
        System.out.println("Before class.");
        switch (browserType) {
            case 1:
                driver = initChromeDriver(appURL);
                break;
            case 2:
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("browser : " + browserType
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver(appURL);
        }
    }
    public WebDriver getDriver(){
        return driver;
    }
    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        System.setProperty("webdriver.firefox.marionette", "geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }
    public void initializeTestBaseSetup(int browserType, String appURL) {
        try {
            setDriver(browserType, appURL);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
