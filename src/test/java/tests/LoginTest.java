package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Preconditions {

    public static final String EMPTY_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMTY_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void loginWithEmptyUsernameTest(){

        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyUserName);
        Assert.assertEquals(loginPage.getErrorMessage(), EMPTY_USERNAME_ERROR);
    }

    @Test
    public void loginWithEmptyPasswordTest(){

        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMessage(), EMTY_PASSWORD_ERROR);
    }

    @Test
    public void loginWithoutPageFactory(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        addButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }

    @Test
    public void loginPageFactory(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = loginPageFactory.getAddButton();
        addButton.click();
        WebElement deleteButton = loginPageFactory.getDeleteButton();
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }
}