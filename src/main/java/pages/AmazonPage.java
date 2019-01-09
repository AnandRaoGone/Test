package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class AmazonPage {

    WebDriver driver;
    @FindBy(xpath="//a[@id='nav-link-wishlist']")
    WebElement linkYourLists;

    @FindBy(xpath="//span[text()='Create a Wish List']")
    WebElement linkCreateAWishList;

    Actions action;

    public AmazonPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        PageFactory.initElements(driver, this);
    }

    public void loadAmazonHomePage(){
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    public void hoverYourLists(){
        action = new Actions(driver);
        action.moveToElement(linkYourLists).build().perform();
    }

    public String readFirstLinkText(){
        return linkCreateAWishList.getText();
    }

}