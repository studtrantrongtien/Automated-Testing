package lab4.cucumberJava;


import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lab4.driverutils.DriverManager;
import lab4.pages.Homepage;
import lab4.pages.LoginPage;
import lab4.pages.ProfilePage;

public class StepDefinitions {
	static WebDriver 	webDriver 	= new DriverManager().setupDriver();
	static LoginPage 	login 		= new LoginPage(webDriver);
	static Homepage 	home 		= new Homepage(webDriver);		
	static ProfilePage  profile     = new ProfilePage(webDriver);
	
	@Given("Open login page")
	public void Open_login_page(){
		webDriver.get("https://www.facebook.com/login.php");
		System.out.println("Login page");
	}
	
	@Given("Logout")
	public void Logout(){
		login.logout();
		webDriver.navigate().to("https://www.facebook.com/login.php");
	}
	
	@Given("Open home page")
	public void Open_home_page(){
		webDriver.navigate().to("https://www.facebook.com");
	}
	
	@Given("Open profile page")
	public void Open_profile_page(){
		webDriver.navigate().to("https://www.facebook.com/tran.trongtien.54");
	}

	@When("^Try to login with Username: \'(.*)\' and Password: \'(.*)\'$")
	public void Try_to_login_with(String username, String password){
		login.login(username, password);
		System.out.println("Login with username");
	}
	
	@When("^Try to search: \'(.*)\'$")
	public void Try_to_search(String text){
		home.searchText(text);
	}
	
	@When("Do a like")
	public void Do_a_like(){
		profile.clickLike();
	}
	
	
	
	@Then("Check if login is success")
	public void Check_if_login_is_success(){
		System.out.println("Check");
		login.verifyIfLoginSuccess("Tran Trong Tien");
	}
	
	@Then("Check if login is failed")
	public void Check_if_login_is_failed(){
		login.verifyIfLoginFailed("Log in as Tran Trong Tien");
	}
	
	@Then("Check title home page")
	public void Check_title_home_page(){
		assertEquals(true,webDriver.getTitle().contains("Facebook"));
	}

	@Then("Check result of searching")
	public void Check_result_of_searching(){
		home.verifySearch("FACEBOOK");
	}
	
	@Then("Check test post")
	public void Check_test_post(){
		profile.verifyTestPost("Test Post");
	}
	
	@Then("Check like")
	public void Check_like(){
		profile.verifyLike();
	}
	
	@Then("Shut down driver")
	public void shutdown_driver() {
		if(webDriver != null) {
			webDriver.quit();
		}
	}
	
}
