package locators.buttons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");

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

        //we can find the element by xpath also
        driver.findElement(By.xpath("//input[@value='seven']")).click();

        driver.quit();
    }
}
