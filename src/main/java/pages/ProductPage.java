package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends HeaderPage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s'/ancestor::*[@class=\"inventory_item\"]";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";
    private static final String CART_ITEM_CONTAINER = "//*[@class='cart_item']";

    public void addProductToCard(String productName){

        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }
    public void addProductToCarts(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
    }

    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public boolean isProductDisplayed(String productName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }
}
