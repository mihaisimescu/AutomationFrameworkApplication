package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateProfileElements {

    private WebDriver driver = null;

    public UpdateProfileElements(WebDriver driver){
        this.driver= driver;
    }

    public WebElement getUpdateContactInfo(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Update Profile')]"));
    }

    public WebElement firstName(){
        return driver.findElement(By.cssSelector("input[id='customer.firstName']"));
    }

    public WebElement lastName(){
        return driver.findElement(By.cssSelector("input[id='customer.lastName']"));
    }

    public WebElement address(){
        return driver.findElement(By.cssSelector("input[id='customer.address.street']"));
    }

    public WebElement city(){
        return driver.findElement(By.cssSelector("input[id='customer.address.city']"));
    }

    public WebElement state(){
        return driver.findElement(By.cssSelector("input[id='customer.address.state']"));
    }

    public WebElement zipCode(){
        return driver.findElement(By.cssSelector("input[id='customer.address.zipCode']"));
    }

    public WebElement phoneNumber(){
        return driver.findElement(By.cssSelector("input[id='customer.phoneNumber']"));
    }

    public WebElement updateProfile(){
        return driver.findElement(By.cssSelector("input[class='button']"));
    }

    public WebElement getUpdateContactInfoResult(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Profile Updated')]"));
    }
}
