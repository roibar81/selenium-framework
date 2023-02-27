package locators.alerts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertSample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/roibar/Desktop/projects/chromedriver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/alerts/");


        //store the alert button element in WebElement object.
        WebElement simpleAlertButton = driver.findElement(By.name("commit"));

        //clicking on the alert button.
        simpleAlertButton.click();

        //define webDriverWait for waiting max 10 second alert to popup.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //we store the in Alert object and use Wait object for waiting to alert to popup
        //if not present after 10 second, exception will show up.
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //simple assert.
        String actual = alert.getText();
        if (actual.contains("nice")) {
            System.out.println("Test case pass");
        } else {
            System.out.println("Test case fail");
        }
        System.out.println("Alert Message is: " + actual);

        //push ok button in the alert frame
        alert.accept();

        driver.quit();
    }
}
