package vtiger_crm;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common_utils.ExcelUtil;
import common_utils.JavaUtil;
import common_utils.ListenerImplementation;
import common_utils.PropertyFileUtil;
import common_utils.WebDriverUtil;

//@Listener is used to monitor current class
@Listeners(ListenerImplementation.class)
public class Organizations {
	
	PropertyFileUtil propertyFileUtil=new PropertyFileUtil();
	WebDriverUtil webDriverUtil=new WebDriverUtil();
	ExcelUtil excelUtil=new ExcelUtil();
	JavaUtil javaUtil=new JavaUtil();
	
	@Test
	public void organizationTest() throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		//to maximize the window
		webDriverUtil.maximize(driver);
		//to apply wait
		webDriverUtil.implicitWait(driver);
		
		//to read data from property file
		String URL = propertyFileUtil.getDataFromPropertyFile("Url");		
		String USERNAME = propertyFileUtil.getDataFromPropertyFile("Username");
		String PASSWORD = propertyFileUtil.getDataFromPropertyFile("Password");
		
		//to read data from excel sheet
		String ORGNAME = excelUtil.getDataFromExcel("Organisation", 0, 1);
		String GROUP = excelUtil.getDataFromExcel("Organisation", 1, 1);
		
		//launch application
		driver.get(URL);
		
		Thread.sleep(2000);
		//enter username in username text fiels
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		Thread.sleep(2000);
		//enter password in password text field
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		Thread.sleep(2000);
		//click on login button
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(2000);
		//click on Organizations
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		Thread.sleep(2000);
		//click on (+) create orgnaization
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		Thread.sleep(2000);
		//enter orgnization name & random number to save everytime
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+javaUtil.getRandomNumber());
		
		Thread.sleep(2000);
		//In assigned to click on Group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		Thread.sleep(2000);
		//In drop down select Support group
		WebElement dropDown = driver.findElement(By.name("assigned_group_id"));
		webDriverUtil.handleDropDrown(dropDown, GROUP);
		
		Thread.sleep(2000);
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(2000);
		//To mouse hover on img
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Thread.sleep(2000);
		webDriverUtil.mouseHover(driver, img);
		
		Thread.sleep(2000);
		//to click on sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
