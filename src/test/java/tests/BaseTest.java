package tests;

import constans.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest implements IConstants, ITestConstants {

    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;

    CartPage cartPage;
    LoginPageFactory loginPageFactory;

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
    }

    public void initPages(){
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);

        loginPageFactory = new LoginPageFactory(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void endTest(){
        driver.quit();
    }
}
