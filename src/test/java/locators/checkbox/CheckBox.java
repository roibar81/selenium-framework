package locators.checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBox {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/roibar/Desktop/projects/chromedriver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");
        Thread.sleep(2000);

        //collect all the radio buttons in list
        List<WebElement> checkBoxes = driver.findElements(By.name("language"));
        System.out.println(checkBoxes.size());

        //clicking on the automationTesting checkbox
        for (WebElement cbx : checkBoxes) {
            System.out.println(cbx.getAttribute("value"));
            if (cbx.getAttribute("value").equals("automationtesting")) {
                cbx.click();
                System.out.println("Selected btn: " + cbx.isSelected());
                System.out.println("Checked? " + cbx.getAttribute("checked"));
                break;
            }
        }
        Thread.sleep(2000);

        //we can find the element by xpath also
        driver.findElement(By.xpath("//input[@value='java']")).click();


        Thread.sleep(5000);
        driver.quit();
    }
}
