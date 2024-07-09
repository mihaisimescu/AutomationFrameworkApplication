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
}
