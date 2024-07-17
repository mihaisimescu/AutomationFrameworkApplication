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

        initTest("Account History Test");

        login = new Index(driver);
        register = new Register(driver);
        accountsActivity = new AccountsActivity(driver);
        accountOverview = new AccountOverview(driver);
        configurationLoader = new ConfigurationLoader("src/test/resources/properties/loginUserData.properties");

        //Log in
        login.loginUser();

        //Check if the account not created
        if(login.errorLoginText()) {
            //Register new user
            register = new Register(driver);
            register.registerNewUser();

            registerAccount = true;
        }

        //Check if login is successful, by checking if logout link is present
        Assert.assertTrue(login.checkLogout());

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

}
