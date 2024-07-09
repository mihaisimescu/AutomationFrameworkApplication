package actions;

import org.openqa.selenium.WebDriver;
import webelements.BillPayElements;

public class BillPay {

    private BillPayElements element;

    public BillPay(WebDriver driver){
        this.element = new BillPayElements(driver);
    }

    public void enterPayeeName(String name){
        element.payeeName().sendKeys(name);
    }

    public void enterAddress(String address){
        element.payeeAddress().sendKeys(address);
    }

    public void enterCity(String city){
        element.payeeCity().sendKeys(city);
    }

    public void enterState(String state){
        element.payeeState().sendKeys(state);
    }

    public void enterZipCode(String zipCode){
        element.payeeZipCode().sendKeys(zipCode);
    }

    public void enterPhone(String phone){
        element.payeePhoneNumber().sendKeys(phone);
    }

    public void enterAccount(String account){
        element.payeeAccount().sendKeys(account);
    }

    public void verifyAccount(String verifyAccount){
        element.payeeVerifyAccount().sendKeys(verifyAccount);
    }

    public void enterAmount(String amount){
        element.payeeAmount().sendKeys(amount);
    }

    public void  clickSubmit(){
        element.sendPayment().click();
    }

    public String accountId(){
        return element.checkFromAccountId().getText();
    }

    public String sentAmount(){
        return element.checkSentAmount().getText();
    }

    public String getBillPaymentTitle(){
        return element.getBillPaymentService().getText();
    }
}
