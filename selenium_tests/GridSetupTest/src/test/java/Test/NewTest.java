package Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
	WebDriver driver;
	 @Test
	  public void eLearnPortalTest() throws MalformedURLException {
		 
				  
				    try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}  
			       driver.navigate().to("https://idp.bits-pilani.ac.in/idp/Authn/UserPassword");
			       String buttonTest = driver. findElement(By.id("submitbtn")).getAttribute("type");
			       org.testng.Assert.assertEquals(buttonTest, "submit");
			
			 
			
	  }
	 
	 @Test
		public void test3() {
		driver.navigate().to("https://idp.bits-pilani.ac.in/idp/Authn/UserPassword");
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2020HS70025@wilp.bits-pilani.ac.in");
		 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Password.password);
		 driver. findElement(By.id("submitbtn")).click();
		 driver. findElement(By.id("__eechatIcon")).click();
		 String ActualTitle = driver.getTitle();
		 Assert.assertEquals(ActualTitle, "e-Learning Portal");
		 driver.quit();	
		}
  @BeforeTest
  public void beforeMethod() throws MalformedURLException {
	//1. define desired capabilities
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			
			//2. chrome options def
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);
			
			
			//Mention where the hub is running:
			String hubUrl = "http://a0b6cb0335c154bc2bb59e505114fd95-954136925.eu-central-1.elb.amazonaws.com:4444/wd/hub";
			  driver = new RemoteWebDriver(new URL(hubUrl),options);
  }

  @AfterTest
  public void afterMethod() {
      driver.quit();
  }

}
