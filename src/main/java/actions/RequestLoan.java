package actions;

import org.openqa.selenium.WebDriver;
import webelements.RequestLoanElements;

public class RequestLoan {

    private RequestLoanElements elements;

    public RequestLoan(WebDriver driver){
        this.elements = new RequestLoanElements(driver);
    }

    public String getRequestTitle(){
        return elements.getRequestLoanTitle().getText();
    }
}
