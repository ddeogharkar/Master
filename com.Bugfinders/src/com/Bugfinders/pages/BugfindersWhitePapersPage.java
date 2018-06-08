package com.Bugfinders.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Bugfinders.Helpers.GenericHelper;

public class BugfindersWhitePapersPage {
	
	private WebDriver Driver;

	public BugfindersWhitePapersPage(WebDriver Driver) {
		this.Driver = Driver;
	}
	
		// White Papers - List White Papers
		By WhitePapersTitleList = By.xpath("//div[@class='col-sm-6 col-md-4']//div[@class='title']");
		
		// White Papers - Title List of White Papers
		By WhitePapersLinks = By.xpath("//div[@class='col-sm-6 col-md-4']//a");
		
		// White Papers - First Name
		By firstName = By.xpath("//input[contains(@id,'firstname')]");
		
		// White Papers - Last Name
		By lastName = By.xpath("//input[contains(@id,'lastname')]");

		// White Papers - Company Email
		By companyEmail = By.xpath("//input[contains(@id,'email')]");
		
		// White Papers - Download Now Button
		By DownloadNowButton1 = By.xpath("//input[@class='hs-button primary large']");
		
		// White Papers - Download Now Button
		By DownloadNowButton2 = By.xpath("//a[@class='cta_button ']");
		
		
		public void ClickOnWhitePaper(String WhitePaper)
		{
			List<WebElement> TitleListCollection = Driver.findElements(WhitePapersTitleList);
			int count =0;
			for (WebElement item : TitleListCollection) {
				
				if(item.getText().equals(WhitePaper))
				{
					Driver.findElements(WhitePapersLinks).get(count).click();
					break;
				}
				count++;
			} 		
		}
		
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
		
		public void ClickDownloadNowButton2()
		{
			GenericHelper.waitForElement(DownloadNowButton2).click();
		}

		public String getUrl()
		{
			return Driver.getCurrentUrl();
		}

}
