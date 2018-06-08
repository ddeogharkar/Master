package com.Bugfinders.testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Bugfinders.Helpers.ExtentReportHelper;
import com.Bugfinders.Helpers.ScreenShotHelper;
import com.Bugfinders.Helpers.WindowHelper;
import com.Bugfinders.Helpers.readConfigProperties;
import com.relevantcodes.extentreports.LogStatus;





public class StartStopWebDriver extends ExtentReportHelper {
	public static WebDriver driver = null;
	public static WebElement element = null;

	@BeforeMethod
	public void setUp() {
		readConfigProperties config = new readConfigProperties();
		try {
			if ("Firefox".equalsIgnoreCase(config.getBrowser())) {
				System.setProperty("webdriver.gecko.driver",
						StartStopWebDriver.class.getClassLoader().getResource("com/Bugfinders/Resources/geckodriver.exe").getPath());
				driver = new FirefoxDriver();
				driver.get(config.getUrl());
				// driver.manage().timeouts().implicitlyWait(20,
				// TimeUnit.SECONDS);
			} else if ("GoogleChrome".equalsIgnoreCase(config.getBrowser())) {
				System.setProperty("webdriver.chrome.driver",
						StartStopWebDriver.class.getClassLoader().getResource("com/Bugfinders/Resources/chromedriver.exe").getPath());
				driver = new ChromeDriver();
				driver.get(config.getUrl());
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}

			else if ("InternetExplorer".equalsIgnoreCase(config.getBrowser())) {
				System.setProperty("webdriver.ie.driver", StartStopWebDriver.class.getClassLoader()
						.getResource("com/Bugfinders/Resources/IEDriverServer.exe").getPath());
				driver = new InternetExplorerDriver();
				driver.get(config.getUrl());
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} else {
				driver = new HtmlUnitDriver();
				driver.get(config.getUrl());
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}

			WindowHelper.windowMaximize();
			driver.manage().timeouts().implicitlyWait(config.getElementWait(), TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(config.getPageLoadWait(), TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(config.getElementWait(), TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeClass

	public void ReportInit() {
		ExtentReportHelper.ExtentReportInit();
	}

	@AfterClass

	public void Reportteardown() {
		ExtentReportHelper.ExtentReportClose();
	}

	@AfterMethod
	public void TestFailedStatus(ITestResult Result) throws IOException {
		if (Result.getStatus() == Result.FAILURE) {
			String screenshotPath = ScreenShotHelper.ExtentScreenShot(Result.getTestName());
			extenttest.log(LogStatus.FAIL, Result.getThrowable() + " " + Result.getTestName());
			extenttest.log(LogStatus.FAIL, "Screenshot" + extenttest.addScreenCapture(screenshotPath));
		}

		extentreport.endTest(extenttest);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		try {
			if(driver!=null)
			{
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
	}
}
