package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import configurations.Build;
import io.appium.java_client.AppiumBy;
import pages.RegPage;

public class RegPageTest extends Build {
	RegPage reg;

	@Test
	public void fillingData() throws InterruptedException {
		reg = new RegPage(driver);
		//Selecting dropDown
		reg.selectingCountry();
		String countryName = driver.findElement(AppiumBy.id("android:id/text1")).getText();
		Assert.assertEquals(countryName, "Angola");
		
		//sending name in input field
		reg.nameInputField();
		String name = driver.findElement(By.className("android.widget.EditText")).getText();
		Assert.assertEquals(name, "Narayan");
		
		//Selecting gender
		reg.genderSelect();
		String gender = driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).getText();
		Assert.assertEquals(gender, "Male");
		
		//Lets shop click
		reg.submitButtonClick();
	}
	
	

	

}
