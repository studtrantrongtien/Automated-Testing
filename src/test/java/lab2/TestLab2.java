package lab2;



import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import lab2.driverutils.DriverManager;
import lab2.pages.Homepage;
import lab2.pages.LoginPage;
import lab2.pages.ProfilePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLab2 {
	static WebDriver 	webDriver;
	static LoginPage 	login;
	static Homepage 	home;
	static ProfilePage  profile;
	
	public static WebDriver getDriver() {
		return webDriver;
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		webDriver = new DriverManager().setupDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        login = new LoginPage(webDriver);
        home  = new Homepage(webDriver);
        profile = new ProfilePage(webDriver);
	}

		@Category(SmokeTests.class)
		@Test
		public void testA_Login() {
			webDriver.get("https://www.facebook.com/login.php");
			login.login("tran.trongtien.54", "53230eb89891d8ebe75c0d296841789fae3b7bb8");
			login.verifyIfLoginSuccess("Tran Trong Tien");	
		}
		
		
		// Test login with wrong password
		@Category(SmokeTests.class)
		@Test
		public void testF_LoginFailed() {
			login.logout();
			webDriver.navigate().to("https://www.facebook.com/login.php");
			login.login("tran.trongtien.54", "53230eb89891d8ebe75c0d29");
			login.verifyIfLoginFailed("Log in as Tran Trong Tien");
		}
	
	
		@Test
		public void testB_HomeSearch() {
			home.searchText("facebook");
			home.verifySearch("FACEBOOK");
		}
	
		@Category(SmokeTests.class)
		@Test
		public void testC_HomeTitle() {
			webDriver.navigate().to("https://www.facebook.com");
			System.out.println(webDriver.getTitle());
			assertEquals("Facebook", webDriver.getTitle());
		}
	
		@Category(SmokeTests.class)
		@Test
		public void testD_Like() {
			webDriver.navigate().to("https://www.facebook.com/tran.trongtien.54");
			profile.clickLike();
			profile.verifyLike();
		}
		
		@Test
		public void testE_TestPost() {
			webDriver.navigate().to("https://www.facebook.com/tran.trongtien.54");
			profile.verifyTestPost("Test Post");
		}

	@AfterClass
    public static void shutdownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
