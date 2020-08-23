package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"block-block-28\"]/div/div[2]/ul/li[3]/a")
    public static WebElement jUnitTutorial;
	
	@FindBy(xpath = "//*[@id=\"navbar-collapse\"]/nav/ul/li[5]/a")
    public static WebElement jenkins;
	
    @FindBy(xpath = "//*[@id=\"block-block-57\"]/div/div/a")
    public static WebElement demoWebsite;

    @SuppressWarnings("deprecation")
	private  static WebDriverWait wait  =new WebDriverWait(driver, 30);

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public String validateHomePageTitle(){
        return driver.getTitle();
    }
}
