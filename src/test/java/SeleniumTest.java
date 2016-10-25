import com.example.base.TestBase;
import com.example.pages.GoogleLoginPage;
import com.example.pages.GoogleMailPage;
import com.example.pages.GooglePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by jairtabares on 24/10/16.
 */
public class SeleniumTest extends TestBase {

    private WebDriver driver;
    @BeforeMethod(alwaysRun=true)
    public void setUp(){
        driver =  getDriver();
    }

    @Test(description = "test selenium",
            groups = {"test2"})
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


}
