package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestLoanElements {

    private WebDriver driver = null;

    public RequestLoanElements(WebDriver driver){
        this.driver= driver;
    }

    public WebElement getRequestLoanTitle(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Apply for a Loan')]"));
    }

}
