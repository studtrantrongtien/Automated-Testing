package lab4.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject{
	
	@FindBy(className = "userContentWrapper")
	private WebElement parrent;
	
	private WebElement textPost;
	
	@FindBy(linkText = "Like")
	private WebElement clickLike;
	
	private WebElement checkLike;

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public void clickLike() {
		clickLike.click();
	}
	
	public void verifyLike() {
		checkLike = parrent.findElement(By.linkText("Tran Trong Tien"));
		clickLike.click();
		assertEquals("Tran Trong Tien", checkLike.getText());
	}
	
	public void verifyTestPost(String text) {
		textPost = parrent.findElement(By.tagName("p"));
		assertEquals(text, textPost.getText());
	}
}
