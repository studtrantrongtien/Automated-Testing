package lab2.pages;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import lab2.driverutils.WaitAction;

public class LoginPage extends PageObject{
	public LoginPage(WebDriver driver) {
		super(driver);
		waitAction = new WaitAction(driver);
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
	
	@FindBy(xpath="//*[@id=\"js_8\"]/div/div/ul/li[9]")
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
		try {
			if(username.isDisplayed()) {
				System.out.println("Already Login");
				return true;
			}
		}catch(NoSuchElementException ex) {
			System.out.println("Login first");
		}
		return false;
	}
	
	public void verifyIfLoginSuccess(String correctText) {
		System.out.println(username.getText());
		assertEquals(correctText, username.getText());
	}
	
	
	public void verifyIfLoginFailed(String correctText) {
		if(checkLogin()) {
			logout();
			assertEquals(1, 1);
		}
		System.out.println(faildMsg.getText());
		assertEquals(correctText, faildMsg.getText());
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
	
	private void waitForElementToAppear(WebElement e) {
        waitAction.waitUntilCondition((ExpectedCondition<Boolean>)
                ex -> e.isEnabled());
    }
	
}
