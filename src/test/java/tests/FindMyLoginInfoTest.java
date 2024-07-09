package tests;

import actions.Index;
import actions.Lookup;
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

        login = new Index(driver);

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/registerUserData.properties");

        // Go to forgot login info
        login.clickForgotLogin();

        lookup = new Lookup(driver);

        // Enter data
        lookup.enterFirstName(configurationLoader.getProperty("firstName"));
        lookup.enterLastName(configurationLoader.getProperty("lastName"));
        lookup.enterAddress(configurationLoader.getProperty("address"));
        lookup.enterCity(configurationLoader.getProperty("city"));
        lookup.enterState(configurationLoader.getProperty("state"));
        lookup.enterZipCode(configurationLoader.getProperty("zipCode"));
        lookup.enterSSN(configurationLoader.getProperty("ssn"));

        lookup.clickFindMyLoginInfo();

        Assert.assertEquals(lookup.getUsernameText(),": " + configurationLoader.getProperty("userName"));
        Assert.assertEquals(lookup.getPasswordText(), ": " + configurationLoader.getProperty("password"));
    }
}
