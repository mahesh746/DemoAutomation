package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.TestBase.browser;

public class PricingPage{

    @FindBy(xpath = "//b[contains(text(),'Price per month')]")
    public static WebElement pricePerMonth;

    private  static WebDriverWait wait  =new WebDriverWait(browser, 30);

    public PricingPage(){
        PageFactory.initElements(browser, this);
    }

    public String validatePricingPageTitle(){
        return browser.getTitle();
    }

    public static boolean pricePageVerification(){
        return pricePerMonth.isDisplayed();
    }
}
