package vtiger_crm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import common_utils.BaseClass;
import common_utils.ExcelUtil;
import common_utils.JavaUtil;
import common_utils.PropertyFileUtil;
import common_utils.WebDriverUtil;

public class ContactsTestng extends BaseClass{
	PropertyFileUtil propertyFileUtil=new PropertyFileUtil();
	WebDriverUtil webDriverUtil=new WebDriverUtil();
	ExcelUtil excelUtil=new ExcelUtil();
	JavaUtil javaUtil=new JavaUtil();
	
	@Test
	public void contactsTest() throws IOException, InterruptedException {
//		WebDriver driver=new ChromeDriver();
//		//to maximize the window
//		webDriverUtil.maximize(driver);
//		//to apply wait
//		webDriverUtil.implicitWait(driver);
//		
//		//to read data from property file
//		String URL = propertyFileUtil.getDataFromPropertyFile("Url");		
//		String USERNAME = propertyFileUtil.getDataFromPropertyFile("Username");
//		String PASSWORD = propertyFileUtil.getDataFromPropertyFile("Password");
		
		//to read data from excel sheet
		String FNAME = excelUtil.getDataFromExcel("Contacts", 0, 1);
		String LNAME = excelUtil.getDataFromExcel("Contacts", 1, 1);
		String C_ASSIGN = excelUtil.getDataFromExcel("Contacts", 2, 1);
		String C_ORGNAME = excelUtil.getDataFromExcel("Contacts", 3, 1);
		String childUrl = excelUtil.getDataFromExcel("Contacts", 4, 1);
		
//		//launch application
//		driver.get(URL);
//				
//		Thread.sleep(2000);
//		//enter username in username text fiels
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//				
//		Thread.sleep(2000);
//		//enter password in password text field
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//				
//		Thread.sleep(2000);
//		//click on login button
//		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(2000);
		//click on Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		Thread.sleep(2000);
		//click on create contacts(+)
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		Thread.sleep(2000);
		//enter first name
		driver.findElement(By.name("firstname")).sendKeys(FNAME);
		
		Thread.sleep(2000);
		// enter last name 
		driver.findElement(By.name("lastname")).sendKeys(LNAME);
		
		//to fail the test script
//		WebElement notifyCheckbox = driver.findElement(By.name("notify_owner"));
//		Assert.assertTrue(notifyCheckbox.isSelected());
		String actualUrl=driver.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		Assert.assertEquals(actualUrl, expectedUrl);
		
		Thread.sleep(2000);
		//In assigned to click on Group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		Thread.sleep(2000);
		//In drop down select Team selling
		WebElement dropDown = driver.findElement(By.name("assigned_group_id"));
		webDriverUtil.handleDropDrown(dropDown, C_ASSIGN);
		
		Thread.sleep(2000);
		//click on + button of organization name
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//transfer control from parent to child window
		webDriverUtil.switchWindow(driver, childUrl);
		
		Thread.sleep(2000);
		//enter organization name in search text field
		driver.findElement(By.id("search_txt")).sendKeys(C_ORGNAME);
		
		Thread.sleep(2000);
		//click on search on
		driver.findElement(By.name("search")).click();
		
		Thread.sleep(2000);
		//select organization name
		driver.findElement(By.xpath("//a[text()='Tech Mahindra']")).click();
		
		//to transfer control from child window to parent window
		webDriverUtil.switchWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		Thread.sleep(2000);
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
//		//to take screenshot
//		webDriverUtil.screenshot(driver, "organization_child");
		
//		Thread.sleep(2000);
//		//To mouse hover on img
//		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//		Thread.sleep(2000);
//		webDriverUtil.mouseHover(driver, img);
//		
//		Thread.sleep(2000);
//		//to click on sign out
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
