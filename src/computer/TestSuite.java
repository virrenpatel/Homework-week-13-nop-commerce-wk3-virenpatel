package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //Click on Computer Menu
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        // Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        sortBy.selectByVisibleText("Name: Z to A");
        //Verify the Product will arrange in Descending order.
        verifyExpectedAndActual(By.xpath("//option[contains(text(),'Name: Z to A')]"), "Name: Z to A");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer Menu
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        // Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //Select Sort By position "Name: A to Z"
        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        sortBy.selectByVisibleText("Name: A to Z");
        Thread.sleep(3000);
        //Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //Verify the text "Build your own computer"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");
        Thread.sleep(1000);
        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Select sortProcessor = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_1']")));
        sortProcessor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        // Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");

        // Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("#product_attribute_3_7"));

        // Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("#product_attribute_4_9"));

        Thread.sleep(3000);
        // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));

        Thread.sleep(1000);
        //Verify the price "$1,475.00"
        verifyExpectedAndActual(By.id("price-value-1"), "$1,475.00");

        //Click on "ADD TO CARD" Button.
        clickOnElement(By.cssSelector("#add-to-cart-button-1"));

        //verify product added to cart
        verifyExpectedAndActual(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),"The product has been added to your shopping cart");

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        Thread.sleep(3000);

        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

        //Verify the message "Shopping cart"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");

        // Change the Qty to "2"
        clearText(By.xpath("//input[@value='1']"));
        sendTextToElement(By.xpath("//input[@value='1']"), "2");
        //Click on "Update shopping cart"
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //Verify the Total"$2,950.00
        verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]/span[1]"),"$2,950.00");

        //click on check box and agreed terms
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //Verify the Text “Welcome, Please Sign In!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        Thread.sleep(3000);
        //Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Manan");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Shah");
        sendTextToElement(By.id("BillingNewAddress_Email"), "manans@gmail.com");
        Select country = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
        country.selectByVisibleText("United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"), "21 Luton Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA8 9HU");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0202345678");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        //Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        Select card = new Select(driver.findElement(By.xpath("//select[@id='CreditCardType']")));
        card.selectByVisibleText("Master card");
        //Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Manan Shah");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");

        Select month = new Select(driver.findElement(By.xpath("//select[@id='ExpireMonth']")));
        month.selectByVisibleText("10");

        Select year = new Select(driver.findElement(By.xpath("//select[@id='ExpireYear']")));
        year.selectByVisibleText("2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "789");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Credit Card')]"),"Credit Card");
        // Verify “Shipping Method” is “Next Day Air”
        verifyExpectedAndActual(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"),"Next Day Air");
        //Verify Total is “$2,950.00”
        verifyExpectedAndActual(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"),"$2,950.00");
        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //Verify the Text “Thank You”
        verifyExpectedAndActual(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.checkout-page.order-completed-page div.page-title > h1:nth-child(1)"),"Thank you");
        //Verify the message “Your order has been successfully processed!”
        verifyExpectedAndActual(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        // Verify the text “Welcome to our store”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");
    }
    @After
    public void tearDown() {
        closeBrowser();

    }
}