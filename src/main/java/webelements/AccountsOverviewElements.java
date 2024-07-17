package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountsOverviewElements {

    private WebDriver driver = null;

    public AccountsOverviewElements(WebDriver driver){
        this.driver= driver;
    }

    public WebElement getAccountsOverviewTitle(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
    }

    public WebElement defaultAccountId(){
        return  driver.findElement(By.xpath("//*[@id='accountTable']/tbody/tr[1]/td[1]/a"));
    }

    public WebElement transactionDetails(){
        return driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[2]/a"));
    }

    public Boolean transactionHistory(String transactionName){

        WebElement tableElement =  driver.findElement(By.cssSelector("table[id='transactionTable']"));
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

        //Iterate through each row
        for(WebElement rowElement: rows){
            List<WebElement> cells = rowElement.findElements(By.tagName("td"));

            //Iterate through each cell in the row
            for(WebElement cellElement : cells){
                String cellData = cellElement.getText();
                //Check if cell data matches the transaction
                if(cellData.equals(transactionName)) {
                    return true;
                }
            }
        }
        return false;
    }
}


