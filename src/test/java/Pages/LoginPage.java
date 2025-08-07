package Pages;

import GenericLibrary.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WebDriverUtils;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;

    public LoginPage() {
        this.driver= DriverFactory.getDriver();
        PageFactory.initElements(driver,this);


    }

    private By username = By.id("appUserName");
    private By password = By.id("appPassword");
    private By Submit = By.xpath("//button[@type='submit']");
    private By profile = By.xpath("//span[@class='welcome-user-pic']/img");
    private By logout = By.xpath("//button[@id='logout']");


public void Enterusername(String usernameinput) {
    WebDriverUtils.sendKeys(username,usernameinput);

    System.out.println(usernameinput);


}
    public void Enterpassword(String userpassword) {
        WebDriverUtils.sendKeys(password,userpassword);

    }

    public void clickSubmit() {
        WebDriverUtils.click(Submit);


    }

    public void clickProfile() {
        WebDriverUtils.hover(profile);
        WebDriverUtils.click(profile);
    }

    public void logout() {
        WebDriverUtils.click(logout);
    }





}
