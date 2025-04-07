package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest {
    /**
     * 获取表格中的数据
     * @return 返回文件中用户名 密码
     * @throws IOException
     */
    @DataProvider(name="LoginData")//@dataprovider注解表示数据提供的对象 name表示名称
    public Object[][] getLoginData() throws IOException {

        String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];

        for(int i=1; i<rowCount; i++) {

            data[i-1][0] = ExcelUtils.getCellData(i, 0);	// Username
            data[i-1][1] = ExcelUtils.getCellData(i, 1);	// Password
        }
        ExcelUtils.closeExcel();
        return data;
    }
    @DataProvider(name="LoginData2")
    public Object[][] getData(){

        return new Object[][] {
                {"user1","pass1"},
                {"user2","pass2"},
                {"user3","pass3"}
        };
    }
    @Test(dataProvider = "LoginData2")//dataprovider里面填写名称表示数据来源
    public void test_valid_login(String username,String password){

        test= ExtentReportManager.createTest("Login test");
        LoginPage loginPage=new LoginPage(driver);
        test.info("navigate to website");
        loginPage.input_email(username);
        loginPage.input_password(password);
        loginPage.click_login_button();
        test.info("verify index title");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("Dashboard / nopCommerce administration"));
        Assert.assertEquals(driver.getTitle(),"Dashboard / nopCommerce administration","");
        test.info("test pass!");
    }
}
