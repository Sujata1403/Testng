package common_utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
	public void implicitWait(WebDriver driver ) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void handleDropDrown(WebElement element, String assign) {
		Select select=new Select(element);
		select.selectByVisibleText(assign);
	}
	
	
    public void mouseHover(WebDriver driver,WebElement element) {
    	Actions actions=new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
    
    
    public void switchWindow(WebDriver driver, String expectedUrl) {
    	//how many windows
    	Set<String> ids = driver.getWindowHandles();
    			
    	//transfer the control to child window
    	for (String string : ids) {
    		String actualUrl = driver.switchTo().window(string).getCurrentUrl();
    				
    		if (actualUrl.contains(expectedUrl)) {
    			break;
    		}
    	}
	}
    
    
    public File screenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File tempFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("./Screenshot/"+screenshotName+".png");
		FileUtils.copyFile(tempFile, destinationFile);
		return destinationFile;
	}
}
