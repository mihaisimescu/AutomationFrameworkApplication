package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountElements {

    private WebDriver driver = null;

    public OpenAccountElements(WebDriver driver){
        this.driver= driver;
    }

    public WebElement submitButton(){
        return driver.findElement(By.cssSelector("input[value='Open New Account']"));
    }

    public WebElement accountDropdown(){
        return driver.findElement(By.cssSelector("select[id='type']"));
    }

    public WebElement fromAccountDropdown(){
        return driver.findElement(By.cssSelector("select[id='fromAccountId']"));
    }

    public WebElement openAccountResult(){
        return driver.findElement(By.xpath("//h1[contains(text(), 'Account Opened!')]"));
    }


}
