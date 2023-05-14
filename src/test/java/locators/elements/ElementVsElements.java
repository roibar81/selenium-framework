package locators.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class ElementVsElements {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");

        //find only one element by cssSelector - it store all the elements which have the same cssSelector value
        WebElement element = driver.findElement(By.cssSelector("input[type='text']"));
        element.sendKeys("Roi"); //take the first index of element
        System.out.println(element.getAttribute("value"));

        System.out.println("------------------------------------------------------------------------------------");
        //find all textBoxes in the page
        List<WebElement> textBoxes = driver.findElements(By.cssSelector("input[type='text']"));
        System.out.println("Size of list elements:" + textBoxes.size());
        if (textBoxes.size() == 4)
            System.out.println("test case pass");
        else
            System.out.println("test case fail");
        System.out.println("------------------------------------------------------------------------------------");

        //send data to the second textBox
        textBoxes.get(1).sendKeys("Second TextBox");

        for (WebElement textBox : textBoxes) {
            if (textBox.getAttribute("value").equals(""))
                System.out.println("The textBox is empty");
            else
                System.out.println("TextBox value: " + textBox.getAttribute("value"));
        }
        System.out.println("------------------------------------------------------------------------------------");

        List<WebElement> automationTools = driver.findElements(By.className("ui-widget-content"));

        System.out.println("Size of Automation Tools are available in the page: " + automationTools.size());
        for (WebElement el : automationTools) {
//            if (el.getText().equals("Postman"))
                System.out.println("automation tool: " + el.getAttribute("value"));
        }

        driver.quit();
    }
}
