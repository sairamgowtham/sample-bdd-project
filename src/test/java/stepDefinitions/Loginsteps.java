package stepDefinitions;

import GenericLibrary.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginsteps {
    LoginPage page = new LoginPage();

    @Given("user is on loginpage")
    public void user_is_on_loginpage() {
        // Write code here that turns the phrase above into concrete actions
        page.Enterusername("admin");
        page.Enterpassword("Cms#1234567");




    }

    @When("user the enter username")
    public void user_the_enter_username() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("enter username");

    }

    @When("user enter password")
    public void user_enter_password() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("enter password");
        page.Enterpassword("Cms#12345678");


    }

    @When("user clicks on submit")
    public void user_clicks_on_submit() {
        // Write code here that turns the phrase above into concrete actions
        page.clickSubmit();
    }

    @Then("user redirects to homepage")
    public void user_redirects_to_homepage() {
        // Write code here that turns the phrase above into concrete actions

        String expectedurl = "https://apollocms.v35.dev.zeroco.de/apollo/account/app-selection";
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String actualUrl = DriverFactory.getDriver().getCurrentUrl();
        System.out.println(actualUrl);

// Update based on your app's landing page
        Assert.assertEquals("User is  redirected to the homepage", expectedurl, actualUrl);
        page.clickProfile();
        page.logout();
        // Optionally, you can also check for a specific element on the homepage
        // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
        // Assert.assertTrue("Element is not visible on the homepage", element.isDisplayed());
    }

}
