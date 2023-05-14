package locators.buttons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ButtonsSample {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.name("home"));
        String actual = element.getAttribute("value");

        if (actual.equals("Home"))
            System.out.println("test case pass");

        element.click();
        System.out.println("After clicking the button:" + driver.getCurrentUrl());

        if (driver.getCurrentUrl().equals("https://qavbox.github.io/demo/"))
            System.out.println("You are in the correct page");

        Thread.sleep(3000);
        driver.quit();
    }
}
