package actions;

import org.openqa.selenium.WebDriver;
import webelements.UpdateProfileElements;

public class UpdateProfile {

    private UpdateProfileElements elements;

    public UpdateProfile(WebDriver driver){
        this.elements = new UpdateProfileElements(driver);
    }

    public String getUpdateContactTitle(){
        return elements.getUpdateContactInfo().getText();
    }

    public void enterFirstName(String firstName){
        elements.firstName().clear();
        elements.firstName().sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        elements.lastName().clear();
        elements.lastName().sendKeys(lastName);
    }

    public void enterAddress(String address){
        elements.address().clear();
        elements.address().sendKeys(address);
    }

    public void enterCity(String city){
        elements.city().clear();
        elements.city().sendKeys(city);
    }

    public void enterState(String state){
        elements.state().clear();
        elements.state().sendKeys(state);
    }

    public void enterZipCode(String zipCode){
        elements.zipCode().clear();
        elements.zipCode().sendKeys(zipCode);
    }

    public void enterPhone(String phone){
        elements.phoneNumber().clear();
        elements.phoneNumber().sendKeys(phone);
    }

    public void clickUpdateProfile(){
        elements.updateProfile().click();
    }

    public String getUpdateProfileResult(){
        return elements.getUpdateContactInfoResult().getText();
    }
}
