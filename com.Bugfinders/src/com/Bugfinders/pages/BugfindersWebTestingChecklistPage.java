package com.Bugfinders.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugfindersWebTestingChecklistPage {
	
	private WebDriver Driver;

	public BugfindersWebTestingChecklistPage(WebDriver Driver) {
		this.Driver = Driver;
	}

		// Web Checklist - First Name
		By firstName = By.xpath("//input[contains(@id,'firstname')]");
		
		// Web Checklist - Last Name
		By lastName = By.xpath("//input[contains(@id,'lastname')]");

		// Web Checklist - Company Email
		By companyEmail = By.xpath("//input[contains(@id,'email')]");
		
		// Web Checklist - Download Now Button
		By DownloadNowButton1 = By.xpath("//input[@class='hs-button primary large']");
		
		
		public void EnterFirstName( String FirstName)
		{
			Driver.findElement(firstName).sendKeys(FirstName);
		}
		
		public void EnterLastName( String LastName)
		{
			Driver.findElement(lastName).sendKeys(LastName);
		}
		public void EnterCompanyEmail( String CompanyEmail)
		{
			Driver.findElement(companyEmail).sendKeys(CompanyEmail);
		}
		
		public void ClickDownloadNowButton1()
		{
			Driver.findElement(DownloadNowButton1).click();
		}
		
		public String getUrl() throws InterruptedException
		{
			Thread.sleep(5000);
			return Driver.getCurrentUrl();
		}

}
