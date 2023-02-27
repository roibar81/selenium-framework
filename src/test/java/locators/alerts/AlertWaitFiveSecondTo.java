package locators.alerts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertWaitFiveSecondTo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/roibar/Desktop/projects/chromedriver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/alerts/");

        //store the delay alert button element in WebElement object.
        WebElement delayAlertButton = driver.findElement(By.id("delayalert"));

        //clicking on the alert button.
        delayAlertButton.click();

        //define webDriverWait object to waiting max 10 second for delay alert to popup.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //we store the alert in Alert object and use Wait object for waiting to alert to popup
        //max 10 second, if not present exception will show up.
        Alert delayalert = wait.until(ExpectedConditions.alertIsPresent());

        //simple assert.
        String actual = delayalert.getText();
        if (actual.contains("5")) {
            System.out.println("Test case pass");
        } else {
            System.out.println("Test case fail");
        }
        System.out.println("Alert Message is: " + actual);

        //push ok button in the alert frame to close the window
        delayalert.accept();

        driver.quit();
    }

}
