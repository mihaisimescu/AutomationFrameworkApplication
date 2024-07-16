package tests;

import actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

import java.time.Duration;
import java.util.List;

public class OpenAccountTest extends BaseTest {

    private Index login = null;
    ConfigurationLoader configurationLoader = null;
    private Overview overview= null;
    OpenAccount openAccount = null;
    AccountOverview accountOverview = null;
    Register register = null;

    @Test
    public void openAccount(){

        login = new Index(driver);
        overview = new Overview(driver);
        openAccount = new OpenAccount(driver);
        accountOverview = new AccountOverview(driver);

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        // Log In Phase
        login.loginUser();

        //Check if the account not created
        if(login.errorLoginText()) {

            register = new Register(driver);
            register.registerNewUser();

            login.loginUser();
            //Go to accounts overview in order to store the default account ID
            overview.clickAccountsOverview();
        }

        //Check if login is successful, by checking if logout link is present
        Assert.assertTrue(login.checkLogout());

        //Store default account
        String defaultAccount = accountOverview.getDefaultAccount();

        //Go to open new account page
        overview.clickOpenNewAccount();

        //Select type of account and default account
        openAccount.selectTypeOfAccount(configurationLoader.getProperty("savingAccount"));
        openAccount.selectFromAccount(defaultAccount);

        //Click submit button
        openAccount.clickSubmit();

        //Check if the account has been created
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Account Opened!')]")));
        Assert.assertEquals(openAccount.getOpenAccountResult(), configurationLoader.getProperty("openAccountResult"));

        //Go to open new account page
        overview.clickOpenNewAccount();

        //Select type of account and default account
        openAccount.selectTypeOfAccount(configurationLoader.getProperty("checkingAccount"));
        openAccount.selectFromAccount(defaultAccount);

        //Click submit button
        openAccount.clickSubmit();

        //Check if the account has been created
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Account Opened!')]")));
        Assert.assertEquals(openAccount.getOpenAccountResult(), configurationLoader.getProperty("openAccountResult"));
    }
}
