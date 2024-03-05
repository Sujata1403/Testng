package common_utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	
	ExtentReports extentReport;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+" Test script execution is started.", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//Reporter.log(methodName+" Test script execution is passed.", true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String message = result.getThrowable().toString();
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+" Test script execution is failed.--- "+message, true);
		WebDriverUtil webDriverUtil=new WebDriverUtil();
		
		try {
			webDriverUtil.screenshot(BaseClass.driver, "Contacts");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+" Test script execution is skipped.", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		//Reporter.log("To start the execution.", true);
		//create object of ExtentSparkReporter & pass path as an argument of constructor
		//use ExtentSparkReporter class just to configure extent report
		JavaUtil javaUtil=new JavaUtil();
		ExtentSparkReporter reporter=new ExtentSparkReporter("./extent-report/report"+javaUtil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("vTiger");
		
		//to create extent report
		//create object of ExtentReports class
		extentReport=new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("OS", "Window");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Chrome-version", "121");
		extentReport.setSystemInfo("Author", "Sujata");
	}

	@Override
	public void onFinish(ITestContext context) {
		//Reporter.log("To finish the execution.", true);
		extentReport.flush();
	}
	
}
