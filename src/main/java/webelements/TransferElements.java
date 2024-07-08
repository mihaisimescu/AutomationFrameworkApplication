package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferElements {

    private WebDriver driver = null;

    public TransferElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement amount(){
        return driver.findElement(By.cssSelector("input[id='amount']"));
    }

    public WebElement transferButton(){
        return driver.findElement(By.cssSelector("input[value='Transfer']"));
    }
}
