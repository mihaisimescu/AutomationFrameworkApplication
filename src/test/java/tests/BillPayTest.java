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

public class BillPayTest extends BaseTest {

    private Index login = null;
    private ConfigurationLoader configurationLoader = null;
    private BillPay billPay = null;
    private Overview overview= null;
    private Register register = null;
    private AccountOverview accountOverview = null;

    @Test
    public void billPay(){

        initTest("Bill Pay Test");

        login = new Index(driver);
        billPay = new BillPay(driver);
        overview = new Overview(driver);
        accountOverview = new AccountOverview(driver);
        configurationLoader = new ConfigurationLoader("src/test/resources/properties/billPayData.properties");

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

        //Store number of bills to pay
        int numberOfBills = Integer.parseInt(configurationLoader.getProperty("numberOFBills"));

        payBills(numberOfBills);

        //checkTransactionHistory(numberOfBills);
    }

    private void payBills(int numberOfBills) {
        //loop through bills and pay them
        for (int i = 0; i< numberOfBills; i++) {

            //* Go to BillPay page
            overview.clickBillPay();

            //Enter Payee data
            billPay.enterPayeeName(configurationLoader.getProperty("payeeName" + String.valueOf(i)));
            billPay.enterAddress(configurationLoader.getProperty("payeeAddress" + String.valueOf(i)));
            billPay.enterCity(configurationLoader.getProperty("payeeCity" + String.valueOf(i)));
            billPay.enterState(configurationLoader.getProperty("payeeState" + String.valueOf(i)));
            billPay.enterZipCode(configurationLoader.getProperty("payeeZipCode" + String.valueOf(i)));
            billPay.enterPhone(configurationLoader.getProperty("payeePhone" + String.valueOf(i)));
            billPay.enterAccount(configurationLoader.getProperty("payeeAccount" + String.valueOf(i)));
            billPay.verifyAccount(configurationLoader.getProperty("verifyPayeeAccount" + String.valueOf(i)));
            billPay.enterAmount(configurationLoader.getProperty("payeeAmount" + String.valueOf(i)));

            //Store amount
            String amount = "$" + configurationLoader.getProperty("payeeAmount" + String.valueOf(i));

            //Click submit button
            billPay.clickSubmit();

            //Check if the amount sent matches the amount entered
            Assert.assertEquals(billPay.sentAmount(), amount);
        }
    }

    private void checkTransactionHistory(int numberOfBills) {
        //Go to accounts overview
        overview.clickAccountsOverview();

        //Click on the main account
        accountOverview.clickDefaultAccount();

        for (int i = 0; i< numberOfBills; i++ ){
            //Create transaction name
            String transactionName = configurationLoader.getProperty("transactionName") + " " + configurationLoader.getProperty("payeeName" + String.valueOf(i));
            //Check transaction history
            Assert.assertTrue(accountOverview.checkTransactionName(transactionName));
        }
    }


}
