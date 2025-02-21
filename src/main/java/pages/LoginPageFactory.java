package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageFactory extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userNameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passorwInput;

    @FindBy(xpath = "//input[@data-test='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;
    //public static final By USERNAME_INPUT = By.xpath("//input[@placeholder='Username']");
    //public static final By PASSWORD_INPUT = By.xpath("//input[@placeholder='Password']");
    //public static final By LOGIN_BUTTON = By.xpath("//input[@data-test='login-button']");
    //public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){

        userNameInput.sendKeys(username);
        passorwInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}
