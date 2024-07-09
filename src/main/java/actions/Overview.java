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
    public void clickBillPay(){
        elements.getBillPay().click();
    }


    public void clickOpenNewAccount(){
        elements.openNewAccount().click();
    }

    public void clickAccountsOverview(){
        elements.accountsOverview().click();
    }

    public void clickTransferFunds(){
        elements.transferFunds().click();
    }

    public void clickFindTransactions(){
        elements.findTransactions().click();
    }

    public void clickUpdateContactInfo(){
        elements.updateContact().click();
    }

    public void clickRequestLoan(){
        elements.requestLoan().click();
    }
}
