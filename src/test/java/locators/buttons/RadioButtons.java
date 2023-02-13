package locators.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.List;

public class RadioButtons {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/roibar/Desktop/projects/chromedriver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");
        Thread.sleep(2000);

        //collect all the radio buttons in list
        List<WebElement> radioButtons = driver.findElements(By.name("experience"));
        System.out.println(radioButtons.size());

        //clicking on the four (4) value in radio buttons
        for (WebElement btn : radioButtons) {
            System.out.println(btn.getAttribute("value"));
            if (btn.getAttribute("value").equals("four")) {
                btn.click();
                System.out.println("Selected btn: " + btn.isSelected());
                System.out.println("Checked? " + btn.getAttribute("checked"));
//                break;
            }
        }
        Thread.sleep(2000);

        //we can find the element by xpath also
        driver.findElement(By.xpath("//input[@value='seven']")).click();


        Thread.sleep(5000);
        driver.quit();
    }
}
