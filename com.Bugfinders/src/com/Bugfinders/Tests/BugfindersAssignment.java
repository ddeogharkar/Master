package com.Bugfinders.Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Bugfinders.Helpers.WindowHelper;
import com.Bugfinders.excel.dataProvider;
import com.Bugfinders.pages.BugfinderHomePage;
import com.Bugfinders.pages.BugfinderPricingEnquiryPage;
import com.Bugfinders.pages.BugfindersCaseStudiesPage;
import com.Bugfinders.pages.BugfindersWebTestingChecklistPage;
import com.Bugfinders.pages.BugfindersWhitePapersPage;
import com.Bugfinders.testBase.StartStopWebDriver;
import com.relevantcodes.extentreports.LogStatus;

public class BugfindersAssignment extends StartStopWebDriver 
{
	
	BugfinderHomePage homePage;
	BugfinderPricingEnquiryPage pricingEnquiryPage;
	BugfindersCaseStudiesPage caseStudiesPage;
	BugfindersWhitePapersPage whitePaper;
	BugfindersWebTestingChecklistPage webTestingChecklist;

	@Test(dataProvider="TC1",dataProviderClass=dataProvider.class,priority=1)
	public void SubmitPricingRequest(Map<String, Object> TestData) throws InterruptedException 
	{	
		extenttest = extentreport.startTest("SubmitPricingRequest Test Started");
		
		homePage = new BugfinderHomePage(driver);
		
		pricingEnquiryPage=homePage.ClickOnPricing();
		
		pricingEnquiryPage.EnterFirstName(TestData.get("FirstName").toString());
		
		pricingEnquiryPage.EnterLastName(TestData.get("LastName").toString());
		
		pricingEnquiryPage.EnterCompanyName(TestData.get("CompanyName").toString());
		
		pricingEnquiryPage.EnterCompanyEmail(TestData.get("CompanyEmail").toString());
		
		pricingEnquiryPage.EnterPhoneNumber(TestData.get("PhoneNumber").toString());
		
		pricingEnquiryPage.EnterJobTitle(TestData.get("JobTitle").toString());
		
		pricingEnquiryPage.SelectDescribeYorSelf(TestData.get("DescribeYourself").toString());
		
		pricingEnquiryPage.ClickServiceCheckBox(TestData.get("Service").toString());
		
		pricingEnquiryPage.ClickGetAPriceButton();
		
		Assert.assertEquals(pricingEnquiryPage.getText().trim(),TestData.get("ConfirmationMessage").toString().trim());			
		
		extenttest.log(LogStatus.PASS, "SubmitPricingRequest");
	}
	
	@Test(dataProvider="TC2",dataProviderClass=dataProvider.class,priority=2)
	public void DownloadCaseStudy(Map<String, Object> TestData) throws InterruptedException
	{
		extenttest = extentreport.startTest("DownloadCaseStudy Test Started");
		
		homePage = new BugfinderHomePage(driver);		
		
		homePage.ClickOnSuccess();
		
		caseStudiesPage = homePage.ClickOnCaseStudies();
		
		caseStudiesPage.ClickOnCaseStudy(TestData.get("CaseStudy").toString());
		
		WindowHelper.switchToWindow(1);
		
		caseStudiesPage.EnterFirstName(TestData.get("FirstName").toString());
		
		caseStudiesPage.EnterLastName(TestData.get("LastName").toString());
		
		caseStudiesPage.EnterCompanyEmail(TestData.get("CompanyEmail").toString());
		
		caseStudiesPage.ClickDownloadNowButton1();
		
		caseStudiesPage.ClickDownloadNowButton2();
		
		WindowHelper.switchToWindow(2);
		
		Assert.assertTrue(caseStudiesPage.getUrl().contains("https://cdn2.hubspot.net"));
		
		extenttest.log(LogStatus.PASS, "DownloadCaseStudy");	
		
	}
	
	@Test(dataProvider="TC3",dataProviderClass=dataProvider.class,priority=3)
	public void DownloadWebChecklist(Map<String, Object> TestData) throws InterruptedException
	{
		extenttest = extentreport.startTest("DownloadWebChecklist Test Started");
		
		homePage = new BugfinderHomePage(driver);		
		
		webTestingChecklist =homePage.ClickOnWebChecklist(TestData.get("Carousel").toString());
		
		webTestingChecklist.EnterFirstName(TestData.get("FirstName").toString());
		
		webTestingChecklist.EnterLastName(TestData.get("LastName").toString());
		
		webTestingChecklist.EnterCompanyEmail(TestData.get("CompanyEmail").toString());
		
		webTestingChecklist.ClickDownloadNowButton1();
		
		Assert.assertTrue(webTestingChecklist.getUrl().contains("https://cdn2.hubspot.net"));
		
		extenttest.log(LogStatus.PASS, "DownloadWebChecklist");
		
	}
	
	@Test(dataProvider="TC4",dataProviderClass=dataProvider.class,priority=4)
	public void DownloadWhitePaper(Map<String, Object> TestData) throws InterruptedException
	{
		extenttest = extentreport.startTest("DownloadWhitePaper Test Started");
		
		homePage = new BugfinderHomePage(driver);		
		
		homePage.ClickOnResources();
		
		whitePaper = homePage.ClickOnWhitePapers();
		
		whitePaper.ClickOnWhitePaper(TestData.get("WhitePaper").toString());
		
		WindowHelper.switchToWindow(1);
		
		whitePaper.EnterFirstName(TestData.get("FirstName").toString());
		
		whitePaper.EnterLastName(TestData.get("LastName").toString());
		
		whitePaper.EnterCompanyEmail(TestData.get("CompanyEmail").toString());
		
		whitePaper.ClickDownloadNowButton1();		
		
		whitePaper.ClickDownloadNowButton2();
		
		WindowHelper.switchToWindow(2);
		
		Assert.assertTrue(whitePaper.getUrl().contains("https://cdn2.hubspot.net"));
		
		extenttest.log(LogStatus.PASS, "DownloadWhitePaper");
		
		
		
	}

}
