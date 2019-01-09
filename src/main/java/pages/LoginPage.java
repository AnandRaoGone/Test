package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage{

    WebDriver driver ;
    @FindBy(xpath="//input[@name='login_email']")
    WebElement textFieldEmail;

    @FindBy(name="login_password")
    WebElement textFieldPassword;

    @FindBy(xpath="//button/div[text()='Sign in']")
    WebElement buttonSignIn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void login(String username, String password){
        textFieldEmail.sendKeys(username);
        textFieldPassword.sendKeys(password);
        buttonSignIn.click();
    }

    public void loadPage(){
        driver.get("https://www.dropbox.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }


}
