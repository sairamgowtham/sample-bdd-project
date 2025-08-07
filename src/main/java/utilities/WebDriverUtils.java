package utilities;

import GenericLibrary.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class WebDriverUtils {
    private static final int TIMEOUT = 60;


    // ---------- Find Element with Fluent Wait ----------
    public static WebElement findElement(By locator) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver())
                    .withTimeout(Duration.ofSeconds(TIMEOUT))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class);
            return wait.until(driver -> driver.findElement(locator));
        } catch (Exception e) {
            System.err.println("Element not found: " + locator + " - " + e.getMessage());
            return null;
        }
    }

    // ---------- Basic Actions ----------
    public static void click(By locator) {
        try {
            WebElement el = findElement(locator);
            if (el != null) el.click();
        } catch (Exception e) {
            System.err.println("Click failed for: " + locator + " - " + e.getMessage());
        }
    }

    public static void sendKeys(By locator, String text) {
        try {
            WebElement el = findElement(locator);
            if (el != null) {
                el.clear();
                el.sendKeys(text);
            }
        } catch (Exception e) {
            System.err.println("SendKeys failed for: " + locator + " - " + e.getMessage());
        }
    }

    public static String getText(By locator) {
        try {
            WebElement el = findElement(locator);
            return (el != null) ? el.getText() : "";
        } catch (Exception e) {
            System.err.println("GetText failed for: " + locator + " - " + e.getMessage());
            return "";
        }
    }

    // ---------- Dropdown ----------
    public static void selectByVisibleText(By locator, String text) {
        try {
            Select select = new Select(findElement(locator));
            select.selectByVisibleText(text);
        } catch (Exception e) {
            System.err.println("SelectByVisibleText failed: " + e.getMessage());
        }
    }

    public static void selectByValue(By locator, String value) {
        try {
            Select select = new Select(findElement(locator));
            select.selectByValue(value);
        } catch (Exception e) {
            System.err.println("SelectByValue failed: " + e.getMessage());
        }
    }

    public static void selectByIndex(By locator, int index) {
        try {
            Select select = new Select(findElement(locator));
            select.selectByIndex(index);
        } catch (Exception e) {
            System.err.println("SelectByIndex failed: " + e.getMessage());
        }
    }

    // ---------- Mouse Actions ----------
    public static void hover(By locator) {
        try {
            Actions actions = new Actions(DriverFactory.getDriver());
            actions.moveToElement(findElement(locator)).perform();
        } catch (Exception e) {
            System.err.println("Hover failed: " + e.getMessage());
        }
    }

    public static void doubleClick(By locator) {
        try {
            Actions actions = new Actions(DriverFactory.getDriver());
            actions.doubleClick(findElement(locator)).perform();
        } catch (Exception e) {
            System.err.println("DoubleClick failed: " + e.getMessage());
        }
    }

    public static void rightClick(By locator) {
        try {
            Actions actions = new Actions(DriverFactory.getDriver());
            actions.contextClick(findElement(locator)).perform();
        } catch (Exception e) {
            System.err.println("RightClick failed: " + e.getMessage());
        }
    }

    public static void dragAndDrop(By source, By target) {
        try {
            Actions actions = new Actions(DriverFactory.getDriver());
            actions.dragAndDrop(findElement(source), findElement(target)).perform();
        } catch (Exception e) {
            System.err.println("DragAndDrop failed: " + e.getMessage());
        }
    }

    // ---------- JavaScript Utilities ----------
    public static void jsClick(By locator) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
            js.executeScript("arguments[0].click();", findElement(locator));
        } catch (Exception e) {
            System.err.println("JS Click failed: " + e.getMessage());
        }
    }

    public static void scrollToElement(By locator) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", findElement(locator));
        } catch (Exception e) {
            System.err.println("Scroll to element failed: " + e.getMessage());
        }
    }

    // ---------- Alerts ----------
    public static void acceptAlert() {
        try {
            DriverFactory.getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            System.err.println("Accept Alert failed: " + e.getMessage());
        }
    }

    public static void dismissAlert() {
        try {
            DriverFactory.getDriver().switchTo().alert().dismiss();
        } catch (Exception e) {
            System.err.println("Dismiss Alert failed: " + e.getMessage());
        }
    }

    public static String getAlertText() {
        try {
            return DriverFactory.getDriver().switchTo().alert().getText();
        } catch (Exception e) {
            System.err.println("Get Alert Text failed: " + e.getMessage());
            return "";
        }
    }

    public static void sendAlertText(String text) {
        try {
            DriverFactory.getDriver().switchTo().alert().sendKeys(text);
        } catch (Exception e) {
            System.err.println("Send Alert Text failed: " + e.getMessage());
        }
    }

    // ---------- Windows ----------
    public static void switchToWindow(String titleContains) {
        try {
            Set<String> handles = DriverFactory.getDriver().getWindowHandles();
            for (String handle : handles) {
                DriverFactory.getDriver().switchTo().window(handle);
                if (DriverFactory.getDriver().getTitle().contains(titleContains)) break;
            }
        } catch (Exception e) {
            System.err.println("SwitchToWindow failed: " + e.getMessage());
        }
    }

    // ---------- Frames ----------
    public static void switchToFrame(By locator) {
        try {
            DriverFactory.getDriver().switchTo().frame(findElement(locator));
        } catch (Exception e) {
            System.err.println("Switch to frame failed: " + e.getMessage());
        }
    }

    public static void switchToDefaultContent() {
        try {
            DriverFactory.getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            System.err.println("Switch to default content failed: " + e.getMessage());
        }
    }

    // ---------- Date Picker ----------
    public static void selectDate(By datePickerTrigger, By dateCells, String targetDate) {
        try {
            click(datePickerTrigger);
            List<WebElement> dates = DriverFactory.getDriver().findElements(dateCells);
            for (WebElement date : dates) {
                if (date.getText().equals(targetDate)) {
                    date.click();
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Select date failed: " + e.getMessage());
        }
    }

    // ---------- Web Table ----------
    public static int getTableRowCount(By tableLocator) {
        try {
            return DriverFactory.getDriver().findElements(By.xpath(tableLocator + "//tr")).size();
        } catch (Exception e) {
            System.err.println("Get table row count failed: " + e.getMessage());
            return 0;
        }
    }

    public static int getTableColumnCount(By tableLocator) {
        try {
            return DriverFactory.getDriver().findElements(By.xpath(tableLocator + "//tr[1]/td | //tr[1]/th")).size();
        } catch (Exception e) {
            System.err.println("Get table column count failed: " + e.getMessage());
            return 0;
        }
    }

    public static String getCellValue(By tableLocator, int row, int col) {
        try {
            String xpath = tableLocator + "//tr[" + row + "]/td[" + col + "]";
            return DriverFactory.getDriver().findElement(By.xpath(xpath)).getText();
        } catch (Exception e) {
            System.err.println("Get cell value failed: " + e.getMessage());
            return "";
        }
    }

    public static void printTableData(By tableLocator) {
        try {
            List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath(tableLocator + "//tr"));
            for (int i = 1; i <= rows.size(); i++) {
                List<WebElement> cells = DriverFactory.getDriver().findElements(By.xpath(tableLocator + "//tr[" + i + "]/td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + " | ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Print table data failed: " + e.getMessage());
        }
    }

    // ---------- Waits ----------
    public static void waitForElementVisible(By locator) {
        try {
            new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.err.println("Wait for visibility failed: " + e.getMessage());
        }
    }

    public static void waitForElementClickable(By locator) {
        try {
            new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            System.err.println("Wait for clickable failed: " + e.getMessage());
        }
    }

    public static void waitForTextPresent(By locator, String text) {
        try {
            new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                    .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        } catch (Exception e) {
            System.err.println("Wait for text failed: " + e.getMessage());
        }
    }

    public static void withoutSelectClass(String value)
    {

        List<WebElement> allopt = DriverFactory.getDriver().findElements(By.xpath("//li[@role ='option']"));
        boolean flag = true;
        for (WebElement opt : allopt)
        {
            if(value.equalsIgnoreCase(opt.getText()))
            {
                opt.click();
                flag = false;
                break;


            }



        }
       // System.out.println("flag value is "+flag);

//        if(!flag ) {
//            System.out.println("Customer selected");
//        }
//        else {
//            System.out.println("no element exists");
//        }
    }

    public static void scrolldown() {
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

    public static boolean displayed(By locator) {
        boolean flag = WebDriverUtils.findElement(locator).isDisplayed();
        return flag;

    }
    public static boolean Enabled(By locator) {
        boolean flag = WebDriverUtils.findElement(locator).isEnabled();
        return flag;

    }



}
