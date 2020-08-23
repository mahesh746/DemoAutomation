package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static base.TestBase.driver;

public class BasicCheckboxDemo {

	@FindBy(xpath = "//*[@id=\\\"at-cv-lightbox-content\\\"]/div[2]")
	public static WebElement yesNoPopup;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")
	public static WebElement yesNoPopup_NO;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[1]")
	public static WebElement yesNoPopup_YES;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a")
	public static WebElement inputForms;
	
	@FindBy(xpath = "//a[contains(text(),'Checkbox Demo')]")
	public static WebElement checkboxDemo;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div[2]/div[1]/label/input")
	public static WebElement singleCheckbox;

	@FindBy(xpath="//*[@id=\"txtAge\"]")
	public static WebElement singleCheckboxClicked;
	
	@FindBy(xpath = "//*[@id=\"check1\"]")
	public static WebElement checkUncheckButton;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input")
	public static WebElement optionOne;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input")
	public static WebElement optionTwo;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input")
	public static WebElement optionThree;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input")
	public static WebElement optionFour;
	
	@SuppressWarnings("deprecation")
	private static WebDriverWait wait = new WebDriverWait(driver, 30);

	public BasicCheckboxDemo() {
		PageFactory.initElements(driver, this);
	}

	public String validateBasicCheckboxDemoTitle() {
		return driver.getTitle();
	}

	public static boolean basicCheckboxDemoVerification() {
		wait.until(ExpectedConditions.elementToBeClickable(singleCheckbox));
		return singleCheckbox.isDisplayed();
	}

	public static String singleCheckboxDemo() {
		System.out.println("Inside singleCheckboxDemo");
		inputForms.click();
		checkboxDemo.click();
		wait.until(ExpectedConditions.elementToBeClickable(singleCheckbox));
		singleCheckbox.click();
		System.out.println("Single Check Box Clicked");
		String result = singleCheckboxClicked.getAttribute("innerText");
		System.out.println("singleCheckboxDemo returning : " + singleCheckboxClicked.getAttribute("innerText"));
		return result;
	}

	public static boolean multipleCheckboxDemo() {
		System.out.println("Inside multipleCheckboxDemo");
		inputForms.click();
		checkboxDemo.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkUncheckButton));
		
		optionOne.click();
		optionTwo.click();
		optionThree.click();
		optionFour.click();
		
		System.out.println("Inside multipleCheckboxDemo - Clicked CheckAll");
		System.out.println(optionOne.isSelected()+ " " + optionTwo.isSelected()
		+ " " + optionThree.isSelected() +" " + optionFour.isSelected() + " "+ checkUncheckButton.isEnabled());
		
		if (checkUncheckButton.isEnabled()) {
			System.out.println("Inside multipleCheckboxDem - returning True");
			return true;
		} else {
			System.out.println("Inside multipleCheckboxDem - returning False");
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