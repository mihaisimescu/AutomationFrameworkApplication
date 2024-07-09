package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewElements {

    private WebDriver driver = null;

    public OverviewElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement logout(){
        return driver.findElement(By.cssSelector("a[href='logout.htm']"));
    }

    public WebElement logoutCheckSuccessful(){
        return driver.findElement(By.cssSelector("h2"));
    }

    public WebElement getBillPay(){
        return driver.findElement(By.cssSelector("a[href='billpay.htm']"));
    }

    public WebElement openNewAccount(){
        return driver.findElement(By.cssSelector("a[href='openaccount.htm']"));
    }

    public WebElement accountsOverview(){
        return driver.findElement(By.cssSelector("a[href='overview.htm']"));
    }

    public WebElement transferFunds(){
        return driver.findElement(By.cssSelector("a[href='transfer.htm']"));
    }

    public WebElement findTransactions(){
        return driver.findElement(By.cssSelector("a[href='findtrans.htm']"));
    }

    public WebElement updateContact(){
        return driver.findElement(By.cssSelector("a[href='updateprofile.htm']"));
    }

    public WebElement requestLoan(){
        return driver.findElement(By.cssSelector("a[href='requestloan.htm']"));
    }


}
