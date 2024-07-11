package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferElements {

    private WebDriver driver = null;

    public TransferElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getTransferFundsTitle(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Transfer Funds')]"));
    }

    public WebElement submitButton(){
        return driver.findElement(By.cssSelector("input[value='Transfer']"));
    }

    public WebElement amount(){
        return driver.findElement(By.cssSelector("input[id='amount']"));
    }

    public WebElement amountResult(){
        return driver.findElement(By.cssSelector("span[id='amountResult']"));
    }

    public WebElement fromAccountIdResult(){
        return driver.findElement(By.cssSelector("span[id='fromAccountIdResult']"));
    }

    public WebElement toAccountIdResult(){
        return driver.findElement(By.cssSelector("span[id='toAccountIdResult']"));
    }

    public WebElement transferComplete(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Transfer Complete!')]"));
    }
}

