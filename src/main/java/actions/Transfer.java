package actions;

import org.openqa.selenium.WebDriver;
import webelements.TransferElements;

public class Transfer {

    private TransferElements elements;

    public Transfer(WebDriver driver){
        this.elements = new TransferElements(driver);
    }

    public void clickTransferButton(){
        elements.transferButton().click();
    }

    public void enterAmount(String amount){
        elements.amount().sendKeys(amount);
    }


}
