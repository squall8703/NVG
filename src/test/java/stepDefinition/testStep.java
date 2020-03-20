package stepDefinition;

import cucumber.api.java.en.*;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.Homepage;
import POM.Loginpage;
import POM.LoginSuccessfulpage;
import POM.Anibispage;
import POM.Searchpage;

public class testStep {
	
	public WebDriver driver;
	
	@Given("User on Home Page")
	public void user_on_homepage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stage.anibis.ch/fr/default.aspx");
	}
	
	@When("User Clicks on LogIn link")
	public void user_is_on_Home_Page() throws Throwable {
		Homepage hp = new Homepage(driver);
		hp.click_login();
	}
	
	@When("^User Check cursor at default$")
	public void check_cursor_at_default() throws Throwable {
	}
	
	@When("^User Enters \"([^\"]*)\" to email field$")
	public void user_enter_invalid_username(String invalid_email) throws Throwable {
		Loginpage lg = new Loginpage(driver);
		lg.enter_username(invalid_email);
		lg.click_continue();
	}
	
	@Then("^User Gets error \"([^\"]*)\" and observe highlight in red of the field$")
	public void user_get_error_message(String error_message) throws Throwable {
		Loginpage lg = new Loginpage(driver);
		String error = lg.get_error();
		Assert.assertEquals(error_message, error);
		String color = lg.get_backgroundcolor();
		Assert.assertEquals("rgb(255, 236, 236)", color);
	}
	
	@When("^User Enters valid username \"([^\"]*)\" and password \"([^\"]*)\"\"$")
	public void user_enter_valid_username(String username, String password) throws Throwable {
		Loginpage lg = new Loginpage(driver);
		lg.enter_username(username);
		lg.click_continue();
		lg.enter_password(password);
		lg.click_login();
	}
	
	@When("User Clicks My Anibis")
	public void user_click_my_anibis() throws Throwable {
		LoginSuccessfulpage ls = new LoginSuccessfulpage(driver);
		ls.click_myanibis();
	}
	
	@When("User Clicks User Account")
	public void user_click_user_account() throws Throwable {
		LoginSuccessfulpage ls = new LoginSuccessfulpage(driver);
		ls.click_useraccount();
	}
	
	@Then("^User See the email \"([^\"]*)\" in personal page$")
	public void user_see_email(String email_test) throws Throwable {
		Anibispage ap = new Anibispage(driver);
		String email = ap.get_email();
		Assert.assertEquals(email_test, email);
	}
	
	@When("User Clicks on All Categories link")
	public void user_click_on_all_categories() throws Throwable {
		Homepage hp = new Homepage(driver);
		hp.click_allcategories();
	}
	
	@When("User Clicks Immobilien category")
	public void user_click_immobilien_category() throws Throwable {
		Homepage hp = new Homepage(driver);
		hp.click_immobilier();
	}
	
	@When("User Clicks Apply")
	public void user_click_apply() throws Throwable {
		Homepage hp = new Homepage(driver);
		hp.click_apply();
	}
		
	@When("^User Select Price from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void user_select_price(String money_from, String money_to) throws Throwable {
		Searchpage sp = new Searchpage(driver);
		sp.enter_price_from(money_from, money_to);		
	}
	
	@Then("^User Verifies the number of results on First page is 20")
	public void count_articles() throws Throwable {
		Searchpage sp = new Searchpage(driver);
		Assert.assertEquals(sp.count_article(),20);
	}
	
	@When("User Select sort by date")
	public void user_sort_by_date() throws Throwable {
		Searchpage sp = new Searchpage(driver);
		sp.sort_recent();
	}
	@When("^User Select Location \"([^\"]*)\" and \"([^\"]*)\" around$")
	public void select_location_zurich(String location, String distance) throws Throwable {
		Searchpage sp = new Searchpage(driver);
		sp.select_location(location, distance);
	}
}
