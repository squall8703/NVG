package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage {
	WebDriver driver;
    public Homepage(WebDriver driver)
	{
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "ctl00_Header1_ctlHeaderMetaBar_ucMainLinks_hypMyAnibis")
    WebElement link_login;
    
    @FindBy(how = How.CSS, using = "[class=\"category-link modal-opener\"]")
    WebElement men_search;
    
    @FindBy(how = How.ID, using = "ctl00_phlContent_ModalDialogCategoryBrowser_rptCategories_ctl14_lblCategoryName")
    WebElement sel_immobilier;
    
    @FindBy(how = How.ID, using = "ctl00_phlContent_ModalDialogCategoryBrowser_lnkBrowserCategoryApply")
    WebElement btn_apply;
    

    public void click_login() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(link_login));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
        link_login.click();
    }
    
    public void click_allcategories(){
    	WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(men_search));
        men_search.click();
    }
    
    public void click_immobilier() {
    	WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(sel_immobilier));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sel_immobilier);
        sel_immobilier.click(); 	
    }
    
    public void click_apply() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
    	WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(btn_apply));
        btn_apply.click();
    }  
}
