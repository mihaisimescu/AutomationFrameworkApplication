package utils;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    private ExtentTest extent;

    @BeforeClass
    public void setupClass(){

        // Setup chrome driver
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        //Get web page url from properties file
        ConfigurationLoader configurationLoader = new ConfigurationLoader("src/test/resources/properties/webPage.properties");
        String webPage = configurationLoader.getProperty("webPage");
        driver.get(webPage);
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
