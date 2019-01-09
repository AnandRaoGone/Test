package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DragAndDropPage {

    WebDriver driver;
    @FindBy(xpath="//iframe[@class='demo-frame' and contains(@src,'photo-manager')]")
    WebElement frame;

    @FindBy(xpath="//h5[text()='High Tatras 4']/following-sibling::img")
    WebElement imageHigh_Tatras_4;

    @FindBy(xpath="//div[@id='trash']")
    WebElement spaceTrash;

    Actions action;

    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        PageFactory.initElements(driver, this);
    }


    public void loadDragAndDropPage() throws Exception {
        driver.get("http://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
    }

    public void dragInToTrash(){
        driver.switchTo().frame(frame);
        action = new Actions(driver);
        action.dragAndDrop(imageHigh_Tatras_4,spaceTrash).build().perform();
        driver.switchTo().defaultContent();
    }



}
