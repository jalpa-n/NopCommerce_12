package computer;

import homepage.TopMenuTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestSuite extends TopMenuTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before

    public void setUp() {

        openBrowser(baseUrl);

    }

    @Test

    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        verifyPageNavigation();
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        verifyPageNavigation(By.xpath("//h1[text()='Desktops']"), "Desktops");

        Select select = new Select(driver.findElement(By.id("products-orderby")));
        select.selectByVisibleText("Name: Z to A");
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='products-container']/descendant::a"));

        for (WebElement element : productList) {

            System.out.println(element.getText());

        }
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        verifyPageNavigation();
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        verifyPageNavigation(By.xpath("//h1[text()='Desktops']"), "Desktops");

        Select select1 = new Select(driver.findElement(By.id("products-orderby")));
        select1.selectByVisibleText("Name: A to Z");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        verifyPageNavigation(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");
        selectByValueDropDown(By.id("product_attribute_1"), "1");
        selectByValueDropDown(By.id("product_attribute_2"), "5");

        clickOnElement(By.xpath("//label[@for='product_attribute_3_7']"));
        clickOnElement(By.xpath("//label[@for='product_attribute_4_9']"));
        driver.findElement(By.id("product_attribute_label_5")).click();
        driver.findElement(By.id("product_attribute_5_12")).click();
        Thread.sleep(3000);
        clickOnElement(By.id("price-value-1"));
        Thread.sleep(4000);
        String expectedPrice = "$1,475.00";
        Thread.sleep(3000);
        String actualPrice = getTextFromElement(By.xpath("//span[@class='price-value-1']"));
        Assert.assertEquals("User not able to add to cart ", expectedPrice, actualPrice);
        clickOnElement(By.id("add-to-cart-button-1"));

        String expectedGreenBarMassage = "The product has been added to your shopping cart";
        Thread.sleep(3000);
        String actualGreenBarMassage = getTextFromElement(By.xpath("//p[text()='The product has been added to your ']"));
        Assert.assertEquals("The product will not added to the cart ", expectedGreenBarMassage, actualGreenBarMassage);

        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        WebElement shoppingCart = driver.findElement(By.xpath("//body/div[6]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        Actions action = new Actions(driver);
        action.moveToElement(shoppingCart).build().perform();
        Thread.sleep(3000);
        action.moveToElement(goToCart).click().build().perform();
        String expectedHeadingText = "Shopping cart";
        String actualHeadingText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("User is not on shopping cart ", expectedHeadingText, actualHeadingText);

        Thread.sleep(3000);
        WebElement quantityBox = driver.findElement(By.xpath("//input[contains(@id,'itemquantity')]"));
        quantityBox.clear();
        quantityBox.sendKeys("2");
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));

        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("User can not update shopping basket", expectedHeadingText, actualHeadingText);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));

        Thread.sleep(5000);
        String expectedText = "Welcome, Please Sign In!";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("User is not able to complete shopping ", expectedHeadingText, actualHeadingText);

        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "jalpa");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "ganatra");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "abc@gmail.com");
        selectByValueDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "133");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Amd");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "4 xyz");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "nn1");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07354621");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        clickOnElement(By.xpath("//div[@class='method-name']//input[contains(@id,'shippingoption_1')]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        Thread.sleep(5000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        Thread.sleep(5000);
        selectByValueDropDown(By.xpath("//select[@id='CreditCardType']"),"MasterCard");

        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"mrs J Ganatra");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5404 0000 0000 0001");
        selectByValueDropDown(By.xpath("//select[@id='ExpireMonth']"),"11");
        selectByValueDropDown(By.xpath("//select[@id='ExpireYear']"),"2022");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"123");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        Thread.sleep(5000);
        String expectedPaymentMethodText = "Credit Card";
        String actualPaymentMethodText = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("User payment method is wrong ",expectedPaymentMethodText,actualPaymentMethodText);
        String expectedShippingMethodText = "Next Day Air";
        String actualShippingMethodText = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals("User shipping method is wrong ",expectedShippingMethodText,actualShippingMethodText);
        Thread.sleep(5000);

        String expectedTotal1 = "$2,950.00";
        String actualTotal1 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("User Total method is wrong ",expectedTotal,actualTotal);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        String expectedFinishShoppingText = "Thank you";
        String actualFinishShoppingText = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("User not able to greeting text ",expectedFinishShoppingText,actualFinishShoppingText);

        Thread.sleep(5000);
        String expectedSuccessfulText = "Your order has been successfully processed!";
        String actualSuccessfulText = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("User not able to finish shopping successfully ",expectedSuccessfulText,actualSuccessfulText);

        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        String expectedWelcomeText = "Welcome to our store";
        String actualWelcomeText = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("User not navigate to home page ",expectedWelcomeText,actualWelcomeText);

    }


}



