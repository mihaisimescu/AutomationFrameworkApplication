package tests;

import actions.*;
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
    private ConfigurationLoader configurationLoader = null;
    private Transfer transferFunds;
    private Overview overview = null;
    private Select dropdownFromAccount = null;
    private Select dropdownToAccount = null;
    private AccountOverview accountOverview= null;
    private Register register = null;

    @Test
    public void transferFunds(){

        initTest("Transfer Funds Test");

        login = new Index(driver);
        overview = new Overview(driver);
        accountOverview = new AccountOverview(driver);

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

        overview.clickAccountsOverview();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='accountTable']/tbody/tr[1]/td[1]/a")));

        // Go to accounts overview to get the default account id

        String defaultAccount = accountOverview.getDefaultAccount();

        //Go to TransferFunds
        overview.clickTransferFunds();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[id='fromAccountId']")));

        //Enter amount to be transferred
        transferFunds = new Transfer(driver);
        transferFunds.enterAmount(configurationLoader.getProperty("transferAmount"));

        //Select accounts
        transferFunds.selectFromAccountId(defaultAccount);
        transferFunds.selectToAccountId(defaultAccount);

        transferFunds.clickSubmitButton();

        Assert.assertEquals(transferFunds.getTransferComplete(),configurationLoader.getProperty("transferComplete"));
    }
}
