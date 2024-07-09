package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LookupElements {

    private WebDriver driver = null;

    public LookupElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement firstName(){
        return driver.findElement(By.cssSelector("input[id='firstName']"));
    }

    public WebElement lastName(){
        return driver.findElement(By.cssSelector("input[id='lastName']"));
    }

    public WebElement address(){
        return driver.findElement(By.cssSelector("input[id='address.street']"));
    }

    public WebElement city(){
        return driver.findElement(By.cssSelector("input[id='address.city']"));
    }

    public WebElement state(){
        return driver.findElement(By.cssSelector("input[id='address.state']"));
    }

    public WebElement zipCode(){
        return driver.findElement(By.cssSelector("input[id='address.zipCode']"));
    }

    public WebElement socialSecurityNumber(){
        return driver.findElement(By.cssSelector("input[id='ssn']"));
    }

    public WebElement submitButton(){
        return driver.findElement(By.xpath("//input[@value='Find My Login Info']"));
    }

    public WebElement getUsername(){
        return driver.findElement(By.xpath("//p[2]/b[1]"));
    }

    public WebElement getPassword(){
        return driver.findElement(By.xpath("//p[2]/b[2]"));
    }

}
