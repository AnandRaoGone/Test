package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.concurrent.TimeUnit;

public class HomePage{

    WebDriver driver;

    @FindBy(xpath="//button//span[text()='Upload']")
    WebElement buttonUpload;

    @FindBy(xpath="(//button[@role='menuitem' and contains(@class,files)])[1]")
    WebElement linkFileUpload;

    @FindBy(xpath="//button/span[text()='Upload']")
    WebElement buttonUploadPopup;

    @FindBy(xpath="//div[@id='upload-fileops-modal']//li[@aria-label]")
    WebElement folderDropBox;

    @FindBy(xpath="//button/span[@class='mc-button-content']")
    WebElement linkViewDetails;

    @FindBy(xpath="//ol/li//span[@class='filename']")
    public WebElement textFileName;

    String filepath;
    String sikuliImages;
    Screen s;
    WebDriverWait wait;


    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,20);
    }

    public void clickUpload() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonUpload));
        buttonUpload.click();
    }

    public void setFilesLocation(String loc){
        filepath = System.getProperty("user.dir")+"\\src\\main\\resources\\UploadFiles\\"+loc+"\\";
        sikuliImages=System.getProperty("user.dir")+"\\src\\main\\resources\\ImagesForSikuli\\";
    }

    public void uploadFileFromWindows(String filename)throws FindFailed{
        s = new Screen();
        Pattern fileInputTextBox = new Pattern(sikuliImages + "FileTextBox.PNG");
        Pattern openButton = new Pattern(sikuliImages + "OpenButton.PNG");
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, filepath + filename);
        s.click(openButton);
    }

    public void selectDropboxLocation(){
        folderDropBox.click();
        buttonUploadPopup.click();
        linkViewDetails.click();
    }

    public void uploadFile(){
        wait.until(ExpectedConditions.elementToBeClickable(linkFileUpload));
        linkFileUpload.click();
    }

    public String readFileName(){
        return textFileName.getText();
    }

}
