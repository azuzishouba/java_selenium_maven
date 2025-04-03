package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
    private WebDriver driver;
    @FindBy(id="Email")
    WebElement emailbox;
    @FindBy(id="Password")
    WebElement passwordbox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbutton;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void input_email(String email){
        //WebElement emailbox = driver.findElement(By.id("Email"));
        emailbox.clear();
        emailbox.sendKeys(email);
    }
    public void input_password(String password){
        //WebElement passwordbox=driver.findElement(By.id("Password"));
        passwordbox.clear();
        passwordbox.sendKeys(password);
    }
    public void click_login_button(){
        //WebElement loginbutton=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginbutton.click();
    }
}
