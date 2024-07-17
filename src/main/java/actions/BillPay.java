package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.BillPayElements;

import java.time.Duration;

public class BillPay {

    private BillPayElements elements;
    private Wait<WebDriver> wait;

    public BillPay(WebDriver driver){
        this.elements = new BillPayElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterPayeeName(String name){
        elements.payeeName().sendKeys(name);
    }

    public void enterAddress(String address){
        elements.payeeAddress().sendKeys(address);
    }

    public void enterCity(String city){
        elements.payeeCity().sendKeys(city);
    }

    public void enterState(String state){
        elements.payeeState().sendKeys(state);
    }

    public void enterZipCode(String zipCode){
        elements.payeeZipCode().sendKeys(zipCode);
    }

    public void enterPhone(String phone){
        elements.payeePhoneNumber().sendKeys(phone);
    }

    public void enterAccount(String account){
        elements.payeeAccount().sendKeys(account);
    }

    public void verifyAccount(String verifyAccount){
        elements.payeeVerifyAccount().sendKeys(verifyAccount);
    }

    public void enterAmount(String amount){
        elements.payeeAmount().sendKeys(amount);
    }

    public void  clickSubmit(){
        elements.sendPayment().click();
    }

    public String sentAmount(){
        wait.until(d->elements.checkSentAmount().isDisplayed());
        return elements.checkSentAmount().getText();
    }

    public String getBillPaymentTitle(){
        return elements.getBillPaymentService().getText();
    }
}
