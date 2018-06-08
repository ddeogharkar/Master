package com.Bugfinders.Helpers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportHelper {

	public static ExtentReports extentreport;
	public static ExtentTest extenttest;

	public static void ExtentReportInit() {
		// TODO Auto-generated method stub

		extentreport = new ExtentReports(System.getProperty("user.dir")+"/com.Bugfinders/ExtentReports/AutomationReports.html");
		extentreport.loadConfig(new File(System.getProperty("user.dir") + "\\src\\com\\Bugfinders\\Resources\\extent-config.xml"));
		Map<String, String> sysInfo = new HashMap<String, String>();
		sysInfo.put("Selenium Version", "3.11");
		sysInfo.put("Environment", "QA");

		extentreport.addSystemInfo(sysInfo);

	}

	public static void ExtentReportClose() {
		extentreport.flush();
		extentreport.close();
	}

}
