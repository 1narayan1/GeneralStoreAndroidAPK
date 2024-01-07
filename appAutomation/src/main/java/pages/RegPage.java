package pages;

import org.openqa.selenium.By;

import configurations.Build;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class RegPage extends Build{
	
	AndroidDriver driver;
	
	By countryDropdown = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
	By countrySelect = By.xpath("//android.widget.TextView[@text='Angola']");
	By nameInput = By.id("com.androidsample.generalstore:id/nameField");
	By genderClick = By.id("com.androidsample.generalstore:id/radioMale");
	By letsShop = By.id("com.androidsample.generalstore:id/btnLetsShop");
	
	
	public RegPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void selectingCountry() throws InterruptedException {
		driver.findElement(countryDropdown).click();
		Thread.sleep(2000);
		driver.findElement(countrySelect).click();
	}
	
	public void nameInputField() {
		driver.findElement(nameInput).sendKeys("Narayan");
	}
	
	public void genderSelect() {
		driver.findElement(genderClick).click();
	}
	
	public void submitButtonClick() {
		driver.findElement(letsShop).click();
	}

}
