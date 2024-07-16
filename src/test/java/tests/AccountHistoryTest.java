package tests;

import actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigurationLoader;

public class AccountHistoryTest extends BaseTest {

    private Index login = null;
    ConfigurationLoader configurationLoader = null;
    private Register register = null;
    private AccountsActivity accountsActivity = null;
    AccountOverview accountOverview = null;
    private static boolean registerAccount = false;
    private Overview overview = null;

    @Test
    public void accountHistory(){

        login = new Index(driver);
        register = new Register(driver);
        accountsActivity = new AccountsActivity(driver);
        accountOverview = new AccountOverview(driver);
        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        //Login user
        loginUser();

        //Check if the user was registered
        if(registerAccount){

            //Go to accounts overview
            overview = new Overview(driver);
            overview.clickAccountsOverview();

        }else{
            // The user is already created, click account
            accountOverview.clickDefaultAccount();

        }


        //Store account id
        String account = accountsActivity.getAccountId();

        //Check if there no transactions done
        if(accountsActivity.noTransactionsFound()){

            Assert.assertEquals(accountsActivity.getNoTransactionsFoundText(), configurationLoader.getProperty("transactions"));
        }
        else {
            Assert.assertEquals(accountsActivity.getTransaction(),configurationLoader.getProperty("transaction"));
        }
    }

    private void loginUser(){

        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        String username = configurationLoader.getProperty("username");
        String password = configurationLoader.getProperty("password");

        //Enter login data and click button
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        //Check if the account not created
        if(login.errorLoginText()){

            //Register new account and login
            register.registerNewUser();
            login.enterUserName(username);
            login.enterPassword(password);
            login.clickLoginButton();

            registerAccount = true;
        }

    }

}
