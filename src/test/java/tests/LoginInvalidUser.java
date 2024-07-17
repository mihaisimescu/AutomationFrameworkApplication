package tests;

import actions.Index;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

public class LoginInvalidUser extends BaseTest {

    private Index login = null;

    @Test
    public void invalidLogin(){

        initTest("Invalid Login Test");

        login = new Index(driver);
        ConfigurationLoader configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        String username = configurationLoader.getProperty("invalidUsername");
        String password = configurationLoader.getProperty("invalidPassword");
        String errorMsg = configurationLoader.getProperty("errorMsg");

        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        Assert.assertEquals(login.getInvalidLoginMsg(),errorMsg);
    }

    }
