package tests;

import actions.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

import java.time.Duration;

public class RegisterUser extends BaseTest {

    public Register register = null;

    @Test
    public void registerUser(){

        register = new Register(driver);

        register.registerNewUser();

        String expected = "Welcome Simi133";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='title']")));

        Assert.assertEquals(register.registerDone().toLowerCase(), expected.toLowerCase());

    }

    }
