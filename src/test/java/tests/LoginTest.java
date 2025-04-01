package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentReportManager;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void test_valid_login(){
        test= ExtentReportManager.createTest("Login test");
        LoginPage loginPage=new LoginPage(driver);
        test.info("navigate to website");
        loginPage.input_email();
        loginPage.input_password();
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        test.info("verify index title");
        Assert.assertEquals(driver.getTitle(),"Dashboard / nopCommerce administration");
        test.info("test pass!");
    }
}
