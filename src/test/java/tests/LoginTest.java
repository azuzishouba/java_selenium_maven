package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void test_valid_login(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.input_email();
        loginPage.input_password();
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        Assert.assertEquals(driver.getTitle(),"Dashboard / nopCommerce administration");
    }
}
