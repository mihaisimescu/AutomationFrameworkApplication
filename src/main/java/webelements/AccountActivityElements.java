package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountActivityElements {

    private WebDriver driver = null;

    public AccountActivityElements(WebDriver driver){
        this.driver= driver;
    }

    public WebElement accountId(){
        return driver.findElement(By.cssSelector("td[id='accountId'"));
    }

    public WebElement fundsSent(){
        return driver.findElement(By.xpath("//a[contains(text(),'Funds Transfer Sent')]"));
    }

}
