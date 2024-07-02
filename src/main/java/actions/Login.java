package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.LoginElements;


import java.time.Duration;

public class Login {

    private LoginElements element;
    private Wait<WebDriver> wait;


    public Login(WebDriver driver){
        this.element = new LoginElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLoginButton(){
        element.getLoginButton().click();
    }

    public void enterUserName(String username){
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

}
