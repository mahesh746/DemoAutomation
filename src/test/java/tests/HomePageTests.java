package tests;

import org.testng.annotations.*;
import pages.APIPage;
import pages.HomePage;
import pages.PricingPage;
import pages.SearchResultPage;

import static base.TestBase.browser;
import static base.TestBase.initialization;
import static org.testng.Assert.assertTrue;
import static pages.APIPage.apiPageVerification;
import static pages.HomePage.*;
import static pages.PricingPage.pricePageVerification;
import static pages.SearchResultPage.notFoundAlertVerification;
import static pages.SearchResultPage.weatherResultVerification;
import static util.TestUtil.invalidCityName;
import static util.TestUtil.openweathermap;
import static util.TestUtil.validCityName;

public class HomePageTests {
    HomePage homePage;
    SearchResultPage searchResultPage;
    APIPage apiPage;
    PricingPage pricingPage;

    @BeforeClass
    public void setUp(){
        initialization();
        homePage = new HomePage();
        searchResultPage = new SearchResultPage();
        apiPage = new APIPage();
        pricingPage = new PricingPage();
    }


    @Test(priority = 1)
    public void labelsAndLinksVerification(){
        browser.get(openweathermap);
        topBarVerification();
        navBarVerification();
        searchVerification();
        chartTabVerification();
    }

    @Test(priority = 2)
    public void invalidCityNameVerification(){
        browser.get(openweathermap);
        enterTextInSearchBox(invalidCityName);
        clickSearchButton();
        assertTrue(notFoundAlertVerification());
    }

    @Test(priority = 3)
    public void validCityNameVerification(){
        browser.get(openweathermap);
        enterTextInSearchBox(validCityName);
        clickSearchButton();
        assertTrue(weatherResultVerification());
    }

    @Test(priority = 4)
    public void apiAndPricingVerification(){
        browser.get(openweathermap);
        clickAPIInNavBar();
        assertTrue(apiPageVerification());
        clickPricingInNavBar();
        assertTrue(pricePageVerification());
    }

    @AfterClass
    public void tearDown() {
        browser.quit();
    }


}
