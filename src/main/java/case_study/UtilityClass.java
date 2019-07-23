package case_study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilityClass {
	
	static WebDriver driver;

	public static WebDriver browser(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ishwarya.devanathan\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;

	}
	

}
