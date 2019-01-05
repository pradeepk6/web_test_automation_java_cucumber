package mycompany.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.LineItem;
import model.Product;
import mycompany.pageobjects.*;
import mycompany.pageobjects.CategoryPages.DataStorageAndMemoryPage;
import mycompany.pageobjects.CategoryPages.UsbStickPage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class Buy_product_steps {

    @Managed
    WebDriver driver;

    Properties properties;

    HomePage homePage;
    DataStorageAndMemoryPage dataStorageAndMemoryPage;
    UsbStickPage usbStickPage;
    ProductPage productPage;
    HeaderPage headerPage;
    BasketSumnmaryPage basketSumnmaryPage;
    CookiePage cookiePage;

    Product product;

    @Before
    public void setupTestData() {
    }

    @Given("^user navigates to a product page$")
    public void user_navigates_to_a_product_page() throws Exception {

        homePage = new HomePage(driver);
        homePage.open();
        homePage.topMenuPage.goto_dataStorageAndMemory();

        dataStorageAndMemoryPage = new DataStorageAndMemoryPage(driver);
        dataStorageAndMemoryPage.clickUsbSticks();

        usbStickPage = new UsbStickPage(driver);
        usbStickPage.clickFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        String name = productPage.getProductName();
        System.out.println("product name from product page : " + name);
        product = new Product();
        product.setName(productPage.getProductName());

    }

    @When("^user adds one unit of the product to the basket$")
    public void user_adds_one_unit_of_the_product_to_the_basket() throws Exception {
        productPage.addToBasket();
    }

    @When("^navigates to basket summary page$")
    public void navigates_to_basket_summary_page() throws Exception {
        headerPage.gotoMyBasket();
        basketSumnmaryPage = new BasketSumnmaryPage(driver);
    }

    @Then("^user should see the product added to basket$")
    public void user_should_see_the_product_added_to_the_basket() throws Exception {
        LineItem firstLineItemInBasket = basketSumnmaryPage.getFirstLineItem();
        assertEquals(product.getName(),  firstLineItemInBasket.getProduct().getName());
    }

    @When("^user adds two units of the product to the basket$")
    public void user_adds_two_units_of_the_product_to_the_basket() throws Exception {
        productPage.addUnits("2");
        productPage.addToBasket();
    }

    @Then("^user should see appropriate units of the product added to basket$")
    public void user_should_see_appropriate_units_of_the_product_added_to_basket() throws Exception {
        LineItem firstLineItemInBasket = basketSumnmaryPage.getFirstLineItem();
        assertEquals(product.getName(),  firstLineItemInBasket.getProduct().getName());
        assertEquals(2,  firstLineItemInBasket.getQuantity());
    }

}
