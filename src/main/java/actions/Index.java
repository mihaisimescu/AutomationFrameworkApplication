package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigurationLoader;
import webelements.IndexElements;

import java.time.Duration;

public class Index {

    private IndexElements element;
    private Wait<WebDriver> wait;


    public Index(WebDriver driver){
        this.element = new IndexElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickLoginButton(){
        element.getLoginButton().click();
    }

    public void enterUserName(String username){
        wait.until(d->element.username().isDisplayed());
        element.username().sendKeys(username);
    }

    public void enterPassword(String password){
        element.password().sendKeys(password);
    }

    public String getUser(){
        return element.getUser().getText();
    }

    public String getInvalidLoginMsg(){
        return element.getInvalidUserMsg().getText();
    }

    public String usernameNotFound(){
        return element.getUserNotFound().getText();
    }

    public void clickForgotLogin(){
        element.getForgotLoginLink().click();
    }

    public boolean errorLoginText(){
        try {
            wait.until(d -> element.loginError().isDisplayed());
            return element.loginError().isDisplayed();
        }catch ( Exception e ){
            return false;
        }
    }

    public boolean checkLogout(){
        try {
            wait.until(d -> element.logout().isDisplayed());
            return element.logout().isDisplayed();
        }catch ( Exception e ){
            return false;
        }
    }

    public void loginUser(){
        ConfigurationLoader configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        enterUserName(configurationLoader.getProperty("username"));
        enterPassword(configurationLoader.getProperty("password"));

        clickLoginButton();

    }
}
