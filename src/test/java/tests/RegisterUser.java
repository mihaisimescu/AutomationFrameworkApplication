package tests;

import actions.Register;
import org.testng.annotations.Test;
import utils.BaseTest;

public class RegisterUser extends BaseTest {

    private Register register = null;

    @Test
    public void registerUser(){

        register = new Register(driver);

        register.clickRegisterButton();
    }
}
