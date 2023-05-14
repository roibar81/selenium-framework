package widowshandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class MultiWindowsTest {
    WebDriver driver;

    @BeforeMethod
    public void init() {
//        System.setProperty("webdriver.chrome.driver", "C:/Users/roibar/Desktop/projects/chromedriver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qavbox.github.io/demo/links/");
    }

    @Test
    public void twoWindowsHandles() {
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window ID: " + parentWindow);
        System.out.println("Parent Window Title: " + driver.getTitle());

        WebElement newTabButton = driver.findElement(By.xpath("//input[@name='NewTab']"));
        newTabButton.click();

        //store multiple windows in Set of Strings (id of window)
        Set<String> windows = driver.getWindowHandles();

        //create iterator to iterate on thw windows
        Iterator<String> windowsIterator = windows.iterator();

        String firstWindow = windowsIterator.next();//Parent window
        String secondWindow = windowsIterator.next();//2nd window

        //switch to the second window
        driver.switchTo().window(secondWindow);

        //now we can handle the second window, and this time to enter username
        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@id='g4072-fullname']"));
        usernameTextBox.sendKeys("RRRRR");
        System.out.println("Second window title: " + driver.getTitle());

        //now switch bake to parent window
        driver.switchTo().window(firstWindow);
        System.out.println("Parent window title: " + driver.getTitle());
    }

    @Test
    public void multipleWindowsHandling() {
        WebElement multiWindowsButton = driver.findElement(By.xpath("//input[@value='Multi Window']"));
        multiWindowsButton.click();
        Set<String> allWindowsHandling = driver.getWindowHandles();
        Iterator<String> iterateWindows = allWindowsHandling.iterator();
        System.out.println("Number of Windows: " + allWindowsHandling.size());
        while (iterateWindows.hasNext()) {
            String currentWindow = iterateWindows.next();
            driver.switchTo().window(currentWindow);
            System.out.println("Window Title: " + driver.getTitle());
        }
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}


