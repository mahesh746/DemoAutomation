package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[@id='metric']")
    public static WebElement celsius;

    @FindBy(xpath = "//span[@id='imperial']")
    public static WebElement fahrenheit;

    @FindBy(xpath = "//a[@class='first-child']")
    public static WebElement supportCenter;

    @FindBy(xpath = "//a[@id='nav-search']")
    public static WebElement weatherInYourCity;

    @FindBy(xpath = "//a[@class='pull-right'][contains(text(),'Sign In')]")
    public static WebElement signIn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    public static WebElement signUp;

    @FindBy(xpath = "//a[@class='nav__link bg-hover-color'][contains(text(),'Weather')]")
    public static WebElement weatherInNavbar;

    @FindBy(xpath = "//a[contains(text(),'Maps')]")
    public static WebElement mapsInNavbar;

    @FindBy(xpath = "//a[contains(text(),'Guide')]")
    public static WebElement guideInNavbar;

    @FindBy(xpath = "//a[@class='nav__link bg-hover-color'][contains(text(),'API')]")
    public static WebElement apiInNavbar;

    @FindBy(xpath = "//a[contains(text(),'Pricing')]")
    public static WebElement pricingInNavbar;

    @FindBy(xpath = "//a[contains(text(),'Marketplace')]")
    public static WebElement marketplaceInNavbar;

    @FindBy(xpath = "//a[contains(text(),'Partners')]")
    public static WebElement partnersInNavbar;

    @FindBy(xpath = "//a[contains(text(),'Stations')]")
    public static WebElement stationsInNavbar;

    @FindBy(xpath = "//a[contains(text(),'Widgets')]")
    public static WebElement widgetsInNavbar;

    @FindBy(xpath = "//a[contains(text(),'Blog')]")
    public static WebElement blogInNavbar;

    @FindBy(xpath = "//div[@class='form-group search-cities__block']//input[@id='q']")
    public static WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"searchform\"]/button")
    public static WebElement searchButton;

    @FindBy(xpath = "//button[@class='btn search-cities__lnk']")
    public static WebElement currentLocation;

    @FindBy(xpath = "//a[@id='tab-main']")
    public static WebElement mainTab;

    @FindBy(xpath = "//a[@id='tab-daily']")
    public static WebElement dailyTab;

    @FindBy(xpath = "//a[@id='tab-hourly']")
    public static WebElement hourlyTab;

    @FindBy(xpath = "//a[@id='tab-chart']")
    public static WebElement chartTab;

    @FindBy(xpath = "//a[@id='tab-map']")
    public static WebElement mapTab;

    @FindBy(xpath = "//button[@class='weather-widget__link']")
    public static WebElement wrongData;

    @FindBy(xpath = "//a[contains(text(),'More weather in your city')]")
    public static WebElement moreWeatherInYourCity;


    private  static WebDriverWait wait  =new WebDriverWait(browser, 30);

    public HomePage(){
        PageFactory.initElements(browser, this);
    }

    public String validateHomePageTitle(){
        return browser.getTitle();
    }

    public static void enterTextInSearchBox(String text){
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.sendKeys(text);
    }

    public static void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public static void topBarVerification(){
        celsius.isDisplayed();
        fahrenheit.isDisplayed();
        supportCenter.isDisplayed();
        weatherInYourCity.isDisplayed();
        signIn.isDisplayed();
        signUp.isDisplayed();
    }

    public static void navBarVerification(){
        weatherInNavbar.isDisplayed();
        mapsInNavbar.isDisplayed();
        guideInNavbar.isDisplayed();
        apiInNavbar.isDisplayed();
        pricingInNavbar.isDisplayed();
        marketplaceInNavbar.isDisplayed();
        partnersInNavbar.isDisplayed();
        stationsInNavbar.isDisplayed();
        widgetsInNavbar.isDisplayed();
        blogInNavbar.isDisplayed();
    }

    public static void searchVerification(){
        searchBox.isDisplayed();
        searchButton.isDisplayed();
        currentLocation.isDisplayed();
    }

    public static void chartTabVerification(){
        mainTab.isDisplayed();
        dailyTab.isDisplayed();
        dailyTab.click();
        hourlyTab.isDisplayed();
        hourlyTab.click();
        chartTab.isDisplayed();
        chartTab.click();
        mapTab.isDisplayed();
        mainTab.click();
        wrongData.isDisplayed();
        moreWeatherInYourCity.isDisplayed();
    }

    public static void clickAPIInNavBar(){
        apiInNavbar.isDisplayed();
        apiInNavbar.click();
    }

    public static void clickPricingInNavBar(){
        pricingInNavbar.isDisplayed();
        pricingInNavbar.click();
    }

}
