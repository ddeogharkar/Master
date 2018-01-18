package appium_poc;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumPractice {
	public static String appium_node_path = "C:\\Program Files\\nodejs\\node.exe";
	public static AppiumDriverLocalService service;
	public static URL url;
	public static String Service_url;

	@Test
	public void Test2() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File(appium_node_path)).usingPort(4723));

		service.start();
		Thread.sleep(5000);

		Service_url = service.getUrl().toString();

		DesiredCapabilities capabilities = DesiredCapabilities.android();

		// set the capability to execute test in chrome browser
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

		// set the capability to execute our test in Android Platform
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

		// we need to define platform name
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		// Set the device name as well (you can give any name)
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4d00a95f4fde3117");

		// set the android version as well
		capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");

		// Create object of URL class and specify the appium server address
		// URL url = new URL("http://127.0.0.1:4723/wd/hub");

		WebDriver driver = new AndroidDriver(new URL(Service_url), capabilities);

		service.stop();

		// WebDriver driver2 = new IOSDriver(url, capabilities);

	}

}
