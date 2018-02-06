package newpackage;

import static org.testng.Assert.assertEquals;

import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Screener;

public class Frontpage {
	// To do - Ask Range of BMI values , randomly select check boxes for health options
	String baseUrl = "";
	//https://cloud.my.newtopia.com/jpmcpilot
	public static WebDriver driver;
	Screener sof;

	@Test(priority = 1, enabled = true)
	public void Setup() {
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
	}

	@AfterMethod(enabled = true)
	public void home() throws InterruptedException {
		Thread.sleep(1000);
	}

	@AfterTest(enabled = true)
	public void end() {
		driver.quit();
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	@Test(priority = 3, enabled = true)
	public void ineligiblepregnant() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		sof = new Screener(driver);
		Thread.sleep(4000);
		sof.clickCurrentlypregnantcheckbox();
		sof.clickcheckeligibilty();
		String actual = "The Newtopia Program is beneficial to employees that are at risk for chronic diseases. Right now you are not at risk (which is good!). Please contact your HR department for other programs that might be more suitable for you.";
		String expected = sof.verifynoteligiblemessage();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 4, enabled = true)
	public void inegligiblebmi27() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		sof = new Screener(driver);
		Thread.sleep(4000);

		sof.inputweight(getRandomNumberInRange(20, 190));
		sof.inputheight(getRandomNumberInRange(70, 100));
		sof.calculateBMI();
		sof.clickcheckeligibilty();
		String actual = "The Newtopia Program is beneficial to employees that are at risk for chronic diseases. Right now you are not at risk (which is good!). Please contact your HR department for other programs that might be more suitable for you.";
		String expected = sof.verifynoteligiblemessage();
		Assert.assertEquals(actual, expected);

	}
	
	@Test(priority = 5, enabled = true)
	public void inegligiblenl1healthcondition() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		sof = new Screener(driver);
		Thread.sleep(4000);
		sof.clickbloodglucose();   		
		sof.clickcheckeligibilty();
		String actual = "The Newtopia Program is beneficial to employees that are at risk for chronic diseases. Right now you are not at risk (which is good!). Please contact your HR department for other programs that might be more suitable for you.";
		String expected = sof.verifynoteligiblemessage();
		Assert.assertEquals(actual, expected);

	}
	
	@Test(priority = 6, enabled = true)
	public void eligibleBMI28() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		sof = new Screener(driver);
		Thread.sleep(4000);
		sof.clickBMIcheckbox();  		
		sof.clickcheckeligibilty();
		String actual = "You are eligible for the Newtopia Program.";
		String expected = sof.verifyeligiblemessage();
		Assert.assertEquals(actual, expected);


	}
	@Test(priority = 7, enabled = true)
	public void egligiblebmiuserinput() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		sof = new Screener(driver);
		Thread.sleep(4000);

		sof.inputweight(getRandomNumberInRange(20, 190));
		sof.inputheight(getRandomNumberInRange(20, 69));
		sof.calculateBMI();
		sof.clickcheckeligibilty();
		String actual = "You are eligible for the Newtopia Program.";
		String expected = sof.verifyeligiblemessage();
		Assert.assertEquals(actual, expected);

	}
	@Test(priority = 8, enabled = true)
	public void egligiblehealthoptions() throws InterruptedException {
		//Thread.sleep(2000);
		//Setup(); to open the driver again
		Thread.sleep(2000);
		driver.navigate().refresh();
		sof = new Screener(driver);
		Thread.sleep(4000);

		sof.clickbloodglucose();
		sof.clicktriglycerides();
		sof.clickcheckeligibilty();
		String actual = "You are eligible for the Newtopia Program.";
		String expected = sof.verifyeligiblemessage();
		Assert.assertEquals(actual, expected);

	}
}
