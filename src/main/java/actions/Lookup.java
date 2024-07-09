package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.IndexElements;
import webelements.LookupElements;

import java.time.Duration;

public class Lookup {

    private LookupElements elements;
    private JavascriptExecutor javascriptExecutor;


    public Lookup(WebDriver driver){
        this.elements = new LookupElements(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void enterFirstName(String firstName){
        elements.firstName().sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        elements.lastName().sendKeys(lastName);
    }

    public void enterAddress(String address){
        elements.address().sendKeys(address);
    }

    public void enterCity(String city){
        elements.city().sendKeys(city);
    }

    public void enterState(String state){
        elements.state().sendKeys(state);
   }

   public void enterZipCode(String zipCode){
        elements.zipCode().sendKeys(zipCode);
   }

    public void enterSSN(String ssn){
        elements.socialSecurityNumber().sendKeys(ssn);
    }

    public void clickFindMyLoginInfo(){
        elements.submitButton().click();
    }

    public String getUsernameText(){
        return (String) javascriptExecutor.executeScript("return arguments[0].nextSibling.nodeValue.trim()", elements.getUsername());
    }

    public String getPasswordText(){
        return (String) javascriptExecutor.executeScript("return arguments[0].nextSibling.nodeValue.trim()", elements.getPassword());
    }

}
