package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void input_email(){
        WebElement emailbox = driver.findElement(By.id("Email"));
        emailbox.clear();
        emailbox.sendKeys("admin@yourstore.com");
    }
    public void input_password(){
        WebElement passwordbox=driver.findElement(By.id("Password"));
        passwordbox.clear();
        passwordbox.sendKeys("admin");
    }
    public void click_login_button(){
        WebElement loginbutton=driver.findElement(By.xpath(""));
        loginbutton.click();
    }
}
