package automationlab;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Registration {
	
	public static String dob = "03 31 1967";
	String baseUrl = "https://stg-start.newtopia.com/#/registration/1";
	// String baseUrl = "https://google.com";
	Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriver driver = new ChromeDriver();

	@Test
	public void Test() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		String expectedTitle = "Newtopia Personal Profile";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Not the expected title");
		log.debug("Expected Title is: Newtopia Personal Profile");
	}

	@AfterMethod
	public void home() throws InterruptedException {
		Thread.sleep(1000);
	}

	@AfterTest(enabled = false)
	public void end() {
		driver.quit();
	}

	@Test(priority = 1, enabled = true)
	public void fname() {
		WebElement myElement = driver.findElement(By.name("FirstName"));
		myElement.sendKeys("Bred");
		log.debug("First name entered");
		Assert.assertNotNull(myElement, "Firstname not found");
		log.debug("First name is not null");
		Assert.assertNotEquals(myElement.getAttribute("value"), "", "FirstName is empty");
		log.debug("First name is not empty");
	}

	@Test(priority = 2, enabled = true)
	public void lname() {

		WebElement myElement2 = driver.findElement(By.name("LastName"));
		myElement2.sendKeys("Jones");
		log.debug("last name entered");
		// System.out.println(myElement2.getAttribute("value"));
		Assert.assertNotNull(myElement2, "Lastname not found");
		log.debug("Last name is not null");
		Assert.assertNotEquals(myElement2.getAttribute("value"), "", "LastName is empty");
		log.debug("Last name is not empty");
	}

	@Test(priority = 3, enabled = true)
	public void wrongemail() throws InterruptedException {
		WebElement myElement3 = driver.findElement(By.name("EmailAddress"));
		myElement3.sendKeys("norha@com");
		log.debug("wrong email entered");
		Thread.sleep(1000);
		myElement3.sendKeys(Keys.TAB);
		myElement3.clear();
		WebElement myElement4 = driver
				.findElement(By.cssSelector("[data-reactid='.0.2.0.0.0.0.$0.3:$EmailAddress.0.4']"));
		Assert.assertEquals((myElement4.getText()), "Please enter a valid email address.",
				"Expected error message does not match with text: Please enter a valid email address.");
		log.debug(
				"Checked if correct error message apppears on entering wrong email address:Please enter a valid email address. ");
		// to show delete s from address (second comment above) on the expected.

	}

	@Test(priority = 4, enabled = true)
	public void email() {
		WebElement myElement3 = driver.findElement(By.name("EmailAddress"));
		myElement3.sendKeys("charanjit55588+61@gmail.com");
		log.debug("Email entered");
		Assert.assertNotNull(myElement3, "email not found");
		log.debug("Email name is not null");
		Assert.assertNotEquals(myElement3.getAttribute("value"), "", "email is empty");
		log.debug("Email name is not empty");
	}

	@Test(priority = 5, enabled = true)
	public void password1() {
		WebElement myElement4 = driver.findElement(By.name("Password"));
		myElement4.sendKeys("Passw0rd");
		log.debug("Email entered");
		Assert.assertNotNull(myElement4, "Password not found");
		log.debug("Password is not null");
		Assert.assertNotEquals(myElement4.getAttribute("value"), "", "Password is empty");
		log.debug("Password is not empty");
	}

	@Test(priority = 6, enabled = true)
	public void password2() {
		WebElement myElement5 = driver.findElement(By.name("ConfirmPassword"));
		myElement5.sendKeys("Passw0rd");
		log.debug("Confirm Password entered");

		Assert.assertNotNull(myElement5, "ConfirmPassword not found");
		log.debug("Confirm Password is not null");

		Assert.assertNotEquals(myElement5.getAttribute("value"), "", "ConfirmPassword is empty");
		log.debug("Confirm Password is not empty");

		// to make sure the both passwords are same
		WebElement myElement4 = driver.findElement(By.name("Password"));
		// System.out.println(myElement4.getAttribute("value"));
		Assert.assertEquals(myElement4.getAttribute("value"), myElement5.getAttribute("value"),
				"ConfirmPassword doesnot match with Password");
		log.debug("Checked Password matches with the Confirm Password");
	}

	@Test(priority = 7, enabled = true)
	public void unacceptableyeardob() throws InterruptedException {
		WebElement myElement6 = driver.findElement(By.name("DateOfBirth"));
		myElement6.sendKeys("09 10 1875");
		log.debug("Invalid year DOB entered");

		Thread.sleep(1000);

		Assert.assertNotNull(myElement6, "DateOfBirth not found");
		log.debug("Invalid year DOB is not null");

		Assert.assertNotEquals(myElement6.getAttribute("value"), "", "DateOfBirth is empty");
		log.debug("Invalid year DOB is not empty");

		myElement6.sendKeys(Keys.TAB);
		myElement6.clear();

		WebElement myElement7 = driver
				.findElement(By.cssSelector("[data-reactid='.0.2.0.0.0.0.$0.3:$DateOfBirth.0.4']"));
		Assert.assertEquals((myElement7.getText()), "Year must be greather than 1900",
				"Expected error message does not match with text: Year must be greather than 1900");
		log.debug("Checked on entering invalid year DOB: Year must be greather than 1900 should be displayed");
		// to show delete one 0 from 1900 on the expected.

	}

	@Test(priority = 8, enabled = true)
	public void invalidmonthdob() throws InterruptedException {
		WebElement myElement6 = driver.findElement(By.name("DateOfBirth"));
		myElement6.sendKeys("13 10 1975");
		log.debug("Invalid month DOB entered");

		Thread.sleep(1000);

		Assert.assertNotNull(myElement6, "DateOfBirth not found");
		log.debug("Invalid month DOB is not null");
		Assert.assertNotEquals(myElement6.getAttribute("value"), "", "DateOfBirth is empty");
		log.debug("Invalid month DOB is not empty");

		myElement6.sendKeys(Keys.TAB);
		myElement6.clear();

		WebElement myElement7 = driver
				.findElement(By.cssSelector("[data-reactid='.0.2.0.0.0.0.$0.3:$DateOfBirth.0.4']"));
		Assert.assertEquals((myElement7.getText()), "Date of birth must be a valid date.",
				"Expected error message does not match with text: Date of birth must be a valid date.");
		log.debug("Checked on entering invalid month DOB: Date of birth must be a valid date should be displayed");

	}

	@Test(priority = 9, enabled = true)
	public void invaliddatedob() throws InterruptedException {
		WebElement myElement6 = driver.findElement(By.name("DateOfBirth"));
		myElement6.sendKeys("10 32 1975");
		log.debug("Invalid date DOB entered");
		Thread.sleep(1000);

		Assert.assertNotNull(myElement6, "DateOfBirth not found");
		log.debug("Invalid date DOB is not null");
		Assert.assertNotEquals(myElement6.getAttribute("value"), "", "DateOfBirth is empty");
		log.debug("Invalid date DOB is not empty");

		myElement6.sendKeys(Keys.TAB);
		myElement6.clear();

		WebElement myElement7 = driver
				.findElement(By.cssSelector("[data-reactid='.0.2.0.0.0.0.$0.3:$DateOfBirth.0.4']"));
		Assert.assertEquals((myElement7.getText()), "Date of birth must be a valid date.",
				"Expected error message does not match with text: Date of birth must be a valid date.");
		log.debug("Checked on entering invalid date DOB: Date of birth must be a valid date should be displayed");

	}

	@Test(priority = 10, enabled = true)
	public void skipyeardatedob() throws InterruptedException {
		WebElement myElement6 = driver.findElement(By.name("DateOfBirth"));
		myElement6.sendKeys("10 32     ");
		log.debug("Skipped year DOB entered");
		Thread.sleep(1000);

		Assert.assertNotNull(myElement6, "DateOfBirth not found");
		log.debug("Invalid (skipped year) DOB is not null");
		Assert.assertNotEquals(myElement6.getAttribute("value"), "", "DateOfBirth is empty");
		log.debug("Invalid (skipped year) DOB is not empty");

		myElement6.sendKeys(Keys.TAB);
		myElement6.clear();

		WebElement myElement7 = driver
				.findElement(By.cssSelector("[data-reactid='.0.2.0.0.0.0.$0.3:$DateOfBirth.0.4']"));
		Assert.assertEquals((myElement7.getText()), "Date of birth must be a valid date.",
				"Expected error message does not match with text: Date of birth must be a valid date.");
		log.debug(
				"Checked on entering invalid (skipped year) DOB: Date of birth must be a valid date should be displayed");

	}

	@Test(priority = 11, enabled = true)
	public void dateofbirth() {

		WebElement myElement8 = driver.findElement(By.name("DateOfBirth"));
		myElement8.sendKeys(dob);
		log.debug("Valid DOB entered");
		Assert.assertNotNull(myElement8, "DateOfBirth not found");
		log.debug("Valid DOB is not null");
		Assert.assertNotEquals(myElement8.getAttribute("value"), "", "DateOfBirth is empty");
		log.debug("Valid DOB is not empty");
		// dob = myElement8.getAttribute("value");

	}

	@Test(priority = 12, enabled = true)
	public void insuranceid() {
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement myElement7 = driver.findElement(By.name("InsuranceID"));
		myElement7.sendKeys("WW26935240");
		log.debug("Insurance Id entered");
		Assert.assertNotNull(myElement7, "InsuranceID not found");
		log.debug("Insurance ID is not null");
		Assert.assertNotEquals(myElement7.getAttribute("value"), "", "InsuranceID is empty");
		log.debug("Insurance ID is not empty");
	}

	@Test(priority = 13, enabled = true)
	public void employername() {
		WebElement myElement8 = driver.findElement(By.name("EmployerCompanyName"));
		myElement8.sendKeys("Newtopia");
		log.debug("Company name entered");
		Assert.assertNotNull(myElement8, "EmployerCompanyName not found");
		log.debug("Employer name is not null");
		Assert.assertNotEquals(myElement8.getAttribute("value"), "", "EmployerCompanyName is empty");
		log.debug("Employer name is not empty");
	}

	@Test(priority = 14, enabled = true)
	public void phoneno() {
		WebElement myElement9 = driver.findElement(By.name("PhoneBestNumber"));
		myElement9.sendKeys("(610)-349-1537");
		log.debug("Company name entered");
		Assert.assertNotNull(myElement9, "PhoneBestNumber not found");
		log.debug("Phone no is not null");
		Assert.assertNotEquals(myElement9.getAttribute("value"), "", "PhoneBestNumber is empty");
		log.debug("Phone no is not empty");
	}

	@Test(priority = 15, enabled = true)
	public void nextbutton() {
		driver.findElement(By.className("NButton"));
		driver.findElement(By.className("NButton")).click();
		log.debug("Next Button cliked on Registration page 1");
	}

	@Test(priority = 16, enabled = true)
	public void nicname() throws InterruptedException {
		Thread.sleep(1000);
		WebElement myElement10 = driver.findElement(By.name("NewtopiaProfileName"));
		myElement10.sendKeys("EDNA");
		log.debug("Nic name is entered");
		Assert.assertNotNull(myElement10, "NewtopiaProfileName not found");
		log.debug("Nic name is not null");
		Assert.assertNotEquals(myElement10.getAttribute("value"), "", "NewtopiaProfileName is empty");
		log.debug("Nic name is not empty");
	}

	@Test(priority = 17, enabled = true)
	public void photo() {
		By byCss = By.cssSelector("[name='ProfilePhoto'][value='1'][type='radio']");
		driver.findElement(byCss).click();

	}

	@Test(priority = 18, enabled = true)
	public void photo1() {
		By byCss1 = By.cssSelector("[class='avatar-image '][data-image-number='1']");
		driver.findElement(byCss1).click();
		log.debug("Avatar is selected");
	}

	@Test(priority = 19, enabled = true)
	public void address() {
		WebElement myElement11 = driver.findElement(By.name("AddressLine1"));
		myElement11.sendKeys("20 York Mills Road");
		log.debug("Address line 1 is entered");
		Assert.assertNotNull(myElement11, "AddressLine1 not found");
		log.debug("Address line 1 is not null");
		Assert.assertNotEquals(myElement11.getAttribute("value"), "", "AddressLine1 is empty");
		log.debug("Address line 1 is not empty");
	}

	@Test(priority = 20, enabled = true)
	public void state() {
		WebElement DropDown = driver.findElement(By.className("InputWithPopup-input"));
		DropDown.sendKeys("Pennsylvania");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("List-option")).click();
		// No assertion added
	}

	@Test(priority = 21, enabled = true)
	public void city() {
		WebElement myElement13 = driver.findElement(By.name("AddressCity"));
		myElement13.sendKeys("North York");
		log.debug("City is entered");
		Assert.assertNotNull(myElement13, "AddressCity not found");
		log.debug("City is not Null");
		Assert.assertNotEquals(myElement13.getAttribute("value"), "", "AddressCity is empty");
		log.debug("City is not empty");

	}

	@Test(priority = 22, enabled = true)
	public void zipcode() {
		WebElement myElement14 = driver.findElement(By.name("AddressZip"));
		myElement14.sendKeys("19534");
		log.debug("Zip is entered");
		Assert.assertNotNull(myElement14, "AddressZip not found");
		log.debug("City is not Null");
		Assert.assertNotEquals(myElement14.getAttribute("value"), "", "AddressZip is empty");
		log.debug("City is not empty");
	}

	@Test(priority = 23, enabled = true)
	public void nextbutton2() {
		By byCss4 = By.cssSelector("[class='NButton  primary '][data-reactid='.0.2.0.0.0.0.2.1.0.1']");
		driver.findElement(byCss4).click();
		log.debug("Next Button cliked on Registration page 2");

	}

	@Test(priority = 24, enabled = true)
	public void checkbox1() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// Create instance of Javascript executor 1
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.className("participant"));
		// now execute query which actually will scroll until that element is
		// not appeared on page
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		JavascriptExecutor je11 = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element11 = driver.findElement(By.className("NAgreement"));
		// now execute query which actually will scroll until that element is
		// not appeared on page
		je11.executeScript("arguments[0].scrollIntoView(true);", element11);

		Thread.sleep(1000);

		By byCss16 = By.cssSelector("[data-reactid='.0.2.0.0.0.0.$2.3:$ExpressConsentGenetic.0.3']");
		driver.findElement(byCss16).click();
		log.debug("First Checkbox is clicked");
	}

	@Test(priority = 25, enabled = true)
	public void checkbox2() throws InterruptedException {

		// Create instance of Javascript executor 2
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element1 = driver.findElement(By.cssSelector("[href='mailto:privacy@newtopia.com']"));
		je1.executeScript("arguments[0].scrollIntoView(true);", element1);

		Thread.sleep(1000);

		By byCss9 = By.cssSelector(
				"[name='ExpressConsentCSA'][type='checkbox'][data-reactid='.0.2.0.0.0.0.$2.3:$ExpressConsentCSA.0.3.0']");
		driver.findElement(byCss9).click();
		log.debug("Second Checkbox is clicked");

		Thread.sleep(1000);
	}

	@Test(priority = 26, enabled = true)
	public void submit() throws InterruptedException {
		By byCss6 = By.cssSelector("[class='NButton  primary '][data-reactid='.0.2.0.0.0.0.2.1.0.1']");
		driver.findElement(byCss6).click();
		log.debug("Submit button is clicked");
		Thread.sleep(4000);
	}

}
