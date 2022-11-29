package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
        //Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        //Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.product-list div.item-grid div.item-box:nth-child(3) div.product-item div.details h2.product-title > a:nth-child(1)"));
        //Verify the text “Nokia Lumia 1020”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"),"Nokia Lumia 1020");
        //verify price
        verifyExpectedAndActual(By.xpath("//span[@id='price-value-20']"),"$349.00");
        //change quantity and add to cart
        driver.findElement(By.cssSelector("#product_enteredQuantity_20")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        clickOnElement(By.cssSelector("#add-to-cart-button-20"));
        // green bar message
        verifyExpectedAndActual(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),"The product has been added to your shopping cart");
        //close green bar
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        Thread.sleep(3000);

        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

        //verify message shopping cart
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //Verify the quantity is 2
        Thread.sleep(3000);
        verifyMessage("(2)",getTextFromElement(By.xpath("//span[contains(text(),'(2)')]")));

        // Verify the Total $698.00
        verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]"),"$698.00");

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //  Verify the Text “Welcome, Please Sign In!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");


        //Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //Verify the text “Register”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Register')]"),"Register");

        //Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Manan");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Shah");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"), "17");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"), "05");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"), "1984");
        sendTextToElement(By.xpath("//input[@id='Email']"), "1223test@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "Password1");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Password1");
        //Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        // Verify the message “Your registration completed”
        verifyExpectedAndActual(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");
        //Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //Verify the text “Shopping card”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //Fill the Mandatory fields
        Select select = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
        select.selectByVisibleText("United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"), "34, Luton Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA8 9HU");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "020456783");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        // Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        // Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        //Select “Visa” From Select credit card dropdown
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='CreditCardType']")));
        select1.selectByVisibleText("Visa");
        // Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Manan Shah");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "08");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "678");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        Thread.sleep(3000);
        // Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Credit Card')]"),"Credit Card");
        //Verify “Shipping Method” is “2nd Day Air”
        verifyExpectedAndActual(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"),"2nd Day Air");
        //Verify Total is “$698.00”
        verifyExpectedAndActual(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"),"$698.00");
        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        Thread.sleep(3000);
        //Verify the Text “Thank You”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
        //  Verify the message “Your order has been successfully processed!”
        verifyExpectedAndActual(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        // Verify the text "Welcome to our store".
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");
        //Click on logout link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
