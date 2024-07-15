package actions;

import org.openqa.selenium.WebDriver;
import webelements.AccountActivityElements;

public class AccountsActivity {

    private AccountActivityElements elements;

    public AccountsActivity(WebDriver driver){
        this.elements = new AccountActivityElements(driver);
    }

    public String getAccountId(){
        return elements.accountId().getText();
    }

    public String getTransaction(){
        return elements.fundsSent().getText();
    }
}
