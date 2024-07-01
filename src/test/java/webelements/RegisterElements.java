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
}
