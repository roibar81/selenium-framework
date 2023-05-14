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

public class sendKeysToAlertPromptDialogBox {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/alerts/");

        //store the alert button element in WebElement object.
        WebElement sendKeysToAlert = driver.findElement(By.id("prompt"));

        //clicking on the alert button.
        sendKeysToAlert.click();

        //define webDriverWait for waiting max 10 second alert to popup.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //we store the alert element in Alert object and use WebDriverWait object for waiting to alert to popup
        //if not present after 10 second (max), exception will show up.
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //send some message to the alert prompt dialog box allows
        alert.sendKeys("World");
        alert.accept();

        //simple assertion.
        String actual = driver.findElement(By.id("Parademo")).getText();
        if (actual.contains("World")) {
            System.out.println("Test case pass");
        } else {
            System.out.println("Test case fail");
        }
        System.out.println("Alert Input Message is: " + actual);

        driver.quit();
    }
}
