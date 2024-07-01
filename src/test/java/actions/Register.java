package actions;

import org.openqa.selenium.WebDriver;
import webelements.RegisterElements;

public class Register {

    private RegisterElements element;

    public Register(WebDriver driver){
        this.element = new RegisterElements(driver);
    }

    public void clickRegisterButton(){
        element.getRegisterButton().click();
    }
}
