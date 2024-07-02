package tests;

import actions.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

public class LoginInvalidUser extends BaseTest {

    private Login login = null;

    @Test
    public void invalidLogin(){

        login = new Login(driver);
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
