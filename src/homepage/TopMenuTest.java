package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    /*create method with name "selectMenu" it has one parameter name "menu" of type string.
    This method should click on the menu whatever name is passed as parameter
     */
    public void selectMenu(String menu, By by) {
        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }
    //Computer Menu
    @Test
    public void verifyUserCanNavigateToComputerMenu(){
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        selectMenu("Computers", By.xpath("//h1[contains(text(),'Computers')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Computers')]"), "Computers");
    }
    //Electronics Menu
    @Test
    public void verifyUserCanNavigateToElectronicsMenu(){
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        selectMenu("Electronics",By.xpath("//h1[contains(text(),'Electronics')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Electronics')]"), "Electronics");
    }
    //Apparel Menu
    @Test
    public void verifyUserCanNavigateToApparelMenu(){
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        //selectMenu("Apparel",By.xpath("//h1[contains(text(),'Apparel')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Apparel')]"), "Apparel");
    }
    //Digital downloads
    @Test
    public void verifyUserCanNavigateToDigitalDownloadsMenu(){
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        selectMenu("Digital downloads",By.xpath("//h1[contains(text(),'Digital downloads')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Digital downloads')]"), "Digital downloads");
    }
    //Books menu
    @Test
    public void verifyUserCanNavigateToBooksMenu(){
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));
        selectMenu("Books",By.xpath("//h1[contains(text(),'Books')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Books')]"), "Books");
    }
    //Jewelry Menu
    @Test
    public void verifyUserCanNavigateToJewelryMenu(){
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        selectMenu("Jewelry",By.xpath("//h1[contains(text(),'Jewelry')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Jewelry')]"), "Jewelry");
    }
    //Gift Cards Menu
    @Test
    public void verifyUserCanNavigateToGiftCardsMenu(){
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        selectMenu("Gift Cards",By.xpath("//h1[contains(text(),'Gift Cards')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Gift Cards')]"), "Gift Cards");
    }
     @After
    public void tearDown(){
        closeBrowser();
    }

}
