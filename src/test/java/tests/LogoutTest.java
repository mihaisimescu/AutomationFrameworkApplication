package tests;

import actions.Index;
import actions.Overview;
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
    ConfigurationLoader configurationLoader = null;

    @Test
    public void logOut(){

        login = new Index(driver);

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        String username = configurationLoader.getProperty("username");
        String password = configurationLoader.getProperty("password");

        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='logout.htm']")));

        overview = new Overview(driver);
        overview.clickLogout();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']")));

        Assert.assertEquals(overview.getCustomerLoginText(), configurationLoader.getProperty("logout"));

    }

}
