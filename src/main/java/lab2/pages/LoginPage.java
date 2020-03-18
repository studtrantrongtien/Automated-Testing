package lab2.pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lab2.driverutils.WaitAction;

public class LoginPage extends PageObject{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//*[@id=\"email\"]")
	private WebElement email;
	
	
	@FindBy(xpath= "//*[@id=\"pass\"]")
	private WebElement pass;
	
	@FindBy(xpath="//*[@id=\"navItem_100048777852751\"]/a/div")
	private WebElement username;
	
	@FindBy(xpath="//*[@id=\"header_block\"]/span/div/div[1]/div[2]/span")
	private WebElement faildMsg;
	
	@FindBy(xpath="//*[@id=\"pageLoginAnchor\"]")
	private WebElement dropdownLogout;
	
	// //*[@id=\"js_c\"]/div/div/ul/li[9]/a
	@FindBy(linkText = "Log Out")
	private WebElement logoutLink;
	
	
	
	public void login(String _email, String _pass) {
		email.clear();
		email.sendKeys(_email);
		pass.clear();
		pass.sendKeys(_pass);
		pass.submit();
	}
	
	WaitAction waitAction;
	
	public boolean checkLogin() {
		List<WebElement> test = driver.findElements(By.xpath("//*[@id=\\\"navItem_100048777852751\\\"]/a/div"));
		if(test.size() > 0 ) return true;
		return false;
	}
	
	public void verifyIfLoginSuccess(String correctText) {
		System.out.println(username.getText());
		assertEquals(correctText, username.getText());
	}
	
	
	public void verifyIfLoginFailed(String correctText) {
		System.out.println(faildMsg.getText());
		assertEquals(correctText, faildMsg.getText());
	}
	
	public void login() {
		
	}

	public void logout() {
		try {
			if(dropdownLogout.isDisplayed()) {
				dropdownLogout.click();
				waitForElementToAppear(logoutLink);
				System.out.println("dropdownLogout is available");
				if(logoutLink.isDisplayed()) {
					System.out.println("Logout is available");
					logoutLink.click();
				}
			}
		}catch(NoSuchElementException ex) {
			System.out.println("Logout is not available");
		}
	}
}
