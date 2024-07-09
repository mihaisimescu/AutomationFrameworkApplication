package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillPayElements {

    private WebDriver driver = null;

    public BillPayElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement payeeName(){
        return driver.findElement(By.cssSelector("input[name='payee.name']"));
    }

    public WebElement payeeAddress(){
        return driver.findElement(By.cssSelector("input[name='payee.address.street']"));
    }

    public WebElement payeeCity(){
        return driver.findElement((By.cssSelector("input[name='payee.address.city']")));
    }

    public WebElement payeeState(){
        return driver.findElement((By.cssSelector("input[name='payee.address.state']")));
    }

    public WebElement payeeZipCode(){
        return driver.findElement(By.cssSelector("input[name='payee.address.zipCode']"));
    }

    public WebElement payeePhoneNumber(){
        return driver.findElement(By.cssSelector("input[name='payee.phoneNumber']"));
    }

    public WebElement payeeAccount(){
        return driver.findElement(By.cssSelector("input[name='payee.accountNumber']"));
    }

    public WebElement payeeVerifyAccount(){
        return driver.findElement(By.cssSelector("input[name='verifyAccount']"));
    }

    public WebElement payeeAmount(){
        return driver.findElement(By.cssSelector("input[name='amount']"));
    }

    public WebElement sendPayment(){
        return driver.findElement(By.cssSelector("input[value='Send Payment']"));
    }

    public WebElement checkSentAmount(){
        return driver.findElement(By.cssSelector("span[id='amount']"));
    }

    public WebElement checkFromAccountId(){
        return driver.findElement(By.cssSelector("span[id='fromAccountId']"));
    }

    public WebElement getBillPaymentService(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Bill Payment Service')]"));
    }
}
