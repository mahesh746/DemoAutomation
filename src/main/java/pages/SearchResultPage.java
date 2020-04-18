package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends TestBase {

    @FindBy(xpath = "//div[@class='alert alert-warning']")
    public static WebElement notFoundAlert;

    @FindBy(xpath = "//span[@class='badge badge-info']")
    public static WebElement temperatureBadge;


    private static WebDriverWait wait  =new WebDriverWait(browser, 30);

    public SearchResultPage(){
        PageFactory.initElements(browser, this);
    }

    public String validateSearchResultPageTitle(){
        return browser.getTitle();
    }

    public static boolean notFoundAlertVerification(){
        wait.until(ExpectedConditions.visibilityOf(notFoundAlert));
        return notFoundAlert.isDisplayed();
    }

    public static boolean weatherResultVerification(){
        wait.until(ExpectedConditions.elementToBeClickable(temperatureBadge));
        return temperatureBadge.isDisplayed();
    }
}
