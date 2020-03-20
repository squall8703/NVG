package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Anibispage {
	WebDriver driver;
	public Anibispage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
    }
	
	@FindBy(how = How.XPATH, using = "//div[3]/main/div/div[3]/div[2]/div[2]/div/strong")
    WebElement txt_email;
	
	public String get_email() {
		return txt_email.getText();
	}
	
}
