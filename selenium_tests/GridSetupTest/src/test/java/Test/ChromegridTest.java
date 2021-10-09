package Test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromegridTest {

	WebDriver driver;
	@Before
    public  void setup() throws MalformedURLException {
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
	
	@Test
	public void testAssertFunctions() {
	driver.navigate().to("https://www.browserstack.com/");
	String ActualTitle = driver.getTitle();
	String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
	 Assert.assertEquals(ExpectedTitle, ActualTitle);
	 driver.quit();
	}
	
	@Test
	public void test2() {
	driver.navigate().to("https://idp.bits-pilani.ac.in/idp/Authn/UserPassword");
	String buttonTest = driver. findElement(By.id("submitbtn")).getAttribute("type");
	Assert.assertEquals(buttonTest, "submit");
	 driver.quit();		
	}
	@Test
	public void test3() {
	driver.navigate().to("https://idp.bits-pilani.ac.in/idp/Authn/UserPassword");
	 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2020HS70005@wilp.bits-pilani.ac.in");
	 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Password.password);
	 driver. findElement(By.id("submitbtn")).click();
	 driver. findElement(By.id("__eechatIcon")).click();
	 String ActualTitle = driver.getTitle();
	 Assert.assertEquals(ActualTitle, "e-Learning Portal");
	 driver.quit();	
	}
}
