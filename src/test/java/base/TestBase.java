package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeClass;



public class TestBase {

    public static WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterTest
    public void closeBrowser() {
        driver.close();
    }

}