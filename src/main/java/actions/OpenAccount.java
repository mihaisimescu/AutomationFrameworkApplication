package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webelements.OpenAccountElements;

public class OpenAccount {

    OpenAccountElements elements;

    public OpenAccount (WebDriver driver){
        this.elements = new OpenAccountElements(driver);
    }

    public void clickSubmit(){
        elements.submitButton().click();
    }

    public String getOpenAccountResult(){
        return elements.openAccountResult().getText();
    }
}
