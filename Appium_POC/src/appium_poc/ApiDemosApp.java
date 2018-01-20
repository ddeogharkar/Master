package appium_poc;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ApiDemosApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File file = new File("src");
		File apppath = new File(file, "1_2_008.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, apppath.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4d00a95f4fde3117");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// TouchAction act = new TouchAction(driver);
		/*
		 * driver.findElement(By.xpath(
		 * "//android.widget.TextView[@text='Preference']")).click();
		 * Thread.sleep(3000); driver.findElement(By.xpath(
		 * "//android.widget.TextView[@text='3. Preference dependencies']"
		 * )).click(); Thread.sleep(3000);
		 * 
		 * System.out.println(driver.findElementsByAndroidUIAutomator(
		 * "new UiSelector().checkable(true)").size());
		 * driver.findElement(By.id("android:id/checkbox")).click();
		 * driver.findElement(By.xpath(
		 * "//android.widget.TextView[@text='WiFi settings']")).click();
		 * driver.findElement(By.id("android:id/edit")).sendKeys("DevNet");
		 * 
		 * driver.findElement(By.id("android:id/button1")).click();
		 * driver.navigate().back();
		 * 
		 * driver.navigate().back();
		 */
		/*
		 * driver.findElementByAndroidUIAutomator(
		 * "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));"
		 * ); driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		 * driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")"
		 * ).click(); WebElement src =
		 * driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		 * act.longPress(src).longPress(src).perform(); // WebElement dest = //
		 * driver.findElement(By.id("io.appium.android.apis:id/drag_dot_hidden")
		 * );
		 * 
		 * act.longPress(src).waitAction().moveTo(driver.findElement(By.id(
		 * "io.appium.android.apis:id/drag_dot_hidden"))) .release().perform();
		 */

		/*
		 * driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")"
		 * ).click();
		 * 
		 * driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")"
		 * ).click(); WebElement el = driver.findElementByAndroidUIAutomator(
		 * "text(\"People Names\")"); TouchAction act = new
		 * TouchAction(driver).longPress(el).perform(); act.release().perform();
		 */

	}

}
