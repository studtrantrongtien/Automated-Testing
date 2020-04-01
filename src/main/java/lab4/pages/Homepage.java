package lab4.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends PageObject{
	@FindBy(name = "q")											// OK
	private WebElement searchBar;
	
	@FindBy(linkText =  "FACEBOOK")
	private WebElement resultSearch;
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	public void searchText(String text) {
		searchBar.click();
		searchBar.sendKeys(text);
		searchBar.submit();
	}
	
	public void verifySearch(String text) {
		waitForElementToAppear(resultSearch);
		assertEquals(text, resultSearch.getText());
	}
}