package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static base.TestBase.driver;

public class AjaxCallTest {

	@FindBy(xpath = "//*[@id=\\\"at-cv-lightbox-content\\\"]/div[2]")
	public static WebElement yesNoPopup;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")
	public static WebElement yesNoPopup_NO;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[1]")
	public static WebElement yesNoPopup_YES;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a")
	public static WebElement inputForms;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[6]/a")
	public static WebElement ajaxForm;

	@FindBy(xpath = "//*[@id=\"title\"]")
	public static WebElement name;

	@FindBy(xpath = "//*[@id=\"description\"]")
	public static WebElement comment;

	@FindBy(xpath = "//*[@id=\"btn-submit\"]")
	public static WebElement ajaxFormSubmit;

	@SuppressWarnings("deprecation")
	private static WebDriverWait wait = new WebDriverWait(driver, 30);

	public AjaxCallTest() {
		PageFactory.initElements(driver, this);
	}

	public String validateAjaxCallTestTitle() {
		return driver.getTitle();
	}

	public static boolean AjaxCallTestVerification() {
		wait.until(ExpectedConditions.elementToBeClickable(ajaxFormSubmit));
		return ajaxFormSubmit.isDisplayed();
	}

	public static String AjaxCallTesting() {
		String result = "";
		inputForms.click();
		ajaxForm.click();
		name.sendKeys("Hello Name!");
		System.out.println("Hello Name!");
		comment.sendKeys("Hello Comment!");
		System.out.println("Hello Comment!");
		ajaxFormSubmit.click();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			result = driver.findElement(By.xpath("//*[@id=\"submit-control\"]")).getAttribute("innerText");
			System.out.println(result+""+driver.findElement(By.xpath("//*[@id=\"submit-control\"]")).getAttribute("name")+
					driver.findElement(By.xpath("//*[@id=\"submit-control\"]")).getAttribute("value"));
		}
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