package tests;

import actions.Index;
import actions.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

import java.time.Duration;

public class LoginValidUser extends BaseTest {

    private Index login = null;
    ConfigurationLoader configurationLoader = null;
    private Register register = null;

    @Test
    public void validLogin(){

        login = new Index(driver);
        register = new Register(driver);

        login.loginUser();

        //Check if the account not created
        if(login.errorLoginText()) {

            register = new Register(driver);
            register.registerNewUser();
            login.loginUser();
          }

        //Check if login is successful, by checking if logout link is present
        Assert.assertTrue(login.checkLogout());
    }

}
