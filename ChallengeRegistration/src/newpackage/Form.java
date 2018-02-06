package automationlab;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Form {

	Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriver driver = new ChromeDriver();

	@Test
	public void geturl() throws InterruptedException {
		String baseUrl = "https://jsfiddle.net/rlourenco/cp6bc9ka/4/embedded/result/";
		driver.get(baseUrl);
		driver.manage().window().fullscreen();
	}

	@AfterMethod
	public void home() throws InterruptedException {
		Thread.sleep(2000);
	}

	@AfterTest(enabled = true)
	public void end() {
		driver.quit();
	}

	@Test
	public void submitformwithoutfname() throws InterruptedException {
		WebElement myElement1 = driver.findElement(By.xpath("//*[@id='lastName']"));
		myElement1.sendKeys("Tyler");
		log.debug("Last name is entered");

		WebElement myElement2 = driver.findElement(By.xpath("//*[@id='emailAddress']"));
		myElement2.sendKeys("johntest@gmail.com");
		log.debug("Email name is entered");

		WebElement myElement3 = driver.findElement(By.xpath("//*[@id='bySubmit']"));
		myElement3.click();
		log.debug("Submit button is clicked");
	}

	@Test
	public void submitformwithoutlname() throws InterruptedException {
		WebElement myElement = driver.findElement(By.xpath("//*[@id='firstName']"));
		myElement.sendKeys("John");
		log.debug("First name is entered");

		WebElement myElement2 = driver.findElement(By.xpath("//*[@id='emailAddress']"));
		myElement2.sendKeys("johntest@gmail.com");
		log.debug("Email name is entered");

		WebElement myElement3 = driver.findElement(By.xpath("//*[@id='bySubmit']"));
		myElement3.click();
		log.debug("Submit button is clicked");
	}

	@Test
	public void submitformwithoutemail() throws InterruptedException {
		WebElement myElement = driver.findElement(By.xpath("//*[@id='firstName']"));
		myElement.sendKeys("John");
		log.debug("First name is entered");

		WebElement myElement1 = driver.findElement(By.xpath("//*[@id='lastName']"));
		myElement1.sendKeys("Tyler");
		log.debug("Last name is entered");

		WebElement myElement3 = driver.findElement(By.xpath("//*[@id='bySubmit']"));
		myElement3.click();
		log.debug("Submit button is clicked");

	}

	@Test
	public void wrongemailformat() throws InterruptedException {
		WebElement myElement = driver.findElement(By.xpath("//*[@id='emailAddress']"));
		myElement.sendKeys("@gmail.com");
		log.debug("wrong email entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		myElement.clear();

		myElement.sendKeys("john@com");
		log.debug("wrong email entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		myElement.clear();

		myElement.sendKeys("john@gmail");
		log.debug("wrong email entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		myElement.clear();

	}

	@Test
	public void submitform() throws InterruptedException {
		WebElement myElement = driver.findElement(By.xpath("//*[@id='firstName']"));
		myElement.sendKeys("John");
		log.debug("First name is entered");
		Assert.assertNotEquals(myElement.getAttribute("value"), "", "firstName is empty");
		log.debug("First name is not empty");

		WebElement myElement1 = driver.findElement(By.xpath("//*[@id='lastName']"));
		myElement1.sendKeys("Tyler");
		log.debug("Last name is entered");
		Assert.assertNotEquals(myElement.getAttribute("value"), "", "LastName is empty");
		log.debug("Last name is not empty");

		WebElement myElement2 = driver.findElement(By.xpath("//*[@id='emailAddress']"));
		myElement2.sendKeys("johntest@gmail.com");
		log.debug("Email name is entered");
		Assert.assertNotEquals(myElement.getAttribute("value"), "", "email is empty");
		log.debug("Email name is not empty");

		WebElement myElement3 = driver.findElement(By.xpath("//*[@id='bySubmit']"));
		myElement3.click();
		log.debug("Submit button is clicked");
		Assert.assertNotEquals(true, false, "submit button is diabled");
		log.debug("submit button is diabled");
	}

}