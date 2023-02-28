package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Date;

public class ImplicitlyWait {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/roibar/Desktop/projects/chromedriver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/delay/");

        //define an Implicitly wait of 15 seconds
        //Implicitly wait is a wait max time duration which is defined or when the element is visible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement appearedAfter5Second = driver.findElement(By.cssSelector("input[value$='Start']"));
        appearedAfter5Second.click();
        System.out.println("Start: " + new Date());

        //hiding message after clicking the delay button
        String delayText = driver.findElement(By.xpath("//h2[@id='loaderdelay']")).getText();

        System.out.println("End: " + new Date());
        System.out.println("The delay text: " + delayText);

        driver.quit();
    }
}
