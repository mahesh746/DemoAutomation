package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static base.TestBase.driver;

import java.util.List;

public class BasicSelectDropdownDemo {

	@FindBy(xpath = "//*[@id=\\\"at-cv-lightbox-content\\\"]/div[2]")
	public static WebElement yesNoPopup;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")
	public static WebElement yesNoPopup_NO;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[1]")
	public static WebElement yesNoPopup_YES;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a")
	public static WebElement inputForms;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[4]/a")
	public static WebElement selectDropDownListPage;

	@FindBy(xpath = "//*[@id=\"select-demo\"]")
	public static WebElement selectDay;

	@FindBy(className = "selected-value")
	public static WebElement selectDayResult;

	@FindBy(xpath = "//*[@id=\"multi-select\"]")
	public static WebElement multiSelect;

	@FindBy(xpath = "//*[@id=\"printMe\"]")
	public static WebElement findSelected;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")
	public static WebElement findSelectedResult;
	
	@FindBy(xpath = "//*[@id=\"printAll\"]")
	public static WebElement findAllSelected;
	
	@SuppressWarnings("deprecation")
	private static WebDriverWait wait = new WebDriverWait(driver, 30);

	public BasicSelectDropdownDemo() {
		PageFactory.initElements(driver, this);
	}

	public String validateBasicSelectDropdownDemoTitle() {
		return driver.getTitle();
	}

	public static boolean BasicSelectDropdownDemoVerification() {
		wait.until(ExpectedConditions.elementToBeClickable(selectDay));
		return selectDay.isDisplayed();
	}

	public static String selectListDemo() throws InterruptedException {
		inputForms.click();
		selectDropDownListPage.click();
		Thread.sleep(20000);
		Select select = new Select(selectDay);
		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		Thread.sleep(10000);
		Select sele = new Select(selectDay);
		sele.selectByIndex(6);

		System.out.println(selectDayResult.getAttribute("innerText") + " "
				+ driver.getPageSource().contains("Day selected :- Friday"));
		return (selectDayResult.getAttribute("innerText"));
	}

	
	public static String multiSelectListDemo() throws InterruptedException {
		inputForms.click();
		selectDropDownListPage.click();
		Thread.sleep(20000);
		Select select = new Select(multiSelect);
		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		Thread.sleep(10000);
		Select sele = new Select(multiSelect);
		sele.selectByIndex(6);
		findSelected.click();
		Thread.sleep(10000);
		System.out.println(findSelectedResult.getAttribute("innerText") + " "
				+ driver.getPageSource().contains("First selected option is : Pennsylvania"));
		return (findSelectedResult.getAttribute("innerText"));
	}
	 
	public static String multiSelectList() throws InterruptedException {
		inputForms.click();
		selectDropDownListPage.click();
		Thread.sleep(20000);
		Select select = new Select(multiSelect);
		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		Thread.sleep(10000);
		Select sele = new Select(multiSelect);
		sele.selectByIndex(1);
		sele.deselectAll();
		sele.selectByIndex(2);
		sele.deselectAll();
		sele.selectByIndex(3);
		sele.deselectAll();
		sele.selectByIndex(4);
		findAllSelected.click();
		Thread.sleep(10000);
		
		WebElement select1 = driver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[2]"));
        WebElement select2 = driver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[3]"));
		Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(select1).click(select2).build().perform();
        
	    findAllSelected.click();
		Thread.sleep(10000);	       
				       
		System.out.println(findSelectedResult.getAttribute("innerText"));
		return (findSelectedResult.getAttribute("innerText"));
	}

	public static void handlePopup() {
		if (yesNoPopup.isDisplayed()) {
			yesNoPopup_NO.click();
		} else {
			System.out.println("No popup found, so proceed.");
		}
	}
}