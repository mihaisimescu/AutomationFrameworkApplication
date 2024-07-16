package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.AccountActivityElements;

import java.time.Duration;

public class AccountsActivity {

    private AccountActivityElements elements;
    private Wait<WebDriver> wait;

    public AccountsActivity(WebDriver driver){
        this.elements = new AccountActivityElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getAccountId(){
        return elements.accountId().getText();
    }

    public String getTransaction(){
        wait.until(d-> elements.fundsSent().isDisplayed());
        return elements.fundsSent().getText();
    }

    public void clickAccount(){
        elements.accountId().click();
    }

    public Boolean noTransactionsFound(){
        try {
            wait.until(d -> elements.noTransactions().isDisplayed());
            return elements.noTransactions().isDisplayed();
        }catch ( Exception e ){
            return false;
        }
    }

    public String getNoTransactionsFoundText(){
        return elements.noTransactionsText().getText();
    }
}
