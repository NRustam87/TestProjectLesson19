package pages;

import entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.xpath("//input[@placeholder='Username']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@placeholder='Password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@data-test='login-button']");
    public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage login(User user){

        driver.findElement(USERNAME_INPUT).sendKeys(user.getUsername());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassowrd());
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductPage(driver);
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));

        return this;
    }
}
