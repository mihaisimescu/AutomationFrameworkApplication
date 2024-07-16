package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public WebElement getUserNotFound(){
        return driver.findElement(By.cssSelector("p[class='error']"));
    }

    public WebElement getForgotLoginLink(){
        return driver.findElement(By.cssSelector("a[href='lookup.htm']"));
    }

    public WebElement loginError(){
        return driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
    }

    public WebElement logout(){
        return driver.findElement(By.cssSelector("a[href='logout.htm']"));
    }
}
