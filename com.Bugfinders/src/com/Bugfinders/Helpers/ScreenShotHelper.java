package com.Bugfinders.Helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Bugfinders.testBase.StartStopWebDriver;



public class ScreenShotHelper extends StartStopWebDriver {

	public static void takeScreenshot(String fileName) {
		int index = 1;
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0,0)");
			Boolean check = (Boolean) jse.executeScript(
					"return document.documentElement.scrollHeight>document.documentElement.clientHeight");
			Long ScrollH = (Long) jse.executeScript("return document.documentElement.scrollHeight");
			Long clientH = (Long) jse.executeScript("return document.documentElement.clientHeight");
			if (check.booleanValue()) {
				while (ScrollH.intValue() > 0) {
					File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(src, new File("Screenshots" + fileName + index + ".jpg"));
					jse.executeScript("window.scrollTo(0," + clientH * index + ")");
					ScrollH = ScrollH - clientH;
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					index++;
				}
			} else {
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("Screenshots" + fileName + ".jpg"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String ExtentScreenShot(String screenShotName) throws IOException {
		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "\\ExtentScreenshot\\" + screenShotName + ".jpg");

		FileUtils.copyFile(Source, Dest);

		return System.getProperty("user.dir") + "\\ExtentScreenshot\\" + screenShotName + ".jpg";
	}

}
