package com.Bugfinders.pages;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BugfinderHomePage {

	private WebDriver driver;

	public BugfinderHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Home Page - Primary navigation menu items
	By PrimaryNavigationList = By.xpath("//li[contains(@class,'primary-navigation')]");

	// Home Page - Pricing
	By Pricing = By.xpath("//a[@itemprop='url' and contains(text(),'Pricing')]");

	// Home Page - Services
	By Services = By.linkText("Services");

	// Home Page - Sectors
	By Sectors = By.linkText("Sectors");

	// Home Page - Resources
	By Resources = By.xpath("//a[@itemprop='url' and contains(text(),'Resources')]");

	// Home Page - Success
	By Success = By.xpath("//a[@itemprop='url' and contains(text(),'Success')]");

	// Home Page - White Papers
	By White_Papers = By.xpath("//a[@itemprop='url' and contains(text(),'White Papers')]");

	// Home Page - Case Studies
	By Case_Studies = By.xpath("//a[@itemprop='url' and contains(text(),'Case Studies')]");

	// Home Page - Button List on Carousel
	By RedButtonListCarousel = By.xpath("//button[@class='custom-button red']");
	
	
	//Home Page - Slides	
	By HomePageImageSlides = By.xpath("//li[contains(@class,'slide')]");
	
	//Home Page - Slides red buttons
	By HomePageImageSlidesButtons = By.xpath("//li[contains(@class,'slide')]//button[@class='custom-button red']");

	public void ClickPrimaryMenuItems(String MenuItem) {
		Collection<WebElement> PrimaryMenuItems = driver.findElements(PrimaryNavigationList);

		for (WebElement item : PrimaryMenuItems) {
			if (item.getText().equals(MenuItem)) {
				item.click();
			}
		}
	}
	
	public BugfinderPricingEnquiryPage ClickOnPricing()
	{
		driver.findElement(Pricing).click();
		
		return new BugfinderPricingEnquiryPage(driver);
	}

	public void ClickCaseStudies() {
		driver.findElement(Case_Studies).click();
	}

	public void ClickWhitePapers() {
		driver.findElement(White_Papers).click();
	}

	public void ClickCarouselButton(String ButtonName) 
	{
		Collection<WebElement> CarouselButton = driver.findElements(RedButtonListCarousel);

		for (WebElement item : CarouselButton) 
		{
			if (item.getText().equals(ButtonName)) 
			{
				item.click();
			}
		}
	}
	
	public void ClickOnSuccess()
	{
		driver.findElement(Success).click();
	}
	
	public BugfindersCaseStudiesPage ClickOnCaseStudies()
	{
		driver.findElement(Case_Studies).click();
		
		return new BugfindersCaseStudiesPage(driver);
	}
	
	public void ClickOnResources()
	{
		driver.findElement(Resources).click();
	}
	
	public BugfindersWhitePapersPage ClickOnWhitePapers()
	{
		driver.findElement(White_Papers).click();
		
		return new BugfindersWhitePapersPage(driver);
	}
	
	public BugfindersWebTestingChecklistPage ClickOnWebChecklist(String ChecklistName)
	{
		List<WebElement> TitleListCollection = driver.findElements(HomePageImageSlidesButtons);
		int count =0;
		for (WebElement item : TitleListCollection) {
			
			if(item.getText().equals(ChecklistName))
			{
				driver.findElements(HomePageImageSlidesButtons).get(count).click();
				break;
			}
			count++;
		} 	
		return new BugfindersWebTestingChecklistPage(driver);
	}
}
