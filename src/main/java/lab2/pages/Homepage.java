package lab2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends PageObject{
	@FindBy(xpath= "//*[@id=\"uniMenu\"]/ul/li[1]/a")
	private WebElement menuUniversity;
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	
	
	

}