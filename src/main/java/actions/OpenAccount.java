package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.OpenAccountElements;

import java.time.Duration;

public class OpenAccount {

    private OpenAccountElements elements;
    private Wait<WebDriver> wait;
    private Select select;

    public OpenAccount (WebDriver driver){
        this.elements = new OpenAccountElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickSubmit() {
        //wait.until(d->elements.submitButton().isDisplayed());
        elements.submitButton().click();
    }

    public String getOpenAccountResult(){
        return elements.openAccountResult().getText();
    }

    public String getOpenNewAccountTitle(){
        return elements.getOpenAccountTitle().getText();
    }

    public void selectTypeOfAccount(String typeOfAccount){

        select = new Select(elements.typeOfAccountDropdown());
        select.selectByVisibleText(typeOfAccount);
    }

    public void selectFromAccount(String typeOfAccount){
    try {
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                Select select = new Select(elements.fromAccountDropdown());
                return select.getOptions().size() > 1;
            }
        });

        select = new Select(elements.fromAccountDropdown());
        select.selectByValue(typeOfAccount);
    }catch(Throwable e){
        //Do nothing
    }
    }
}
