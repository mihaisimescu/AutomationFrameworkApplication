package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsOverviewElements {

    private WebDriver driver = null;

    public AccountsOverviewElements(WebDriver driver){
        this.driver= driver;
    }

    public WebElement getAccountsOverviewTitle(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
    }
}
