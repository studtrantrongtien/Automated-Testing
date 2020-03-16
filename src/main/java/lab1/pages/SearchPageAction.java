package lab1.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
public class SearchPageAction {
	@FindBy(xpath = "//input[@title='Поиск']")
    WebElement searchInput;
	// //*[@id="rso"]/div[2]/div[1]/div/div[1]/a/h3
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")
    List<WebElement> listResultSearch;
    
    public SearchPageAction(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void searchText(String textToSearch) {
        searchInput.sendKeys(textToSearch);
        searchInput.submit();
    }

    public void verifyFirstSuggestion(String correctText) {
        assertEquals(correctText, listResultSearch.get(0).getText());
    }
}
