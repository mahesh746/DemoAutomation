package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static base.TestBase.driver;

public class BasicRadioButtonDemo {

	@FindBy(xpath = "//*[@id=\\\"at-cv-lightbox-content\\\"]/div[2]")
	public static WebElement yesNoPopup;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")
	public static WebElement yesNoPopup_NO;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[1]")
	public static WebElement yesNoPopup_YES;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a")
	public static WebElement inputForms;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[3]/a")
	public static WebElement radioButtonDemo;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input")
	public static WebElement singleRadioMale;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input")
	public static WebElement singleRadioFemale;

	@FindBy(xpath = "//*[@id=\"buttoncheck\"]")
	public static WebElement singleRadioButtonCheck;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]")
	public static WebElement singleRadioButtonCheckMessage;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input")
	public static WebElement groupRadioMale;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[2]/input")
	public static WebElement groupRadioFemale;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[1]/input")
	public static WebElement age0to5;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[2]/input")
	public static WebElement age5to15;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[3]/input")
	public static WebElement age15to20;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")
	public static WebElement getGroupRadioValue;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")
	public static WebElement getGroupRadioMessage;

	@SuppressWarnings("deprecation")
	private static WebDriverWait wait = new WebDriverWait(driver, 30);

	public BasicRadioButtonDemo() {
		PageFactory.initElements(driver, this);
	}

	public String validateBasicRadioButtonDemoTitle() {
		return driver.getTitle();
	}

	public static boolean basicBasicRadioButtonDemoVerification() {
		wait.until(ExpectedConditions.elementToBeClickable(singleRadioButtonCheck));
		return singleRadioButtonCheck.isDisplayed();
	}

	public static String singleRadioButtonDemo() {
		System.out.println("Inside singleRadioButtonDemo");
		inputForms.click();
		radioButtonDemo.click();
		wait.until(ExpectedConditions.elementToBeClickable(singleRadioButtonCheck));
		singleRadioMale.click();
		System.out.println("Male Radio Clicked");
		singleRadioButtonCheck.click();
		String result = singleRadioButtonCheckMessage.getAttribute("innerText");
		System.out.println("Check for Single Radio button : " + result);
		return result;
	}

	public static boolean groupRadioButtonDemo() {
		System.out.println("Inside groupRadioButtonDemo");
		inputForms.click();
		radioButtonDemo.click();
		wait.until(ExpectedConditions.elementToBeClickable(getGroupRadioValue));
		groupRadioFemale.click();
		System.out.println("Female Radio Clicked");
		age5to15.click();
		System.out.println("Age 5 to 15 Clicked");
		getGroupRadioValue.click();
		String result = getGroupRadioMessage.getAttribute("innerText");
		if (result.contains("Sex : Female") || result.contains(" Age group: 15 - 50")) {
			System.out.println("Inside Group Radio Button Demo - Returning True");
			return true;
		} else {
			System.out.println("Inside Group Radio Button Demo - Returning False");
			return false;
		}
	}

	public static void handlePopup() {
		System.out.println("Inside handlePopup");
		if (yesNoPopup.isDisplayed()) {
			System.out.println("Popup found, so closing.");
			yesNoPopup_NO.click();
		} else {
			System.out.println("No popup found, so proceed.");
		}
	}
}
