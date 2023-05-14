package waits;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class ExplicitlyWait {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/delay/");

        //store Click me! button in webElement
        WebElement appearedAfter5Second = driver.findElement(By.cssSelector("input[value$='Click me!']"));
        appearedAfter5Second.click();
        System.out.println("Start: " + new Date());

        //define an Explicitly Wait - max waiting 7 second or text be present
        WebDriverWait explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(7));
        String delayText;
        try {
            explicitlyWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//h2[@id='two']")), "I am"));
            delayText = driver.findElement(By.xpath("//h2[@id='two']")).getText();
            System.out.println("The delay text: " + delayText);
            System.out.println("End: " + new Date());

        } catch (TimeoutException e) {
            System.out.println("End - " + new Date());
            System.out.println("Exception - " + e.getMessage());
        }

        driver.quit();
    }

}
