package lab2;


import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import lab2.driverutils.DriverManager;
import lab2.pages.LoginPage;

public class TestLab2 {
	static WebDriver webDriver;
	static LoginPage login;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		webDriver = new DriverManager().setupDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        login = new LoginPage(webDriver);
	}

	
	@Test
	public void testLoginFailed() {
		if(login.checkLogin()) {
			login.logout();
		}
		webDriver.get("https://www.facebook.com/login.php");
		login.login("trongtien.tran.18400", "d296841789fae3b7bb8");
		login.verifyIfLoginFailed("Log in as Trongtien Tran");
	}
	
	@Test
	public void testLogin() {
		webDriver.get("https://www.facebook.com/login.php");
		login.login("trongtien.tran.18400", "53230eb89891d8ebe75c0d296841789fae3b7bb8");
		login.verifyIfLoginSuccess("Trongtien Tran");	
	}
	
	@AfterClass
    public static void shutdownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
