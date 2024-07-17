package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.TransferElements;

import java.time.Duration;

public class Transfer {

    private TransferElements elements;
    private Select select;
    private Wait<WebDriver> wait;


    public Transfer(WebDriver driver){
        this.elements = new TransferElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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

    public void selectFromAccountId(String fromAccountId){
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    Select select = new Select(elements.fromAccountIdResult());
                    return select.getOptions().size() > 1;
                }
            });

            select = new Select(elements.fromAccountIdResult());
            select.selectByValue(fromAccountId);
        }catch(Throwable e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void selectToAccountId(String toAccountId){
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    Select select = new Select(elements.toAccountIdResult());
                    return select.getOptions().size() > 1;
                }
            });

            select = new Select(elements.toAccountIdResult());
            select.selectByValue(toAccountId);
        }catch(Throwable e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getTransferComplete(){
        wait.until(d->elements.transferComplete().isDisplayed());
        return elements.transferComplete().getText();
    }

}
