package tests;

import actions.BillPay;
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

public class BillPayTest extends BaseTest {

    private Index login = null;
    ConfigurationLoader configurationLoader = null;
    private BillPay billPay = null;
    private Overview overview= null;

    @Test
    public void billPay(){

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

        //* Go to BillPay page
        overview = new Overview(driver);
        overview.clickBillPay();

        billPay = new BillPay(driver);

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


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='amount']")));

        //Assert.assertEquals(billPay.accountId(),accountID);
        Assert.assertEquals(billPay.sentAmount(), amount);


    }

}
