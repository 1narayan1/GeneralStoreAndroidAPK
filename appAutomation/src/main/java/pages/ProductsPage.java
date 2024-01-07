package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Build;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductsPage extends Build {
	
	AndroidDriver driver;
	
	By pageTitle = By.id("com.androidsample.generalstore:id/toolbar_title");
	By firstProduct = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));");
	By ProductAddToCart = By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']");
	By cartValue = By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/counterText']");
	By cartButton = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
	By purchaseAmount = By.id("com.androidsample.generalstore:id/totalAmountLbl");
	
	public ProductsPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void printPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
	}
	
	public void addingProductToCart() {
		driver.findElement(firstProduct);
		driver.findElement(ProductAddToCart).click();
	}
	
	public void cartQuantity() {
		driver.findElement(cartValue);
	}
	
	public void cartClick() {
		driver.findElement(cartButton).click();
	}
	
	public void totalPurchaseAmount() {
		driver.findElement(purchaseAmount);
	}
	
	
}
