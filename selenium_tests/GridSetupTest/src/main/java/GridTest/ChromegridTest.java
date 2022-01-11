package GridTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ChromegridTest {

	public static void main(String[] args) throws MalformedURLException {
		
		//1. define desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.LINUX);
		
		//2. chrome options def
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		
		
		//Mention where the hub is running:
		String hubUrl = "http://a0b6cb0335c154bc2bb59e505114fd95-954136925.eu-central-1.elb.amazonaws.com:4444/wd/hub";
		 WebDriver driver = new RemoteWebDriver(new URL(hubUrl),options);
		 
		  driver.get("https://idp.bits-pilani.ac.in/idp/Authn/UserPassword");
		
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Let the user actually see something!
		    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        //Copy the file to a location and use try catch block to handle exception
	        try {
	            FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshot.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        
	        driver.close();

	}
	
	

}
