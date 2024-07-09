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
}
