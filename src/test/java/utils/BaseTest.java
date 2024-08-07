package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class BaseTest {

    public WebDriver driver;
    private ExtentTest extentTest;
    private ScreenshotUtils screenshotUtils;

    @BeforeClass
    public void setupClass(){

        // Setup chrome driver
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        screenshotUtils = new ScreenshotUtils(driver);

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
        ReportManager.getInstance().flush();
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            captureAndSaveFailureScreenshot(result.getMethod().getMethodName());
        }
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test case Failed: " + result.getName(), ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        } else if(result.getStatus() == ITestResult.SUCCESS){
            extentTest.log(Status.PASS, MarkupHelper.createLabel("Test case Passed: " + result.getName(), ExtentColor.GREEN));
        } else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test case Skipped: " + result.getName(), ExtentColor.YELLOW));
        }
    }

    public void initTest(String testName){
        extentTest = ReportManager.createTest(testName);
    }

    private void captureAndSaveFailureScreenshot(String testName) {
        //Create a new folder if it does not exist
        File screenshotDirectory = new File("screenshots");
        if(screenshotDirectory.exists()){
            screenshotDirectory.mkdir();
        }

        // Capture and save screenshot
        screenshotUtils.captureAndSaveScreenshots(testName);

    }

}
