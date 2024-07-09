package actions;

import org.openqa.selenium.WebDriver;
import webelements.FindTransactionsElements;
import webelements.OpenAccountElements;

public class FindTransactions {

    private FindTransactionsElements elements;

    public FindTransactions (WebDriver driver){
        this.elements = new FindTransactionsElements(driver);
    }

    public String getTransactionsTitle(){
        return elements.getFindtransactionsTitle().getText();
    }
}
