package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindTransactionsElements {

    private WebDriver driver = null;

    public FindTransactionsElements(WebDriver driver){
        this.driver= driver;
    }

    public WebElement getFindtransactionsTitle(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Find Transactions')]"));
    }
}
