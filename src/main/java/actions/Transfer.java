package actions;

import org.openqa.selenium.WebDriver;
import webelements.TransferElements;

public class Transfer {

    private TransferElements elements;

    public Transfer(WebDriver driver){
        this.elements = new TransferElements(driver);
    }

    public String getTransferTitle(){
        return elements.getTransferFundsTitle().getText();
    }

    public void clickSubmitButton(){
        elements.submitButton().click();
    }

    public void enterAmount(String amount){
        elements.amount().sendKeys(amount);
    }

    public String getAmountResult(){
        return elements.amountResult().getText();
    }

    public String getFromAccountIdResult(){
        return elements.fromAccountIdResult().getText();
    }

    public String getToAccountIdResult(){
        return elements.toAccountIdResult().getText();
    }

    public String getTransferComplete(){
        return elements.transferComplete().getText();
    }

}
