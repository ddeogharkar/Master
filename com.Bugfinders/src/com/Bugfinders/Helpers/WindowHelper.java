package com.Bugfinders.Helpers;

import java.util.ArrayList;
import java.util.List;

import com.Bugfinders.testBase.StartStopWebDriver;



public class WindowHelper extends StartStopWebDriver {

	public static void switchToWindow(int Index) {
		try {
			List<String> li = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(li.get(Index));

		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Invalid Index :" + Index);
		}

	}

	public static void switchToMainWindow() {
		List<String> li = new ArrayList<>(driver.getWindowHandles());

		for (int i = 1; i <= li.size(); i++) {
			driver.switchTo().window(li.get(i));
			driver.close();
		}
		driver.switchTo().window(li.get(0));
	}

	public static void navigateToPage(String url) {
		driver.navigate().to(url);
	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void back() {
		driver.navigate().back();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static String windowGetTitle() {
		return driver.getTitle();
	}
}
