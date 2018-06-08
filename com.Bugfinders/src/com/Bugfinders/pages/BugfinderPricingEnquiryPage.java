package com.Bugfinders.pages;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BugfinderPricingEnquiryPage {

	private WebDriver Driver;

	public BugfinderPricingEnquiryPage(WebDriver Driver) {
		this.Driver = Driver;
	}

	// Pricing Enquiry - FirstName
	By firstName = By.xpath("//input[contains(@id,'firstname')]");

	// Pricing Enquiry - Last Name
	By lastName = By.xpath("//input[contains(@id,'lastname')]");

	// Pricing Enquiry - companyName
	By companyName = By.xpath("//input[contains(@id,'company')]");

	// Pricing Enquiry - companyEmail
	By companyEmail = By.xpath("//input[contains(@id,'email')]");

	// Pricing Enquiry - phoneNumber
	By phoneNumber = By.xpath("//input[contains(@id,'phone')]");

	// Pricing Enquiry - job title
	By jobTitle = By.xpath("//input[contains(@id,'jobtitle')]");

	// Pricing Enquiry - DescribeYourself
	By DescribeYourself = By.xpath("//select[contains(@id,'how_would_you_describe_yourself')]");

	// Pricing Enquiry - ServiceCheckBoxes
	By ServicesList = By.xpath("//li[@class='hs-form-checkbox']//span");

	// Pricing Enquiry - ServiceCheckboxList
	By ServiceCheckboxList = By.xpath("//input[contains(@id,'pricingcalc_what_services_do_you_require')]");

	// Pricing Enquiry - GetAPriceButton
	By GetAPriceButton = By.xpath("//input[@class='hs-button primary large']");
	
	// Pricing Enquiry - Confirmation Message
	By ConfirmationMessage = By.xpath("//div[@class='hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_rich_text']//h2");
	
	public void EnterFirstName( String FirstName)
	{
		Driver.findElement(firstName).sendKeys(FirstName);
	}
	
	public void EnterLastName( String LastName)
	{
		Driver.findElement(lastName).sendKeys(LastName);
	}

	public void EnterCompanyName( String CompanyName)
	{
		Driver.findElement(companyName).sendKeys(CompanyName);
	}
	
	public void EnterCompanyEmail( String CompanyEmail)
	{
		Driver.findElement(companyEmail).sendKeys(CompanyEmail);
	}
	
	public void EnterPhoneNumber( String PhoneNumber)
	{
		Driver.findElement(phoneNumber).sendKeys(PhoneNumber);
	}
	
	public void EnterJobTitle( String JobTitle)
	{
		Driver.findElement(jobTitle).sendKeys(JobTitle);
	}
	
	public void SelectDescribeYorSelf( String DescribeYorSelf)
	{
		SelectFromDropdown(DescribeYourself, DescribeYorSelf);
	}
	
	public void ClickServiceCheckBox( String Service)
	{
		ClickCheckBox(ServiceCheckboxList, Service);
	}
	
	public void ClickGetAPriceButton() {
		
		Driver.findElement(GetAPriceButton).click();

	}

	public void SelectFromDropdown(By locator, String value) {
		WebElement ele = Driver.findElement(locator);

		Select sel = new Select(ele);

		sel.selectByVisibleText(value);
	}

	public String getText()
	{
		return Driver.findElement(ConfirmationMessage).getText();
	}
	
	private void ClickCheckBox(By locator, String value) {

		int count = 0;

		Collection<WebElement> servicesList = Driver.findElements(ServicesList);

		for (WebElement item : servicesList) {

			if (item.getText().equals(value)) {
				Driver.findElements(ServiceCheckboxList).get(count).click();
				break;
			}
			count++;

		}	

	}
	
}
