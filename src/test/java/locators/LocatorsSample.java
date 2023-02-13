package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsSample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/roibar/Desktop/projects/chromedriver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");

        /*The hierarchical of search element is:
        * 1- id
        * 2- name or className
        * linktext or partiallink
        * XPath & cssSelector*/

        /*driver.findElement(By.className("EnterText")).sendKeys("QAVBOX");
        driver.findElement(By.id("email")).sendKeys("qavbox@gmail.com");
        driver.findElement(By.id("tel")).sendKeys("123456543");*/
        Thread.sleep(2000);
//        driver.findElement(By.className("btn")).click();
//        driver.findElement(By.linkText("Tutorials!")).click();
//        driver.findElement(By.partialLinkText("Tutoria")).click();

//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("QAVBOX");
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys("QAVBOXBYCSSSELECTOR");
        Thread.sleep(5000);
        driver.quit();
    }

}
