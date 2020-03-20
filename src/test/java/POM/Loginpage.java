package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
    }
	
	@FindBy(how = How.ID, using = "ctl00_phlContent_ctlEmailValidationBox_txtEmail")
    WebElement txt_email;

	@FindBy(how = How.ID, using = "ctl00_phlContent_ctlEmailValidationBox_lbtContinue")
    WebElement btn_continue;
	
	@FindBy(how = How.ID, using = "ctl00_phlContent_ctlEmailValidationBox_txtEmail-error")
    WebElement txt_error;
	
	@FindBy(how = How.ID, using = "ctl00_phlContent_txtPassword")
    WebElement txt_password;
	
	@FindBy(how = How.ID, using = "ctl00_phlContent_btnLogin")
    WebElement btn_login;
	
	public void enter_username(String username) {
		 txt_email.sendKeys(username);
	}
	
	public void enter_password(String password) {
		txt_password.sendKeys(password);
	}
	
	public void click_continue() {
		btn_continue.click();
	}
	
	public void click_login() {
		btn_login.click();
	}
	
	public String get_error() {
		return txt_error.getText();
	}
	
	public void check_cursor() {
		txt_email.equals(driver.switchTo().activeElement());
	}
	
	public String get_backgroundcolor() {
		String get_color =  txt_email.getCssValue("background").toString();
		return get_color.substring(0, 18);
	}
}
