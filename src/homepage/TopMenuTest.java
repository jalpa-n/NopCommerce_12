package homepage;

import browserTesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    String baseUrl ="https://demo.nopcommerce.com/";
    String expectedmessage;


    public void selectMenu(String menu){

        expectedmessage = menu;
    }

    // clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));


    @Before

    public void setUp() {

        openBrowser(baseUrl);

    }
    @Test

    public void verifyPageNavigation() {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        selectMenu("Computers");
        Assert.assertEquals("User does not navigate to Computers page ", expectedmessage, actualMessage);

    }

}


