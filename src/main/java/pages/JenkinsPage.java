package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static base.TestBase.driver;

public class JenkinsPage {

	@FindBy(xpath = "//*[@id=\"block-easy-breadcrumb-easy-breadcrumb\"]/div/a[2]")
	public static WebElement jenkinsPageReload;

	@FindBy(xpath = "//*[@id=\"node-232\"]/footer/ul/li[2]/a")
	public static WebElement twoComments;
	
	@SuppressWarnings("deprecation")
	private static WebDriverWait wait = new WebDriverWait(driver, 30);

	public JenkinsPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateJenkinsPageTitle() {
		return driver.getTitle();
	}

	public static boolean jenkinsPageVerification() {
		wait.until(ExpectedConditions.elementToBeClickable(jenkinsPageReload));
		return jenkinsPageReload.isDisplayed();
	}

	public static boolean commentsPageVerification() {
		twoComments.click();
		wait.until(ExpectedConditions.urlContains("#comments"));
		return true;
	}
}