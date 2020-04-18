package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestUtil;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver browser;

    public static void initialization(){
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }
}
