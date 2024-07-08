package tests;

import actions.Index;
import actions.OpenAccount;
import actions.Overview;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

import java.time.Duration;

public class OpenAccountTest extends BaseTest {

    private Index login = null;
    ConfigurationLoader configurationLoader = null;
    private Overview overview= null;
    OpenAccount openAccount = null;

    @Test
    public void openAccount(){

        login = new Index(driver);

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        String username = configurationLoader.getProperty("username");
        String password = configurationLoader.getProperty("password");

        // Log In Phase
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='logout.htm']")));

        overview = new Overview(driver);

        overview.clickOpenNewAccount();

        openAccount = new OpenAccount(driver);

        Select dropdown =  new Select(driver.findElement(By.cssSelector("select[id='type']")));

        dropdown.selectByVisibleText("SAVINGS");

        openAccount.clickSubmit();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Account Opened!')]")));
        Assert.assertEquals(openAccount.getOpenAccountResult(), configurationLoader.getProperty("openAccountResult"));
    }
}
