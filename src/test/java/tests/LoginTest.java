package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public static final String EMPTY_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMTY_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void loginWithEmptyUsernameTest(){

        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), EMPTY_USERNAME_ERROR);
    }

    @Test
    public void loginWithEmptyPasswordTest(){

        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessage(), EMTY_PASSWORD_ERROR);
    }

}
