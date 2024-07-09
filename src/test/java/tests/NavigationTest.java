package tests;

import actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

import java.time.Duration;

public class NavigationTest extends BaseTest {

    private Index login = null;
    ConfigurationLoader configurationLoader = null;
    private Overview overview= null;
    private OpenAccount openAccount;
    private AccountOverview accountOverview;
    private Transfer transfer;
    private BillPay billPay;
    private FindTransactions findTransactions;
    private UpdateProfile updateProfile;
    private RequestLoan requestLoan;

    @Test
    public void navigationOverview(){

        login = new Index(driver);

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        String username = configurationLoader.getProperty("username");
        String password = configurationLoader.getProperty("password");

        // Log In Phase
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='logout.htm']")));

        // Go to Open New Account
        overview = new Overview(driver);
        overview.clickOpenNewAccount();

        openAccount = new OpenAccount(driver);
        Assert.assertEquals(openAccount.getOpenNewAccountTitle(), configurationLoader.getProperty("openAccountTitle"));

        // Got to Accounts Overview
        overview.clickAccountsOverview();
        accountOverview = new AccountOverview(driver);
        Assert.assertEquals(accountOverview.getOpenNewAccountTitle(), configurationLoader.getProperty("accountOverviewTitle"));

        //Go to Transfer Funds
        overview.clickTransferFunds();
        transfer = new Transfer(driver);
        Assert.assertEquals(transfer.getTransferTitle(), configurationLoader.getProperty("transferFunds"));

        //Go to Bill Pay
        overview.clickBillPay();
        billPay = new BillPay(driver);
        Assert.assertEquals(billPay.getBillPaymentTitle(), configurationLoader.getProperty("billPayment"));

        //Go to Find Transactions
        overview.clickFindTransactions();
        findTransactions = new FindTransactions(driver);
        Assert.assertEquals(findTransactions.getTransactionsTitle(), configurationLoader.getProperty("findTransactions"));

        //Go to Update Contact Info
        overview.clickUpdateContactInfo();
        updateProfile = new UpdateProfile(driver);
        Assert.assertEquals(updateProfile.getUpdateContactTitle(), configurationLoader.getProperty("updateProfile"));

        //Go to Request Loan
        overview.clickRequestLoan();
        requestLoan = new RequestLoan(driver);
        Assert.assertEquals(requestLoan.getRequestTitle(), configurationLoader.getProperty("requestLoan"));

        //Log out
        overview.clickLogout();
        Assert.assertEquals(overview.getCustomerLoginText(), configurationLoader.getProperty("logout"));
    }
}
