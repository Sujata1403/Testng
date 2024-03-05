package common_utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public static WebDriver driver=new ChromeDriver();
	
	WebDriverUtil webDriverUtil=new WebDriverUtil();
	PropertyFileUtil propertyFileUtil=new PropertyFileUtil();
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Connect to database!!");
	}
	
	
	@BeforeClass
	public void beforeClass() throws IOException {
		//@BeforeClass is used to launch the application
		System.out.println("-----------Launch the browser!!-------");
//		WebDriver driver=new ChromeDriver();
		//to maximize the window
		webDriverUtil.maximize(driver);
		//to apply wait
		webDriverUtil.implicitWait(driver);
		
		//to read data from property file
		String URL = propertyFileUtil.getDataFromPropertyFile("Url");	
		
		//launch application
		driver.get(URL);
	}
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		//@BeforeMethod is used to login to the application
		System.out.println("-----------Login to the application!!-------");
		String USERNAME = propertyFileUtil.getDataFromPropertyFile("Username");
		String PASSWORD = propertyFileUtil.getDataFromPropertyFile("Password");
		
		Thread.sleep(2000);
		//enter username in username text fiels
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		Thread.sleep(2000);
		//enter password in password text field
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		Thread.sleep(2000);
		//click on login button
		driver.findElement(By.id("submitButton")).click();
	}
	
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		//@AfterMethod is used to logout from the application
		Thread.sleep(2000);
		//To mouse hover on img
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Thread.sleep(2000);
		webDriverUtil.mouseHover(driver, img);
				
		Thread.sleep(2000);
		//to click on sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("-----------Logout from the application!!-------");
	}
	
	@AfterClass
	public void afterClass() {
		//@AfterClass is used to close the application
		driver.quit();
		System.out.println("-----------Close the browser!!-------");
	}
	
	
	@AfterSuite
    public void afterSuite() {
		System.out.println("Disconnect from database!!");
	}

}
