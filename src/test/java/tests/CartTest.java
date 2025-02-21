package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static tests.Preconditions.userWithPassordAndUserName;

public class CartTest extends BaseTest{

    public Object[][] productsAndPrices() {
        return new Object[][]{
                {SAUCE_LABS_BACKPACK, "$29.99"},
                {SAUCE_LABS_BOLT_T_SHIRT, "$15.99"},
                {SAUCE_LABS_BIKE_LIGHT, "$9.99"},
                {SAUCE_LABS_FLEECE_JACKET, "$49.99"},
                {SAUCE_LABS_ONESIE, "$7.99"}

        };
    }

    @Test
    public void checkProductPriceInCartTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(userWithPassordAndUserName)
                .addProductToCard(SAUCE_LABS_BACKPACK);
        cartPage.openPage(CART_PAGE_URL);
        //Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK), "put number");

    }

    @Test
    public void removeItemFromCartTest() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(userWithPassordAndUserName)
                .addProductToCard(SAUCE_LABS_BACKPACK);
        cartPage.openCartPage(CART_PAGE_URL);
        cartPage.removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertFalse(cartPage.isProductDisplayed(SAUCE_LABS_BACKPACK));
    }
}
