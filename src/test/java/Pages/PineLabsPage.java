package Pages;

import GenericLibrary.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverUtils;

public class PineLabsPage {
    public WebDriver driver;

    public PineLabsPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    private By appselection = By.xpath("//div[contains(@class, 'appManagment')]//strong[text()='CMS']");
    private By pineLabsHover = By.xpath("//a[@id=\"menu-pine-lab-issues\"]");
    private By pineLabs = By.xpath("//a[contains(@class, 'nav-link') ]//span[text()='Pine Lab Issues']");
    private By createIssue = By.xpath("//button[contains(@class,'btn btn-primary ng-star-inserted')]//span[text()='Create New Issue']");
    private By storeName = By.xpath("//p-autocomplete[contains(@forceselection,'true')]//input[@role='combobox']");
    private By storeoptions = By.xpath("//li[@role='option']");
    private By category = By.xpath("//p-dropdown[@placeholder='Select category']");
    private By tid = By.xpath("//p-dropdown[@placeholder='Select device TID']");
    private By description = By.xpath("//textarea[@placeholder='Enter issue description']");
    private By submit = By.xpath("//button[@title='Create Issue']");
    private By pageTitle = By.xpath("//div[@class=\"zc-widget-header-title ng-star-inserted\"]//h2[text()=\"Tickets Status\"]");
    private By pinelabsTitle = By.xpath("//div[@class=\"col table-header ng-star-inserted\"]//h2[text()=\"Pine Lab Issues\"]");
    private By modelpagetitle = By.xpath("//h3[normalize-space(.) = \"Create Pine Lab Complaints Registration\"]");

    public String setAppselection() {
        WebDriverUtils.click(appselection);
        String title = driver.findElement(pageTitle).getText();
        return title;
    }

    public void clickPineLabs() {
       // WebDriverUtils.scrolldown();
        WebDriverUtils.hover(pineLabsHover);
        WebDriverUtils.findElement(pineLabs).click();

    }

    public String checkTitle() {
        String title = WebDriverUtils.findElement(pinelabsTitle).getText();
        return title;
    }

    public boolean checkCreateIssue() {

      boolean flag =  WebDriverUtils.displayed(createIssue);
      return flag;
    }

    public boolean clickable() {
        boolean flag =  WebDriverUtils.Enabled(createIssue);
        return flag;
    }

    public String checkclick() {
        WebDriverUtils.click(createIssue);
        String title = WebDriverUtils.findElement(modelpagetitle).getText();

        return title;


    }


    public void EnterDetails() {
        WebDriverUtils.sendKeys(storeName, "10003");
        WebDriverUtils.withoutSelectClass("10003");
        WebDriverUtils.click(storeoptions);
        WebDriverUtils.click(category);
        WebDriverUtils.withoutSelectClass("mixed category");
        WebDriverUtils.click(storeoptions);
        WebDriverUtils.click(tid);
        WebDriverUtils.withoutSelectClass("tid111111");
        WebDriverUtils.sendKeys(description, "ok");
       // WebDriverUtils.click(submit);
    }



    public void clickSubmit() {
        WebDriverUtils.click(submit);

    }
}
