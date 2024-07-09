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
}
