package actions;

import org.openqa.selenium.WebDriver;
import webelements.RegisterElements;

public class Register {

    private RegisterElements elements;

    public Register(WebDriver driver){
        this.elements = new RegisterElements(driver);
    }

    public void clickRegisterButton(){
        elements.getRegisterButton().click();
    }

    public void enterFirstName(String firstname){
        elements.firstName().sendKeys(firstname);
    }

    public void enterLastName(String lastname){
        elements.lastName().sendKeys(lastname);
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

    public void enterPhone(String phone){
        elements.phone().sendKeys(phone);
    }

    public void enterSocialSecurityNumber(String ssn){
        elements.socialSecurityNumber().sendKeys(ssn);
    }

    public void enterUsername(String username){
        elements.username().sendKeys(username);
    }

    public void enterPassword(String password){
        elements.password().sendKeys(password);
    }

    public void confirmPassword(String password){
        elements.confirmPassword().sendKeys(password);
    }

    public void clickSubmitButton(){
        elements.submitButton().click();
    }

    public String registerDone(){
        return elements.registerSuccessful().getText();
    }

}
