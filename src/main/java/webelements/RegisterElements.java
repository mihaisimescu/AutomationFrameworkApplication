package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterElements {

    private WebDriver driver = null;

    public RegisterElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getRegisterButton(){
        return driver.findElement(By.xpath("//a[@href='register.htm']"));
    }

    public WebElement firstName(){
        return driver.findElement(By.xpath("//input[@id='customer.firstName']"));
    }

    public WebElement lastName(){
        return driver.findElement(By.xpath("//input[@id='customer.lastName']"));
    }

    public WebElement address(){
        return driver.findElement(By.xpath("//input[@id='customer.address.street']"));
    }

    public WebElement city(){
        return driver.findElement(By.xpath("//input[@id='customer.address.city']"));
    }

    public WebElement state(){
        return driver.findElement(By.xpath("//input[@id='customer.address.state']"));
    }

    public WebElement zipCode(){
        return driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
    }

    public WebElement phone(){
        return driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
    }

    public WebElement socialSecurityNumber(){
        return driver.findElement(By.xpath("//input[@id='customer.ssn']"));
    }

    public WebElement username(){
        return driver.findElement(By.xpath("//input[@id='customer.username']"));
    }

    public WebElement password(){
        return driver.findElement(By.xpath("//input[@id='customer.password']"));
    }

    public WebElement confirmPassword(){
        return driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
    }

    public WebElement submitButton(){
        return driver.findElement(By.xpath("//input[@value='Register']"));
    }

    public WebElement registerSuccessful(){
        return driver.findElement(By.xpath("//h1[@class='title']"));
    }





}
