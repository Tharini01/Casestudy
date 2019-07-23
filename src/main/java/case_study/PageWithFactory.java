package case_study;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageWithFactory {
	WebDriver driver;

	public PageWithFactory(WebDriver driver) 
{
		this.driver = driver;
	}

	@FindBy(name = "products")
	@CacheLookup
	WebElement product;

	@FindBy(how=How.XPATH ,using = "//input[@value='FIND DETAILS']")
	@CacheLookup
	WebElement btn;


	public void prod_search(String prd) {
		product.sendKeys(prd);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.DOWN).click().build().perform();
		btn.click();
		
	
	}

}