package tests;

import static base.TestBase.driver;
import static base.TestBase.initialization;
import static org.testng.Assert.assertEquals;
import static util.TestUtil.seleniumEasy;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AjaxCallTest;
import pages.BasicCheckboxDemo;
import pages.BasicRadioButtonDemo;
import pages.BasicSelectDropdownDemo;
import pages.HomePage;
import pages.JSAlertBoxDemo;
import pages.JenkinsPage;
import pages.JunitPage;
import pages.SimpleFormDemo;

public class TwoInputTest {
	HomePage homePage;
	JunitPage junitPage;
	JenkinsPage jenkinsPage;
	SimpleFormDemo simpleFormDemo;
	BasicCheckboxDemo basicCheckboxDemo;
	BasicRadioButtonDemo basicRadioButtonDemo;
	AjaxCallTest ajaxCallTest;
	JSAlertBoxDemo jsAlertBoxDemo;
	BasicSelectDropdownDemo basicSelectDropdownDemo;

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
		junitPage = new JunitPage();
		jenkinsPage = new JenkinsPage();
		simpleFormDemo = new SimpleFormDemo();
		basicCheckboxDemo = new BasicCheckboxDemo();
		basicRadioButtonDemo = new BasicRadioButtonDemo();
		ajaxCallTest = new AjaxCallTest();
		jsAlertBoxDemo = new JSAlertBoxDemo();
		basicSelectDropdownDemo = new BasicSelectDropdownDemo();
	}

	@Test(priority = 4)
	public void startDemoTwoInputs() {
		driver.get(seleniumEasy);
		HomePage.demoWebsite.click();
		try {
			Thread.sleep(20000);
			// DemoWebsiteTestPage.handlePopup();
			driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-content\"]/div[2]"));
			SimpleFormDemo.yesNoPopup_NO.click();
			assertEquals(SimpleFormDemo.twoInputField(), "Total a + b = 70");
			Thread.sleep(10000);
		} catch (Exception ge) {
			System.out.println("No popup found, so proceed.");
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}