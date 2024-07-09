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
}
