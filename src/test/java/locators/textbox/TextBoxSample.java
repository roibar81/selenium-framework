package locators.textbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxSample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/roibar/Desktop/projects/chromedriver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");
        Thread.sleep(2000);

        String expected = "Roi Test";

        //store the webElement for testing
        WebElement element = driver.findElement(By.id("username"));
        //send value to textBox
        element.sendKeys(expected);
        //store the value in the textBox and store in to string variable
        String actual = element.getAttribute("value");

        System.out.println(actual);
        if (actual.equals(expected))
            System.out.println("Test case passed");

        Thread.sleep(2000);

        //cleaning the textBox to continuously testing
        //by this method we can send list of inputs in loop to verify bugs
        element.clear();
        actual = element.getAttribute("value");
        System.out.println("After clear() actual is: " + actual);
        if (actual.equals(""))
            System.out.println("clear() - test case passed");


        Thread.sleep(5000);
        driver.quit();

    }
}
