package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.AccountsOverviewElements;

import java.time.Duration;

public class AccountOverview {

    private AccountsOverviewElements elements;
    private Wait<WebDriver> wait;

    public AccountOverview(WebDriver driver){
        this.elements = new AccountsOverviewElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getOpenNewAccountTitle(){
        return elements.getAccountsOverviewTitle().getText();
    }

    public String getDefaultAccount(){
        wait.until(d->elements.defaultAccountId().isDisplayed());
        return elements.defaultAccountId().getText();
    }

    public void clickDefaultAccount(){
        elements.defaultAccountId().click();
    }

}
