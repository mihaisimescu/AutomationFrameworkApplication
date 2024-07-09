package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.OpenAccountElements;

import java.time.Duration;

public class OpenAccount {

    private OpenAccountElements elements;

    public OpenAccount (WebDriver driver){
        this.elements = new OpenAccountElements(driver);
    }

    public void clickSubmit() {
        elements.submitButton().click();
    }

    public String getOpenAccountResult(){
        return elements.openAccountResult().getText();
    }

    public String getOpenNewAccountTitle(){
        return elements.getOpenAccountTitle().getText();
    }
}
