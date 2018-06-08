package com.Bugfinders.Helpers;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Bugfinders.testBase.StartStopWebDriver;



public class GenericHelper extends StartStopWebDriver {

	public static WebElement getElement(String ObjectName) {
		if (driver.findElements(By.id(ObjectName)).size() == 1)
			return driver.findElement(By.id(ObjectName));
		else if (driver.findElements(By.name(ObjectName)).size() == 1)
			return driver.findElement(By.name(ObjectName));
		else if (driver.findElements(By.className(ObjectName)).size() == 1)
			return driver.findElement(By.className(ObjectName));
		else if (driver.findElements(By.xpath(ObjectName)).size() == 1)
			return driver.findElement(By.xpath(ObjectName));
		else if (driver.findElements(By.cssSelector(ObjectName)).size() == 1)
			return driver.findElement(By.cssSelector(ObjectName));
		else
			throw new NoSuchElementException("Element Not Present :" + ObjectName);
	}

	public static boolean isElementPresent(String locator) {
		boolean status = false;

		boolean flag = false;
		if (locator.contains("/"))
			flag = true;
		if (driver.findElements(By.id(locator)).size() >= 1) {
			status = true;
		} else if (driver.findElements(By.name(locator)).size() >= 1) {
			status = true;
		} else if (!flag && driver.findElements(By.cssSelector(locator)).size() >= 1) {
			status = true;
		} else if (driver.findElements(By.xpath(locator)).size() >= 1) {
			status = true;
		} else
			status = false;
		return status;
	}

	public static void waitForElement(String locator) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		boolean flag = false;
		if (locator.contains("/"))
			flag = true;
		if (driver.findElements(By.id(locator)).size() >= 1) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
			return;
		} else if (driver.findElements(By.name(locator)).size() >= 1) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
			return;
		} else if (!flag && driver.findElements(By.cssSelector(locator)).size() >= 1) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
			return;
		} else if (driver.findElements(By.xpath(locator)).size() >= 1) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			return;
		} else
			throw new NoSuchElementException("Element Not Found : " + locator);

	}
	
	public static WebElement waitForElement(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		} 
		

	
}
