package tests;

import static base.TestBase.driver;
import static base.TestBase.initialization;
import static org.testng.Assert.assertTrue;
import static pages.JenkinsPage.jenkinsPageVerification;
import static util.TestUtil.seleniumEasy;

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

public class JenkinsPageTests {
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

	@Test(priority = 2)
	public void jenkinsPageVerifications() {
		driver.get(seleniumEasy);
		HomePage.jenkins.click();
		assertTrue(jenkinsPageVerification());
		assertTrue(JenkinsPage.commentsPageVerification());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}