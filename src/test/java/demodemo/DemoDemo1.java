package demodemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDemo1 {
	public static WebDriver driver;
	JavascriptExecutor js;
	String baseUrl = "https://ecommerce.dashitsolutions.com/abante/";
	
	@BeforeMethod
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
	}
	@AfterMethod
	public void setDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void ecomDashIt() throws Exception {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement skincareElement=driver.findElement(By.linkText("SKINCARE"));
		Actions act=new Actions(driver);
		act.moveToElement(skincareElement).perform();
		WebElement eyesElement=driver.findElement(By.linkText("Eyes"));
		act.moveToElement(eyesElement).click().perform();
		js.executeScript("window.scrollBy(0, 400)");
		driver.findElement(By.xpath("//div[@class='contentpanel']//div[1]//div[2]//a[1]//img[1]")).click();
        String actualUrl="http://ecommerce.dashitsolutions.com/abante/index.php?rt=product/product&path=43_47&product_id=65";
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,currentUrl);
		System.out.println(currentUrl);

	}


}