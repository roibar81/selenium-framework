package locators.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonsSample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/roibar/Desktop/projects/chromedriver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");
        Thread.sleep(2000);

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
