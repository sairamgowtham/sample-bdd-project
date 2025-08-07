package hooks;

import GenericLibrary.BaseClass;
import GenericLibrary.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class BaseSetUp extends BaseClass {
    @BeforeAll
    public static void launchBrowser() {
        BaseClass baseClass = new BaseClass();
        baseClass.initializeDriver();// Browser opens once
        LoginPage page = new LoginPage();
        page.Enterusername("admin");
        page.Enterpassword("Cms#12345678");
        page.clickSubmit();
        System.out.println("✅ Browser opened and logged in once before all scenarios.");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
                scenario.attach(screenshot, "image/png", "Screenshot on Failure");
                System.out.println("❌ Scenario failed: " + scenario.getName());
            } catch (Exception e) {
                System.err.println("Screenshot capture failed: " + e.getMessage());
            }
        }
    }

    @AfterAll
    public static void quitBrowser() {
        BaseClass.quitDriver(); // Browser closes after all scenarios
        System.out.println("✅ Browser closed after all scenarios.");
    }
}
