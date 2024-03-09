package basic_pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import common_utils.ExcelUtil;
import common_utils.JavaUtil;
import common_utils.PropertyFileUtil;
import common_utils.WebDriverUtil;
import object_repository_pom.CreatingNewOrganizationPage;
import object_repository_pom.LoginPage;
import object_repository_pom.OrganizationsPage;
import pom1.HomePage;

public class BasePage {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		//create object 
		PropertyFileUtil propertyFileUtil=new PropertyFileUtil();
		ExcelUtil excelUtil=new ExcelUtil();
		WebDriverUtil webDriverUtil=new WebDriverUtil();
		JavaUtil javaUtil=new JavaUtil();
		
		//read data from property file
		String browser = propertyFileUtil.getDataFromPropertyFile("Browser");
		String url = propertyFileUtil.getDataFromPropertyFile("Url");
		String username = propertyFileUtil.getDataFromPropertyFile("Username");
		String password = propertyFileUtil.getDataFromPropertyFile("Password");
		
		//read the data from excel sheet
		String ORGNAME = excelUtil.getDataFromExcel("Organisation", 0, 1);
		String ASSIGN = excelUtil.getDataFromExcel("Organisation", 1, 1);
		
		//launch the browser
		if (browser.equals("Chrome")) {
			driver=new ChromeDriver();
		} else if(browser.equals("Edge")){
			driver=new EdgeDriver();
		} else {
			driver=new FirefoxDriver();
		}
		
		
		//maximize the browser
		driver.manage().window().maximize();
		//launch the application
		driver.get(url);
		
		
		//Create Object of LoginPage class
		LoginPage loginPage=new LoginPage();
		//to initialized the elements
		PageFactory.initElements(driver, loginPage);
		//to enter the values
		loginPage.getUsernameTf().sendKeys(username);
		Thread.sleep(2000);
		loginPage.getPasswordTf().sendKeys(password);
		loginPage.getLoginButton().click();
		
		
		//Create Object of HomePage class
		HomePage homePage=new HomePage();
		PageFactory.initElements(driver, homePage);
		//click on organization
		homePage.getOrganization().click();
		
		
		//create object of OrganizationPage class
		OrganizationsPage organizationsPage=new OrganizationsPage();
		PageFactory.initElements(driver, organizationsPage);
		//click on + icon
		organizationsPage.getCreateOrganization().click();
		
		
		//create object of CreateNewOrganizationsPage
		CreatingNewOrganizationPage creatingNewOrganizationPage=new CreatingNewOrganizationPage();
		PageFactory.initElements(driver, creatingNewOrganizationPage);
		//enter organization name
		creatingNewOrganizationPage.getOrganizationNametf().sendKeys(ORGNAME+javaUtil.getRandomNumber());
		//click on group radio button
		creatingNewOrganizationPage.getGroupButton().click();
		//select the drop down --Select Group
		webDriverUtil.handleDropDrown(creatingNewOrganizationPage.getDropdown(), ASSIGN);
		//click on save button
		creatingNewOrganizationPage.getSaveButton().click();
		
		Thread.sleep(3000);
		//mouse hover on the image
		webDriverUtil.mouseHover(driver, homePage.getImage());
		//click on sign out
		homePage.getSignOutButton().click();
	}
}
