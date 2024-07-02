package tests;

import actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

public class RegisterUser extends BaseTest {

    private Register register = null;

    @Test
    public void registerUser(){

        register = new Register(driver);

        ConfigurationLoader configurationLoader = new ConfigurationLoader("src/test/resources/properties/registerUserData.properties");

        register.clickRegisterButton();

        register.enterFirstName(configurationLoader.getProperty("firstName"));
        register.enterLastName(configurationLoader.getProperty("lastName"));
        register.enterAddress(configurationLoader.getProperty("address"));
        register.enterCity(configurationLoader.getProperty("city"));
        register.enterState(configurationLoader.getProperty("state"));
        register.enterZipCode(configurationLoader.getProperty("zipCode"));
        register.enterPhone(configurationLoader.getProperty("phone"));
        register.enterSocialSecurityNumber(configurationLoader.getProperty("ssn"));
        register.enterUsername(configurationLoader.getProperty("userName"));
        register.enterPassword(configurationLoader.getProperty("password"));
        register.confirmPassword(configurationLoader.getProperty("confirm"));

        register.clickSubmitButton();

        String expected = "Welcome sim@q.com";
        Assert.assertEquals(register.registerDone().toLowerCase(), expected.toLowerCase());

    }
}
