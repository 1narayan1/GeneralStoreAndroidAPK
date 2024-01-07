package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import configurations.Build;
import pages.ProductsPage;

public class ProductPageTest extends Build {
	
	ProductsPage propage;
	
	@Test
	public void addingProducts() {
		propage = new ProductsPage(driver);
		
		//get PageTitle
		propage.printPageTitle();
		String title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
		Assert.assertEquals(title, "Products");
		
		//adding 1st product to cart
		propage.addingProductToCart();
		
		//validating cart quantity
		propage.cartQuantity();
		String count = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/counterText']")).getText();
		Assert.assertEquals(count, "1");
		
		//clicking on cart
		propage.cartClick();
		
		//validating purchase amount value
		propage.totalPurchaseAmount();
		String amount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println("Total Purchase Amount: " + amount);
		Assert.assertEquals(amount, "$ 165.0");
	}
}
