package case_study;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class step_definition
{
	
	WebDriver driver;
	
	@Given("^User must be in the SignUp Page$")
	public void user_must_be_in_the_SignUp_Page() throws Throwable {
			driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/RegisterUser.htm");
	 	}
	


	@When("^User must provide the necessary credentials username \"([^\"]*)\" , firstname \"([^\"]*)\" , lastname \"([^\"]*)\" , password \"([^\"]*)\" , confirmPassword \"([^\"]*)\" , select the gender ,emailAddress \"([^\"]*)\" , mobileNumber \"([^\"]*)\" , dob \"([^\"]*)\" , address \"([^\"]*)\" , select a security question and provide the necessary answer \"([^\"]*)\" and click submit$")
	public void user_must_provide_the_necessary_credentials_username_firstname_lastname_password_confirmPassword_select_the_gender_emailAddress_mobileNumber_dob_address_select_a_security_question_and_provide_the_necessary_answer_and_click_submit(
			String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) throws Throwable {
		driver.findElement(By.name("userName")).sendKeys(arg1);
		driver.findElement(By.name("firstName")).sendKeys(arg2);
		driver.findElement(By.name("lastName")).sendKeys(arg3);
		driver.findElement(By.name("password")).sendKeys(arg4);
		driver.findElement(By.name("confirmPassword")).sendKeys(arg5);
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys(arg6);
		driver.findElement(By.name("mobileNumber")).sendKeys(arg7);
		driver.findElement(By.name("dob")).sendKeys(arg8);
		driver.findElement(By.name("address")).sendKeys(arg9);
		Select a=new Select(driver.findElement(By.id("securityQuestion")));
		a.selectByIndex(1);
		driver.findElement(By.id("answer")).sendKeys(arg10);
		driver.findElement(By.name("Submit")).click();
	}	

	@Then("^Registration is done successfully$")
	public void registration_is_done_successfully() throws Throwable {

			WebDriverWait wait= new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Login")));
			System.out.println("Registered Successfully");
			driver.close(); 
	 	}
	

	@Given("^User must be in the Login Page$")
	public void user_must_be_in_the_Login_Page() throws Throwable {
		driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/login.htm");
    	}

	@When("^User must provide registered username credentials \"([^\"]*)\" and \"([^\"]*)\" and click Login$")
	public void user_must_provide_registered_username_credentials_and_and_click_Login(String arg1, String arg2) throws Throwable {
	    //System.out.println(arg1+ " "+arg2);
		driver.findElement(By.name("userName")).sendKeys(arg1);
	    driver.findElement(By.name("password")).sendKeys(arg2);
	    driver.findElement(By.name("Login")).click();
		}
	
	@Then("^Login is done successfully and user is directed to the Home page$")
	public void login_is_done_successfully_and_user_is_directed_to_the_Home_page() throws Throwable {
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("val")));
		System.out.println("Logged in successfully");
		Assert.assertEquals(driver.getTitle(),"Home");
		//driver.close(); 
	    }
	
	/*@When("^User must provide registered credentials$")
	public void user_must_provide_registered_username_credentials_and_click_Login(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<Map<String,String>> credential= arg1.asMaps(String.class , String.class);
		for(int i=0;i<credential.size();i++)
		{
			driver.findElement(By.name("userName")).sendKeys(credential.get(i).get("username"));
		    driver.findElement(By.name("password")).sendKeys(credential.get(i).get("password"));
		    driver.findElement(By.name("Login")).click();
		}
	}*/
	
	@Given("^The user is logged into the Home Page$")
	public void the_user_is_logged_into_the_Home_Page() throws Throwable {
		driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.name("userName")).sendKeys("Lalitha");
	    driver.findElement(By.name("password")).sendKeys("Password123");
	    driver.findElement(By.name("Login")).click();
	  
	}

	@When("^search for the product and click Find Details$")
	public void search_for_the_product_and_click_Find_Details() throws Throwable {
		PageWithFactory product = PageFactory.initElements(driver, PageWithFactory.class);

		product.prod_search("head");
		
	}

	@Then("^The page with the details of the product opens$")
	public void the_page_with_the_details_of_the_product_opens() throws Throwable {
		
		Assert.assertEquals(driver.getTitle(),"Search");
		System.out.println("product details found");
	}
	

@Given("^user registered into TestMeApp$")
public void user_registered_into_TestMeApp() throws Throwable {
	driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/login.htm");
	driver.findElement(By.name("userName")).sendKeys("Lalitha");
    driver.findElement(By.name("password")).sendKeys("Password123");
    driver.findElement(By.name("Login")).click();
   
}



@When("^user search a particular product and try to proceed the payment without adding item$")
public void user_search_a_particular_product_and_try_to_proceed_the_payment_without_adding_item() throws Throwable {
	PageWithFactory product = PageFactory.initElements(driver, PageWithFactory.class);
	product.prod_search("head");
	
 }

@Then("^TestMeApp doesnt display cart icon$")
public void testmeapp_doesnt_display_cart_icon() throws Throwable {

	if(driver.findElements(By.cssSelector("i.fa.fa-shopping-cart")).size()!=0)
	{
		System.out.println("PASS!!");
	}
	else
	{
		System.out.println("Payment page doesn't open without clicking Add_to_Cart button");
		System.out.println("TestMeApp doesnt display cart icon");
		System.out.println("FAIL!!");
	}
   
}
	
}
