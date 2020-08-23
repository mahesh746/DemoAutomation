package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static base.TestBase.driver;

public class JunitPage {

	@FindBy(xpath = "//*[@id=\"block-easy-breadcrumb-easy-breadcrumb\"]/div/a[2]")
	public static WebElement jUnitPageReload;

	@SuppressWarnings("deprecation")
	private static WebDriverWait wait = new WebDriverWait(driver, 30);

	public JunitPage(){
	        PageFactory.initElements(driver, this);
	    }

	public String validateJunitPageTitle() {
		return driver.getTitle();
	}

	public static boolean junitPageVerification() {
		wait.until(ExpectedConditions.elementToBeClickable(jUnitPageReload));
		return jUnitPageReload.isDisplayed();
	}

}
