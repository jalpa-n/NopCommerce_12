package Electronics;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElectronicsTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        Actions action = new Actions(driver);
        WebElement electronics = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellPhones = driver.findElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        Thread.sleep(5000);
        action.moveToElement(electronics).build().perform();
        action.moveToElement(cellPhones).click().build().perform();

        String expectedCellPhonesText = "Cell phones";
        String actualCellPhoneText = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Assert.assertEquals("User is not on cell pones page ", expectedCellPhonesText,actualCellPhoneText);
    }

    @Test

    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        Actions action = new Actions(driver);
        WebElement electronics = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellPhones = driver.findElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        Thread.sleep(5000);
        action.moveToElement(electronics).build().perform();
        action.moveToElement(cellPhones).click().build().perform();

        String expectedCellPhonesText = "Cell phones";
        String actualCellPhoneText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("User is not on cell pones page ", expectedCellPhonesText, actualCellPhoneText);

        Thread.sleep(5000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(5000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[@href='/nokia-lumia-1020']"));

        String expectedNokiaPageText = "Nokia Lumia 1020";
        String actualNokiaPageText = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("User is not able to navigate to Nokia Lumia page ", expectedNokiaPageText, actualNokiaPageText);

        Thread.sleep(5000);
        String expectedMobilePrice = "$349.00";
        String actualMobilePrice = getTextFromElement(By.xpath("//div[@class='product-price']//span[@id='price-value-20']"));
        Assert.assertEquals("User is not able to see correct price ", expectedMobilePrice, actualMobilePrice);

        WebElement quantity = driver.findElement(By.xpath("//input[contains(@id,'product_enteredQuantity')]"));
        quantity.clear();
        quantity.sendKeys("2");

        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[contains(@id,'add-to-cart-button-')]"));

        String expectedPopUpText = "The product has been added to your shopping cart";
        String actualPopUpText = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("User is not able to add products to cart  ", expectedPopUpText, actualPopUpText);

        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        action.moveToElement(shoppingCart).build().perform();

        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        String expectedShoppingCartText = "Shopping cart";
        String actualShoppingCartText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("User is not navigated to Shopping cart  ", expectedShoppingCartText, actualShoppingCartText);

        String expectedQuantity = "Shopping cart (2)";
        String actualQuantity = getTextFromElement(By.xpath("//li[@id='topcartlink']"));
        Assert.assertEquals("The quantity not added ", expectedQuantity, actualQuantity);
        Thread.sleep(5000);

        String expectedPrice = "$698.00";
        String actualPrice = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("The price calculation is not correct ", expectedPrice, actualPrice);
        Thread.sleep(5000);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        String expectedSignInText = "Welcome, Please Sign In!";
        String actualSignInText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("User not able to navigate to sign in page ", expectedSignInText, actualSignInText);
        Thread.sleep(5000);

        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        String expectedRegisterText = "Register";
        String actualRegisterText = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("User not able to register", expectedRegisterText, actualRegisterText);

        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "jalpa");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Ganatra");
        sendTextToElement(By.xpath("//input[@id='Email']"), "jal23@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "12345678");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "12345678");
        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[@id='register-button']"));

        String expectedRegistrationText = "Your registration completed";
        String actualRegistrationText = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("User not able to register successfully", expectedRegistrationText, actualRegistrationText);

        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        String expectedShoppingText = "Shopping cart";
        String actualShoppingText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("User not able navigate to shopping cart successfully", expectedShoppingText, actualShoppingText);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));


        Thread.sleep(5000);


        selectByValueDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "133");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Ahmedabad");
        sendTextToElement(By.xpath("//input[contains(@id,'BillingNewAddress_Address1')]"), "16 B H Colony");
        Thread.sleep(5000);

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "380012");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0777888092");

        Thread.sleep(5000);

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.xpath("//div[@class='method-name']//input[@id='shippingoption_2']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        clickOnElement(By.xpath("//input[contains(@id,'paymentmethod_1')]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        Thread.sleep(5000);
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "j Ganatra");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4929 0000 0000 6");

        Thread.sleep(5000);
        selectByValueDropDown(By.xpath("//select[@id='ExpireMonth']"), "9");
        selectByValueDropDown(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Payment method is not clear ", expectedPaymentMethod, actualPaymentMethod);

        Thread.sleep(5000);
        String expectedShippingMethod = "2nd Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals("Shipping method is not clear ", expectedShippingMethod, actualShippingMethod);

        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("Total doesn't verified ", expectedTotal, actualTotal);

        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        String expectedThankYouText = "Thank you";
        String actualThankYouText = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Thank you text not verified", expectedThankYouText, actualThankYouText);
        Thread.sleep(5000);

        String expectedSuccessfulText = "Your order has been successfully processed!";
        String actualSuccessfulText = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Not successfully proceed ", expectedSuccessfulText, actualSuccessfulText);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        Thread.sleep(5000);

        String expectedWelcomeText = "Welcome to our store";
        String actualWelcomeText = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome text not verified", expectedWelcomeText, actualWelcomeText);

        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        verifyCurrentUrl(baseUrl);


    }

    @After
    public void tearBrowser(){
        closeBrowser();
    }

    }
