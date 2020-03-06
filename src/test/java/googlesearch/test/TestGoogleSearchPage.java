package googlesearch.test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import driverutils.DriverManager;
import pages.SearchPageAction;

public class TestGoogleSearchPage{
	
	static WebDriver webDriver;

    @BeforeClass
    public static void setupForTest() {
        webDriver = new DriverManager().setupDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    
	@Test
    public void testWordSelenium() {
        webDriver.get("https://www.google.com/");
        SearchPageAction searchPage = new SearchPageAction(webDriver);
        searchPage.searchText("selenium");
        searchPage.verifyFirstSuggestion("Selenium");
    }
	
	@Test
    public void testWordYandex() {
        webDriver.get("https://www.google.com/");
        SearchPageAction searchPage = new SearchPageAction(webDriver);
        searchPage.searchText("yandex");
        searchPage.verifyFirstSuggestion("Яндекс");
    }
	
	@AfterClass
    public static void shutdownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
