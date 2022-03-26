package taskAmazon;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.Driver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class stepDef {

Page page=new Page();

       @Given("go to amazon and validate")
    public void goToAmazonAndValidate() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    page.amazonLogo();

    }

    @Then("sign in")
    public void signIn() {
    page.signInText();
    page.mailInbox();
    page.continueButton();
    page.passwordInbox();
    page.signInButton();
    }

    @Then("search {string}")
    public void search(String product) throws AWTException {
           page.searchInbox(product);

    }

    @Then("select S{int} and add price textfile")
    public void selectSAndAddPriceTextfile(int model) throws IOException {
        page.S22();
        page.searchResults();
        page.pricesWhole();
        File f=new File("src\\test\\java\\taskAmazon\\prices");
        FileWriter fw=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(fw);

        List<WebElement> prices = Driver.getDriver().findElements(page.pricesWhole);
        for (int i = 0; i < prices.size(); i++) {
            bw.write(prices.get(i).getText()+"$\n");
        }
       // bw.newLine();
        //bw.write("www.softwareteastingblog.in");
        bw.close();
    }

       @Then("add to shoping list and validate")
    public void addToShopingListAndValidate() throws InterruptedException {
        page.S22click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)", "Add to List");
        //WebDriverWait w = new WebDriverWait(Driver.getDriver(),7);
        //w.until(ExpectedConditions.visibilityOfElementLocated(page.addToList));
        Thread.sleep(3000);
        page.addToList();
        page.viewList();
        page.validateS22InList();
    }


    @Then("delete product from list and control this")
    public void deleteProductFromListAndControlThis() throws InterruptedException {
        page.deleteFromList();
        Thread.sleep(3000);
        page.shopingListİtems();

    }
}

