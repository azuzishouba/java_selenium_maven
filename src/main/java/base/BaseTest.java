/**
 * 文件描述：所有测试文件的基类，方法适用于所有测试类
 */
package base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.EmailUtils;
import utils.ExtentReportManager;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;
    @BeforeSuite
    public void setupReport(){
        extent= ExtentReportManager.getReportInstance();
    }
    @AfterSuite
    public void teardownReport(){
        extent.flush();
        String reportPath = ExtentReportManager.reportPath;
        EmailUtils.sendTestReport(reportPath);
    }
    @BeforeMethod
    public void setUp(){
        driver=new FirefoxDriver();
        driver.get("http://admin-demo.nopcommerce.com/login");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }
}
