package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.TestUtil;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver = null;

    public static void initialization(){
    	System.setProperty("webdriver.chrome.driver", "C:\\DemoAutomation\\chromedriver_win32.exe");
        WebDriverManager.chromedriver().browserVersion("84.0.4147.135").setup();
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("start-maximized");
		 * options.addArguments("enable-automation");
		 * options.addArguments("--no-sandbox");
		 * options.addArguments("--disable-infobars");
		 * options.addArguments("--disable-dev-shm-usage");
		 * options.addArguments("--disable-browser-side-navigation");
		 * options.addArguments("--disable-gpu"); driver = new ChromeDriver(options);
		 */ 
        driver = new ChromeDriver();
        driver.get("https://www.google.com/"); 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }
}
