package tests;

import actions.Index;
import actions.Overview;
import actions.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

import java.time.Duration;

public class LogoutTest extends BaseTest {

    private Index login = null;
    private Overview overview = null;
    private Register register = null;
    private ConfigurationLoader configurationLoader;


    @Test
    public void logOut(){

        initTest("Logout Test");

        login = new Index(driver);
        overview = new Overview(driver);
        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        // Log In Phase
        login.loginUser();

        //Check if the account not created
        if(login.errorLoginText()) {
            //Register new user
            register = new Register(driver);
            register.registerNewUser();

        }

        //Check if login is successful, by checking if logout link is present
        Assert.assertTrue(login.checkLogout());

        //Click logout
        overview.clickLogout();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']")));

        Assert.assertEquals(overview.getCustomerLoginText(), configurationLoader.getProperty("logout"));

    }

}
