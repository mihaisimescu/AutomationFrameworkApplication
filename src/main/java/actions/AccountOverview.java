package actions;

import org.openqa.selenium.WebDriver;
import webelements.AccountsOverviewElements;

public class AccountOverview {

    private AccountsOverviewElements elements;

    public AccountOverview(WebDriver driver){
        this.elements = new AccountsOverviewElements(driver);
    }

    public String getOpenNewAccountTitle(){
        return elements.getAccountsOverviewTitle().getText();
    }

}
