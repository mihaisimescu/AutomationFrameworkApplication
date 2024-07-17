package tests;

import actions.Index;
import actions.Lookup;
import actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

public class FindMyLoginInfoTest extends BaseTest {

    private Index login = null;
    ConfigurationLoader configurationLoader = null;
    Lookup lookup= null;

    @Test
    public void ForgotLogin(){

        initTest("Forgot Login Test");

        login = new Index(driver);
        lookup = new Lookup(driver);

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/registerUserData.properties");

        // Go to forgot login info
        login.clickForgotLogin();

        // Enter data
        enterData();

        lookup.clickFindMyLoginInfo();

        Assert.assertEquals(lookup.getUsernameText(),": " + configurationLoader.getProperty("userName"));
        Assert.assertEquals(lookup.getPasswordText(), ": " + configurationLoader.getProperty("password"));
    }

    private void enterData() {
        lookup.enterFirstName(configurationLoader.getProperty("firstName"));
        lookup.enterLastName(configurationLoader.getProperty("lastName"));
        lookup.enterAddress(configurationLoader.getProperty("address"));
        lookup.enterCity(configurationLoader.getProperty("city"));
        lookup.enterState(configurationLoader.getProperty("state"));
        lookup.enterZipCode(configurationLoader.getProperty("zipCode"));
        lookup.enterSSN(configurationLoader.getProperty("ssn"));
    }
}
