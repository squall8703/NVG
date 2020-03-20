package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessfulpage {
	WebDriver driver;
	public LoginSuccessfulpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
    }
	
	@FindBy(how = How.ID, using = "ctl00_Header1_ctlHeaderMetaBar_ucMainLinks_hypMyAnibis")
    WebElement lnk_myanibis;
	
	@FindBy(how = How.LINK_TEXT, using = "Benutzerkonto")
    WebElement lnk_useraccount;
		
	public void click_myanibis() {
		lnk_myanibis.click();
	}
	
	public void click_useraccount(){
		lnk_useraccount.click();
	}
}




