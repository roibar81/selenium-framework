package locators.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectDropDownSample {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/signup/");

        WebElement element = driver.findElement(By.id("tools"));

        Select select = new Select(element);
        select.selectByIndex(1);
        select.selectByValue("selenium");
        select.selectByVisibleText("WebdriverIO");

        System.out.println("Printing all selected option");
        for (WebElement allSelectedOption : select.getAllSelectedOptions()) {
            System.out.println(allSelectedOption.getText());
        }

        //store all the selected options in list of webElement object
        List<WebElement> selectedOptions = select.getOptions();
        //print the number of selected option in the selectedDropDown as a size of the list
        System.out.println("DropDown items count - " + selectedOptions.size());
        //add another selection item by clicking on him using
        for (WebElement op : selectedOptions) {
            //store each WebElement value to string
            String name = op.getAttribute("value");
            //check if the attribute value == "male"
            if (name.equals("jmeter")) {
                //click the "jmeter" WebElement
                op.click();
                System.out.println(op.getAttribute("value"));
            }
        }

        driver.quit();
    }

}
