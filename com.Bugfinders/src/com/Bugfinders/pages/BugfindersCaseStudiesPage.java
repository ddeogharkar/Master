package com.Bugfinders.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Bugfinders.Helpers.GenericHelper;

public class BugfindersCaseStudiesPage {
	
	private WebDriver Driver;

	public BugfindersCaseStudiesPage(WebDriver Driver) {
		this.Driver = Driver;
	}
	
	// Case Studies - List of case studies
	By CaseStudyTitleList = By.xpath("//div[@class='col-sm-6 col-md-4']//div[@class='title']");
	
	// Case Studies - Title List of case studies
	By CaseStudyLinks = By.xpath("//div[@class='col-sm-6 col-md-4']//a");
	
	// Case Studies - First Name
	By firstName = By.xpath("//input[contains(@id,'firstname')]");
	
	// Case Studies - Last Name
	By lastName = By.xpath("//input[contains(@id,'lastname')]");

	// Case Studies - Company Email
	By companyEmail = By.xpath("//input[contains(@id,'email')]");
	
	// Case Studies - Download Now Button
	By DownloadNowButton1 = By.xpath("//input[@class='hs-button primary large']");
	
	
	By DownloadNowButton2 = By.xpath("//a[@class='cta_button ']");
	
	public void ClickOnCaseStudy(String CaseStudy)
	{
		List<WebElement> TitleListCollection = Driver.findElements(CaseStudyTitleList);
		int count =0;
		for (WebElement item : TitleListCollection) {
			
			if(item.getText().equals(CaseStudy))
			{
				Driver.findElements(CaseStudyLinks).get(count).click();
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
