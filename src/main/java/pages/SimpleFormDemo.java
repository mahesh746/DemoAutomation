package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static base.TestBase.driver;

public class SimpleFormDemo {

	@FindBy(xpath = "//*[@id=\\\"at-cv-lightbox-content\\\"]/div[2]")
	public static WebElement yesNoPopup;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")
	public static WebElement yesNoPopup_NO;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[1]")
	public static WebElement yesNoPopup_YES;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a")
	public static WebElement inputForms;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[1]/a")
	public static WebElement simpleFormDemo;

	@FindBy(xpath = "//*[@id=\"user-message\"]")
	public static WebElement enterMessage;

	@FindBy(xpath = "//*[@id=\"get-input\"]/button")
	public static WebElement showMessage;

	@FindBy(xpath = "//*[@id=\"sum1\"]")
	public static WebElement enterValue1;
	
	@FindBy(xpath = "//*[@id=\"sum2\"]")
	public static WebElement enterValue2;
	
	@FindBy(xpath = "//*[@id=\"gettotal\"]/button")
	public static WebElement getTotal;
	
	@SuppressWarnings("deprecation")
	private static WebDriverWait wait = new WebDriverWait(driver, 30);

	public SimpleFormDemo() {
		PageFactory.initElements(driver, this);
	}

	public String validateJenkinsPageTitle() {
		return driver.getTitle();
	}

	public static boolean simpleFormDemoPageVerification() {
		wait.until(ExpectedConditions.elementToBeClickable(showMessage));
		return showMessage.isDisplayed();
	}

	public static String singleInputField() {
		inputForms.click();
		simpleFormDemo.click();
		wait.until(ExpectedConditions.elementToBeClickable(showMessage));
		enterMessage.sendKeys("Hello!");
		showMessage.click();
		String result = "Your Message: " + driver.findElement(By.xpath("//*[@id=\"display\"]")).getText();
		return result;
	}

	public static String twoInputField() {
		inputForms.click();
		simpleFormDemo.click();
		wait.until(ExpectedConditions.elementToBeClickable(getTotal));
		enterValue1.sendKeys("40");
		enterValue1.sendKeys("30");
		getTotal.click();
		String result = "Total a + b = " + driver.findElement(By.xpath("//*[@id=\"displayvalue\"]")).getAttribute("innerText");
		return result;
	}
	
	public static void handlePopup() {
		if (yesNoPopup.isDisplayed()) {
			yesNoPopup_NO.click();
		} else {
			System.out.println("No popup found, so proceed.");
		}
	}
}
