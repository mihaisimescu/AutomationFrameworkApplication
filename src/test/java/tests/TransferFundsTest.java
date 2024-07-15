package tests;

import actions.AccountOverview;
import actions.Index;
import actions.Overview;
import actions.Transfer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

import java.time.Duration;

public class TransferFundsTest extends BaseTest {

    private Index login = null;
    ConfigurationLoader configurationLoader = null;
    Transfer transferFunds;
    private Overview overview = null;
    Select dropdownFromAccount = null;
    Select dropdownToAccount = null;
    private AccountOverview accountOverview= null;

    @Test
    public void transferFunds(){

        login = new Index(driver);

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        String username = configurationLoader.getProperty("username");
        String password = configurationLoader.getProperty("password");

        // Log In Phase
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='accountTable']/tbody/tr[1]/td[1]/a")));

        // Go to Open New Account
        overview = new Overview(driver);

        // Go to accounts overview to get the default account id
        accountOverview = new AccountOverview(driver);
        String defaultAccount = accountOverview.getDefaultAccount();

        //Go to TransferFunds
        overview.clickTransferFunds();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[id='fromAccountId']")));

        //Enter amount to be transferred
        transferFunds = new Transfer(driver);
        transferFunds.enterAmount(configurationLoader.getProperty("transferAmount"));

        dropdownFromAccount = new Select(driver.findElement(By.cssSelector("select[id='fromAccountId']")));
        dropdownToAccount = new Select(driver.findElement(By.cssSelector("select[id='toAccountId']")));

        //Select accounts
        dropdownFromAccount.selectByVisibleText(defaultAccount);
        dropdownToAccount.selectByVisibleText(defaultAccount);

        transferFunds.clickSubmitButton();

        Assert.assertEquals(transferFunds.getTransferComplete(),configurationLoader.getProperty("transferComplete"));
    }
}
