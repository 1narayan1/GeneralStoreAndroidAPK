package configurations;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pages.ProductsPage;
import pages.RegPage;

public class Build {
	
	public AppiumDriverLocalService service;
	public static AndroidDriver driver;
	RegPage page;
	ProductsPage propage;
	
	@BeforeSuite
	public void serverSetUp() {
		
		/* Initially we need to start the server
		 * so we will start the server using AppiumDriverLocalService
		 * & then we will create an object by the help of instance we will
		 * start the service
		 */
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\asus\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
				                      .withIPAddress("127.0.0.1").usingPort(4723).build();
		 //service.start();
					                   
	}
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void initializingDriver() throws MalformedURLException {
		
		UiAutomator2Options option = new UiAutomator2Options();
		option.setCapability("deviceName", "Pixel 7 Pro");
		option.setCapability("platformName", "Android");
		option.setCapability("app", "C:\\Users\\asus\\eclipse-workspace\\App_Automation\\resource\\General-Store.apk");
		String ip = "http://127.0.0.1:4723";
		
		// Creating instance of AndroidDriver
		driver = new AndroidDriver(new URL(ip),option);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	
	@AfterSuite
	public void serverStop() {
		//service.stop();
	}
 
}
