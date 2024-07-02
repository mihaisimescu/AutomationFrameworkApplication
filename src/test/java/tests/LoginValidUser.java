package tests;

import actions.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

import java.time.Duration;

public class LoginValidUser extends BaseTest {

    private Login login = null;

    @Test
    public void validLogin(){

        login = new Login(driver);
        ConfigurationLoader configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        String username = configurationLoader.getProperty("username");
        String password = configurationLoader.getProperty("password");

        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        String expected = "Welcome Mihai Simescu";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='smallText']")));

        Assert.assertEquals(login.getUser(),expected);
    }
}
