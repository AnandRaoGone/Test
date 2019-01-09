package TestCases;

import org.testng.Assert;
import pages.AmazonPage;
import pages.DragAndDropPage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Testcases {

        LoginPage loginpage;
        HomePage homepage;
        AmazonPage amazonpage;
        DragAndDropPage dragAndDrop;

        public WebDriver driver;

        @BeforeMethod
        public void openBrowser() {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @AfterMethod
        public void closeBrowser() {
            driver.close();
        }

    /*Performing Data driven test through Data Provider*/
    @DataProvider(name = "FileNames")
        public static Object[][] fileNames() {
        return new Object[][] {{ "1", "TestFile1.docx" },
                { "2", "TestFile2.docx" },
                { "3", "TestFile3.docx" }
        };

    }
        /*This Test case will execute 3 times with above 3 data sets*/
        @Test(dataProvider = "FileNames")
        public void verifyFileUploadTest(String fileLocation, String fileName)throws Exception {
            loginpage = new LoginPage(driver);
            loginpage.loadPage();
            loginpage.login("anandrao2108@gmail.com","Anandrao@12345");
            homepage = new HomePage(driver);
            homepage.clickUpload();
            homepage.uploadFile();
            homepage.setFilesLocation(fileLocation);
            homepage.uploadFileFromWindows(fileName);
            homepage.selectDropboxLocation();
        }

        @Test
        public void verifyHoverTest() throws Exception {
            amazonpage = new AmazonPage(driver);
            amazonpage.loadAmazonHomePage();
            amazonpage.hoverYourLists();
            Assert.assertEquals("Create a Wish List",amazonpage.readFirstLinkText());
        }

        @Test
        public void verifyDragAndDropTest() throws Exception {
            dragAndDrop  = new DragAndDropPage(driver);
            dragAndDrop.loadDragAndDropPage();
            dragAndDrop.dragInToTrash();
        }
}