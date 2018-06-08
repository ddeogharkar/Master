package com.Bugfinders.Helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readConfigProperties {
	
	protected static Properties prop = null;
	protected static InputStream inputFile = null; 

	//***************** Method to Load Properties ************************************
	
	public readConfigProperties()
	{		
		try 
		{
			inputFile = readConfigProperties.class.getClassLoader().getResourceAsStream("com/Bugfinders/Resources/config.properties");
			prop = new Properties();
			prop.load(inputFile);
		} catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}
	
	//***************** Get Properties ************************************
	
	public String getUrl(){
		if(prop.getProperty("Url")==null)
			return "File Not Found";
		return prop.getProperty("Url");
	}
	
	public String getBrowser(){
		if(prop.getProperty("Browser")==null)
			return "File Not Found";
		return prop.getProperty("Browser");
	}
	
	public String getUserName(){
		if(prop.getProperty("UserName")==null)
			return "File Not Found";
		return prop.getProperty("UserName");
	}
	
	public String getPassword(){
		if(prop.getProperty("Password")==null)
			return "File Not Found";
		return prop.getProperty("Password");
	}
	
	public int getElementWait(){
		if(prop.getProperty("ElementWait")==null)
			return 0;
		return 	Integer.parseInt(prop.getProperty("ElementWait"));
	}
	
	public int getPageLoadWait(){
		if(prop.getProperty("PageLoadWait")==null)
			return 30;
		return 	Integer.parseInt(prop.getProperty("PageLoadWait"));
	}
	
	public String getDataFilePath(){
		if(prop.getProperty("DataFilePath")==null)
			return "File Not Found";
		return 	prop.getProperty("DataFilePath");
	}
	
	public String getTestDataSheetName(){
		if(prop.getProperty("TestDataSheetName")==null)
			return "File Not Found";
		return 	prop.getProperty("TestDataSheetName");
	}
	
	
	public static void main(String[] args) 
	{
		readConfigProperties obj = new readConfigProperties();
		System.out.println(obj.getUrl());

	}
	
	

}
