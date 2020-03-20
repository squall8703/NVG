package POM;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {
	WebDriver driver;
	public Searchpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
    }
	
	@FindBy(how = How.CSS, using = "[class=\"sc-1i2ze9-0 gWqNMB\"] input")
	List<WebElement> txt_price;
	
	@FindBy(how = How.CSS, using = "[class=\"sc-16mxwr7-0 fpgsWB\"] input")
    WebElement txt_location ;
	
	@FindBy(how = How.CSS, using = "[class=\"sc-10awqyf-0 dqKuOL sc-10zeniy-0 gkGS\"]")
    List<WebElement> list_article;
	
	@FindBy(how = How.CSS, using = "[class=\"sc-19dcm61-0 gNpaVb\"]")
	WebElement drop_sorting;	
	
	@FindBy(how = How.CSS, using = "[value=\"dpo|d\"]")
	WebElement select_date;	
	
	@FindBy(how = How.CSS, using = "[class=\"dyh2vd-0 XKYPm\"]")
	WebElement normal_txt;	
	
	@FindBy(how = How.XPATH, using = "//option[text()=\"10 km\"]")
	WebElement distance_10_km;

	@FindBy(how = How.CSS, using = "[class=\"sc-19dcm61-0 gFBkyB\"]")
	WebElement dropdown_distance;
	
	
	 public void enter_price_from(String money1, String money2) throws InterruptedException {  
		Thread.sleep(7000);
		txt_price.get(0).sendKeys(money1);
		txt_price.get(1).sendKeys(money2);
	 }
	 
	 public void select_location(String location, String distance) throws InterruptedException {
        txt_location.sendKeys(location);
        txt_location.sendKeys(Keys.TAB);
        dropdown_distance.click();
        distance_10_km.click();
	 }
	 	 
	 public int count_article() {
		 return list_article.size();
	 }
	 
	 public void sort_recent() {
		 drop_sorting.click();
	     select_date.click();
	     //normal_txt.click();
	     //String []date =new String[20];
	     //List<WebElement> check = driver.findElements(By.cssSelector("[class=\"sc-10awqyf-0 dqKuOL sc-10zeniy-0 gkGS\"]")); 
	     //list_article.get(0).findElement(By.xpath("//div[@class='sc-1aka2ao-0 bxKRrP']")).getText();
	    /* for(int i =0; i<check.size(); i++)
	     {
	    	 String temp = check.get(i).findElement(By.xpath("//div[@class='sc-1aka2ao-0 bxKRrP']")).getText();
	    	 date[i]=temp.substring(temp.length()-10,temp.length());
	     }	 */    
	 }
}
