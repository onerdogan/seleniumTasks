package taskAmazon;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class Page {
    //  private WebDriver driver = Driver.getDriver();
    //  public void getUrl(final String url) {       driver.navigate().to(url);}

    public Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //By sign_in_tab = By.xpath("//span[@class='ssrcss-qgttmg-AccountText eki2hvo4']");
    By amazonLogo = By.id("nav-logo-sprites");
    By signIntext = By.id("nav-link-accountList-nav-line-1");
    By mailInbox = By.id("ap_email");
    By continueButton = By.id("continue");
    By password = By.id("ap_password");
    By signinButton = By.id("signInSubmit");
    By searchInbox = By.id("twotabsearchtextbox");
    By S22 = By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]");
    By searchResults = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    By pricesWhole = By.xpath("//span[@class='a-price-whole']");
    By addToList=By.id("add-to-wishlist-button-submit");
    By viewList=By.linkText("View Your List");
    By secondS22=By.id("itemName_I3VV2SNPTTFJKL");
    By deleteButtonInList=By.xpath("(//*[@name='submit.deleteItem'])[1]");
    By seachInboxShopingList=By.id("itemSearchTextInput");
    By shopingListİtems=By.xpath("//h2[@class='a-size-base']");

    public void amazonLogo() {
        Driver.getDriver().findElement(amazonLogo).isDisplayed();
    }

    public void signInText() {
        Driver.getDriver().findElement(signIntext).click();
    }

    public void mailInbox() {
        Driver.getDriver().findElement(mailInbox).sendKeys(ConfigReader.getProperty("mail"));
    }

    public void continueButton() {
        Driver.getDriver().findElement(continueButton).click();
    }

    public void passwordInbox() {
        Driver.getDriver().findElement(password).sendKeys(ConfigReader.getProperty("password"));
    }

    public void signInButton() {
        Driver.getDriver().findElement(signinButton).click();
    }

    public void searchInbox(String product) throws AWTException {
        Driver.getDriver().findElement(searchInbox).sendKeys(product);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER); //press enter key
        robot.keyRelease(KeyEvent.VK_ENTER); //release enter key
    }

    public void S22() {
      String firstS22=Driver.getDriver().findElement(S22).getText();
        Driver.getDriver().findElement(S22).getText().contains("22");
    }
    public  void secondS22(){
        String viewListS22=Driver.getDriver().findElement(secondS22).getText();

    }
    public void validateS22InList(){

        String viewListS22=Driver.getDriver().findElement(By.partialLinkText("S22")).getText();

        Assert.assertTrue(viewListS22.contains("S22"));
    }

    public void searchResults() {

        List<WebElement> elementNames = Driver.getDriver().findElements(searchResults);
        for (int i = 0; i < elementNames.size(); i++) {
            System.out.println("search resuls" +
                    elementNames.get(i).getText());
        }
    }
        public String pricesWhole() {

            List<WebElement> prices = Driver.getDriver().findElements(pricesWhole);
            for (int i = 0; i < prices.size(); i++) {
                System.out.println(prices.get(i).getText());
            }
            return null;
        }
        public void S22click(){
        Driver.getDriver().findElement(S22).click();
        }
    public void addToList(){
        Driver.getDriver().findElement(addToList).click();
    }
    public  void viewList(){
        Driver.getDriver().findElement(viewList).click();
    }
    public void deleteFromList(){
        Driver.getDriver().findElement(deleteButtonInList).click();
    }

    public  void shopingListİtems(){
        List<WebElement> items=Driver.getDriver().findElements(shopingListİtems);
        for (int i=0;i<items.size();i++){
            System.out.println(items.get(i).getText());
            Assert.assertTrue(items.contains("S22"));
        }
    }




            //  public void verify_yourAcnt(){
            //      String Account = driver.findElement(your_acct).getText();
            //      Assert.assertEquals( "Your account", Account )

    }
