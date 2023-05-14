package locators.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownSample {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.name("sgender"));

        Select select = new Select(element);


        /*
        Select select = new Select(element);
        select.selectByIndex(0);
        System.out.println("The selected value By Index = 0, is: \t" + select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        select.selectByValue("male");
        System.out.println("The selected value By Value = male, is:\t " + select.getFirstSelectedOption().getText());
        System.out.println("The selected value By Value = male, is:\t " + select.getFirstSelectedOption().getAttribute("value"));
        Thread.sleep(2000);
        select.selectByVisibleText("Not Applicable");
        System.out.println("The selected value By Visible Text = Not Applicable, is: \t" + select.getFirstSelectedOption().getText());
        //or
        //select.selectByValue("na");
         */

        //store all the selected options in list of webElement object
        List<WebElement> selectedOptions = select.getOptions();
        //print the number of selected option in the dropDown as a size of the list
        System.out.println("DropDown items count - " + selectedOptions.size());
        //clicking on "male" option in the DropDown
        for (WebElement op : selectedOptions) {
            //store each WebElement value to string
            String name = op.getAttribute("value");
            //check if the attribute value == "male"
            if (name.equals("male")) {
                //click the "male" WebElement
                op.click();
                System.out.println(op.getAttribute("value"));
            }
        }

        driver.quit();
    }

}
