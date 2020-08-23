package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static base.TestBase.driver;

public class JSAlertBoxDemo {

		@FindBy(xpath = "//*[@id=\\\"at-cv-lightbox-content\\\"]/div[2]")
		public static WebElement yesNoPopup;

		@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")
		public static WebElement yesNoPopup_NO;

		@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[1]")
		public static WebElement yesNoPopup_YES;

		@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]/a")
		public static WebElement alertsAndModals;

		@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]/ul/li[5]/a")
		public static WebElement jsalertsPage;

		@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/button")
		public static WebElement jsalert;

		@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")
		public static WebElement jsConfirm;

		@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button")
		public static WebElement jsPrompt;
		
		@SuppressWarnings("deprecation")
		private static WebDriverWait wait = new WebDriverWait(driver, 30);

		public JSAlertBoxDemo() {
			PageFactory.initElements(driver, this);
		}

		public String validateJSAlertBoxDemoTitle() {
			return driver.getTitle();
		}

		public static boolean JSAlertBoxDemoPageVerification() {
			wait.until(ExpectedConditions.elementToBeClickable(jsalert));
			return jsalert.isDisplayed();
		}

		public static boolean dismissAlertbox() throws InterruptedException {
			System.out.println("Inside dismissAlertbox");
			alertsAndModals.click();
			jsalertsPage.click();
			wait.until(ExpectedConditions.elementToBeClickable(jsalert));
			System.out.println("Found JS Alert, clicking it");
			Thread.sleep(40000);
			System.out.println("Inside dismissAlertbox wait ended.");
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("myAlertFunction()");
			Thread.sleep(10000);
		    driver.switchTo().alert().dismiss();
			System.out.println("Alert box dismissed");
			if (null != ExpectedConditions.visibilityOf(jsalert)) {
				return true;
			} else {
				return false;
			}
		}
		
		public static boolean dismissConfirmBox() throws InterruptedException {
			System.out.println("Inside dismissConfirmBox");
			alertsAndModals.click();
			jsalertsPage.click();
			wait.until(ExpectedConditions.elementToBeClickable(jsConfirm));
			System.out.println("Found JS Confirmbox, clicking it");
			Thread.sleep(40000);
			System.out.println("Inside dismissConfirmBox wait ended.");
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("myConfirmFunction()");
			Thread.sleep(10000);
			driver.switchTo().alert().accept();
			System.out.println("Confirm box dismissed");
			if (null != ExpectedConditions.visibilityOf(jsConfirm)) {
				return true;
			} else {
				return false;
			}
		}
		
		public static boolean dismissPromptBox() throws InterruptedException {
			alertsAndModals.click();
			jsalertsPage.click();
			System.out.println("Inside dismissPromptBox");
			wait.until(ExpectedConditions.elementToBeClickable(jsPrompt));
			Thread.sleep(40000);
			System.out.println("Inside dismissConfirmBox wait ended.");
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("myPromptFunction()");
			System.out.println("Found JS Prompt, clicking it");
			driver.switchTo().alert().sendKeys("Hey User");
			Thread.sleep(10000);
			driver.switchTo().alert().accept();
			System.out.println("Prompt box dismissed");
			if (null != ExpectedConditions.visibilityOf(jsPrompt)) {
				return true;
			} else {
				return false;
			}
		}

		public static void handlePopup() {
			if (yesNoPopup.isDisplayed()) {
				yesNoPopup_NO.click();
			} else {
				System.out.println("No popup found, so proceed.");
			}
		}
	}