package tests;

import actions.Index;
import actions.Overview;
import actions.Register;
import actions.UpdateProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

import java.time.Duration;

public class UpdateProfileTest extends BaseTest {

    private Index login = null;
    ConfigurationLoader configurationLoader = null;
    ConfigurationLoader updateLoader = null;
    UpdateProfile updateProfile = null;
    private Overview overview= null;
    Register register = null;


    @Test
    public void updateProfile(){

        initTest("Update Profile Test");

        login = new Index(driver);

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

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

        // Go to update profile
        overview = new Overview(driver);
        overview.clickUpdateContactInfo();

        updateLoader = new ConfigurationLoader("src/test/resources/properties/updateProfile.properties");

        updateProfile = new UpdateProfile(driver);

        //Update profile
        updateProfile.enterFirstName(updateLoader.getProperty("firstName"));
        updateProfile.enterLastName(updateLoader.getProperty("lastName"));
        updateProfile.enterAddress(updateLoader.getProperty("address"));
        updateProfile.enterCity(updateLoader.getProperty("city"));
        updateProfile.enterState(updateLoader.getProperty("state"));
        updateProfile.enterZipCode(updateLoader.getProperty("zipCode"));
        updateProfile.enterPhone(updateLoader.getProperty("phone"));

        updateProfile.clickUpdateProfile();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Profile Updated')]")));
        Assert.assertEquals(updateProfile.getUpdateProfileResult(), updateLoader.getProperty("updateProfileResult"));
    }
}
