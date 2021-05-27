package appreal;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Apparel extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test

    public void verifyUserShouldNavigateToAccessoriesPageSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        mouseHoverAndClickElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]"));
        Thread.sleep(3000);
        verifyPageNavigation(By.xpath("//h1[contains(text(),'Accessories')]"), "Accessories");

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        Thread.sleep(5000);
        verifyUserShouldNavigateToAccessoriesPageSuccessfully();

        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Ray Ban Aviator Sunglasses')]"));
        Thread.sleep(5000);
        verifyPageNavigation(By.xpath("//h1[contains(text(),'Ray Ban Aviator Sunglasses')]"), "Ray Ban Aviator Sunglasses");
        verifyPageNavigation(By.xpath("//span[contains(@id,'price-value-')]"), "$25.00");

        Thread.sleep(5000);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@id,'product_enteredQuantity')]"));
        quantity.clear();
        quantity.sendKeys("2");
        clickOnElement(By.xpath("//button[contains(@id,'add-to-cart-button-')]"));


        verifyPageNavigation(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));


        Thread.sleep(5000);
        mouseHoverToElement(By.xpath("//li[@id='topcartlink']"));
        mouseHoverAndClickElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        verifyPageNavigation(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        verifyPageNavigation(By.xpath("//li[@id='topcartlink']"), "Shopping cart (2)");
        verifyPageNavigation(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"), "$50.00");

        Thread.sleep(5000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        verifyPageNavigation(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        verifyPageNavigation(By.xpath("//h1[contains(text(),'Register')]"), "Register");

        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "jalpa");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "ganatra");
        sendTextToElement(By.xpath("//input[@id='Email']"), "jalpatel.23@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "12345678");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "12345678");
        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[@id='register-button']"));
        Thread.sleep(5000);
        verifyPageNavigation(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");
        Thread.sleep(2000);
        verifyPageNavigation(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));


        Thread.sleep(5000);
        selectByValueDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "133");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "AMD");
        sendTextToElement(By.xpath("//input[contains(@id,'BillingNewAddress_Address1')]"), "127");
        Thread.sleep(5000);

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "380012");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07568");

        Thread.sleep(5000);

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.xpath("//div[@class='method-name']//input[@id='shippingoption_2']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        clickOnElement(By.xpath("//input[contains(@id,'paymentmethod_1')]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        Thread.sleep(5000);
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "J ganatra");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4929 0000 0000 6");

        Thread.sleep(5000);
        selectByValueDropDown(By.xpath("//select[@id='ExpireMonth']"), "9");
        selectByValueDropDown(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));


        Thread.sleep(5000);
        verifyPageNavigation(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");
        verifyPageNavigation(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "2nd Day Ai");
        verifyPageNavigation(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"), "$50.00");

        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyPageNavigation(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");
        verifyPageNavigation(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyPageNavigation(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        verifyCurrentUrl(baseUrl);

    }

    @After

    public void tearBrowser() {

        closeBrowser();
    }


}

