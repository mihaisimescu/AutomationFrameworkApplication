package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.OverviewElements;

import java.time.Duration;

public class Overview {

    private OverviewElements elements;
    private Wait<WebDriver> wait;

    public Overview(WebDriver driver){
        this.elements = new OverviewElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLogout() {
        elements.logout().click();
    }

    public String getCustomerLoginText(){
        return elements.logoutCheckSuccessful().getText();
    }
}
