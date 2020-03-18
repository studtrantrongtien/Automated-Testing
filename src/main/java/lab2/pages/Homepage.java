package lab2.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends PageObject{
	// //*[@id="js_0"]/div/div/div[1]/div[2]
	// //*[@id="js_2"]
	// //*[@id="js_2"]/form
	// //*[@id="js_2"]/form/button
	@FindBy(xpath = "//*[@id=\"js_0\"]/div/div/div[1]/div[2]")	// OK
	private WebElement topBar;
	
	// //*[@id="u_a_2"]
	@FindBy(name = "q")											// OK
	private WebElement searchBar;
	
	@FindBy(linkText =  "Peter the Great St.Petersburg Polytechnic University")
	private WebElement resultSearch;
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	public void searchText(String text) {
		topBar.click();
		waitForElementToAppear(searchBar);
		searchBar.sendKeys(text);
		searchBar.submit();
	}
	
	public void verifySearch(String text) {
		waitForElementToAppear(resultSearch);
		assertEquals(text, resultSearch.getText());
	}
}