package tests;

import actions.BillPay;
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

public class BillPayTest extends BaseTest {

    private Index login = null;
    private ConfigurationLoader configurationLoader = null;
    private BillPay billPay = null;
    private Overview overview= null;
    private Register register = null;

    @Test
    public void billPay(){

        initTest("Bill Pay Test");

        login = new Index(driver);
        billPay = new BillPay(driver);
        overview = new Overview(driver);

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

        //* Go to BillPay page
        overview.clickBillPay();

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/billPayData.properties");

        billPay.enterPayeeName(configurationLoader.getProperty("payeeName"));
        billPay.enterAddress(configurationLoader.getProperty("payeeAddress"));
        billPay.enterCity(configurationLoader.getProperty("payeeCity"));
        billPay.enterState(configurationLoader.getProperty("payeeState"));
        billPay.enterZipCode(configurationLoader.getProperty("payeeZipCode"));
        billPay.enterPhone(configurationLoader.getProperty("payeePhone"));
        billPay.enterAccount(configurationLoader.getProperty("payeeAccount"));
        billPay.verifyAccount(configurationLoader.getProperty("verifyPayeeAccount"));
        billPay.enterAmount(configurationLoader.getProperty("payeeAmount"));

        String accountID = billPay.accountId();
        String amount = "$" + configurationLoader.getProperty("payeeAmount");

        billPay.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='amount']")));

        //Assert.assertEquals(billPay.accountId(),accountID);
        Assert.assertEquals(billPay.sentAmount(), amount);
    }
}
