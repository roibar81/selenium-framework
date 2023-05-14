package locators.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertSample {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/alerts/");

        //store the alert button element in WebElement object.
        WebElement simpleAlertButton = driver.findElement(By.name("commit"));

        //clicking on the alert button.
        simpleAlertButton.click();

        //define webDriverWait for waiting max 10 second alert to popup.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //we store the alert in Alert object and use Wait object for waiting to alert to popup
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
