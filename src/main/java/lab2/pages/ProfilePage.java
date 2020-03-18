package lab2.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject{
	
	@FindBy(xpath = "//*[@id=\"jumper_852105600_S:_I100048777852751:105536697748925\"]")
	private WebElement parrent;
	
	@FindBy(linkText = "Born on 1 January 1997")
	private WebElement born;
	
	@FindBy(linkText = "Like")
	private WebElement clickLike;
	
	@FindBy(xpath="//*[@id=\"u_0_30\"]/div/div[2]/div[1]/div/div[1]/a/span[2]/span/span")
	private WebElement checkLike;

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public void clickLike() {
		clickLike.click();
	}
	
	public void verifyLike() {
		checkLike = parrent.findElement(By.linkText("Trongtien Tran"));
		clickLike.click();
		assertEquals("Trongtien Tran", checkLike.getText());
	}
	
	public void verifyBornDay(String textBorn) {
		waitForElementToAppear(born);
		System.out.println(born.getText());
		assertEquals(textBorn, born.getText());
	}
}
