package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.TestBase.browser;

public class APIPage{

    @FindBy(xpath = "//body[@class='body-orange']/main[@class='wrapper']/div[@class='container']/div[2]/div[1]/a[1]")
    public static WebElement apiDocForCurrentWeatherData;

    private  static WebDriverWait wait  =new WebDriverWait(browser, 30);

    public APIPage(){
        PageFactory.initElements(browser, this);
    }

    public String validateAPIPageTitle(){
        return browser.getTitle();
    }

    public static boolean apiPageVerification(){
        wait.until(ExpectedConditions.elementToBeClickable(apiDocForCurrentWeatherData));
        return apiDocForCurrentWeatherData.isDisplayed();
    }

}
