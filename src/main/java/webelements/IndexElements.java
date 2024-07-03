package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexElements {

    private WebDriver driver = null;

    public IndexElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement username(){
        return driver.findElement(By.xpath("//input[@name='username']"));
    }

    public WebElement password(){
        return driver.findElement(By.xpath("//input[@name='password']"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//input[@type='submit']"));
    }

    public WebElement getUser(){
        return driver.findElement(By.xpath("//p[@class='smallText']"));
    }

    public WebElement getInvalidUserMsg(){
        return driver.findElement(By.xpath("//p[@class='error']"));
    }

}