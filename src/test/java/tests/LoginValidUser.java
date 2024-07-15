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
        loginUser();

        String expected = configurationLoader.getProperty("LoginSuccessfull");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Assert.assertEquals(login.getUser(),expected);
    }

    private void loginUser(){

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        String username = configurationLoader.getProperty("username");
        String password = configurationLoader.getProperty("password");

        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        if(login.errorLoginText()){

            register.registerNewUser();

            login.enterUserName(username);
            login.enterPassword(password);
            login.clickLoginButton();
        }

    }
}
