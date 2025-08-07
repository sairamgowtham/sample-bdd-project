package GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {
    public  void initializeDriver() {

    String browser = ConfigReader.get("browser");
    String env = ConfigReader.get("environment");
    boolean isHeadless = ConfigReader.get("headless").equalsIgnoreCase("true");

    WebDriver driver = null;

        if ("chrome".equalsIgnoreCase(browser)) {
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    // Add other browsers as needed

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        if(env.equalsIgnoreCase("qa")) {
            driver.get("https://apollocms.v35.dev.zeroco.de/");

        }
        DriverFactory.setDriver(driver);
}

public static void quitDriver() {
    if (DriverFactory.getDriver() != null) {
        DriverFactory.getDriver().quit();
        DriverFactory.removeDriver();
    }
}
}
