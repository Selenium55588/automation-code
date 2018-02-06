package automationlab;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/*
 * Test scripts is for NORS with assertions.This version is for the Female.
 * Static values 10 & 11 is assigned to gender
 * e.g. 10 for female , 11 for male
 * 
 */
public class Testscript1 {
	static int gender;
	static String waist = "35";
	static String HeightFeet = "5";
	static String HeightInches = "3";
	static String WeightPounds = "170";
	static int groupB;
	String baseUrl = "https://stg-start.newtopia.com/nors/index.html#/screener/0?_k=nif7f4";
	Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriver driver = new ChromeDriver();

	@Test
	public void geturl() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		String expectedTitle = "Newtopia Personal Profile";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Not the expected title");
		log.debug("Expected Title is: Newtopia Personal Profile");
	}

	@AfterMethod
	public void home() throws InterruptedException {
		Thread.sleep(4000);
	}

	@Test(priority = 1, enabled = true)
	public void startbutton() throws InterruptedException {
		Thread.sleep(2000);
		WebElement myElement = driver.findElement(By.className("btn_blue"));
		myElement.click();
		log.debug("Start the NORS Project");
	}

	// Q1
	@Test(priority = 2, enabled = true)
	public void genderFemale1() {
		WebElement myElement = driver.findElement(By.className("nqa-gender-female"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		gender = 10;
		log.debug("Female gender selected");
	}

	@Test(priority = 3, enabled = false)
	public void genderMale1() {
		WebElement myElement = driver.findElement(By.className("nqa-gender-male"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		gender = 11;
		log.debug("Male gender selected");
	}

	// Q1.1
	@Test(priority = 4, enabled = true)
	public void diabetesYes1() {
		WebElement myElement = driver.findElement(By.className("nqa-pregnant-diabetes-yes"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		groupB = 1;
		log.debug("Diabetes Yes");
	}

	@Test(priority = 5, enabled = false)
	public void diabetesNo1() {
		WebElement myElement = driver.findElement(By.className("nqa-pregnant-diabetes-no"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		// log.debug("Diabetes No");
	}

	// Q1.2
	@Test(priority = 6, enabled = true)
	public void babyweightYes1() {
		WebElement myElement = driver.findElement(By.className("nqa-baby-weight-yes"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		groupB = 1;
		log.debug("Babyweight Yes");
	}

	@Test(priority = 7, enabled = false)
	public void babyweightNo1() {
		WebElement myElement = driver.findElement(By.className("nqa-baby-weight-no"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		log.debug("Babyweight No");
	}

	// Q1.3
	@Test(priority = 8, enabled = true)
	public void pregnantYes1() {
		WebElement myElement = driver.findElement(By.className("nqa-current-pregnant-yes"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		log.debug("pregnant Yes");
	}

	@Test(priority = 9, enabled = false)
	public void pregnantNo1() {
		WebElement myElement = driver.findElement(By.className("nqa-current-pregnant-no"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		log.debug("pregnant No");
	}

	// Q2
	@Test(priority = 10, enabled = false)
	public void ageYes1() {
		WebElement myElement = driver.findElement(By.className("nqa-over-40-yes"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		groupB = 1;
		log.debug("age40 Yes");
	}

	@Test(priority = 11, enabled = true)
	public void ageNo1() {
		WebElement myElement = driver.findElement(By.className("nqa-over-40-no"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();
		Assert.assertTrue(myElement.isSelected(), "Verify the radio box is selected");
		log.debug("age40 No");
	}

	// Q3
	@Test(priority = 12, enabled = true)
	public void heightinvalidminfeet1() throws InterruptedException {
		
		WebElement myElement = driver.findElement(By.className("nqa-height-feet"));

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("3");
		log.debug("Invalid min feet entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
        
		//checks the error message for invalid minimum feet input
		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.6.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Cannot be less than 4 feet",
				"Expected error message does not match with text: Oops! Cannot be less than 4 feet");
		log.debug("Checked on entering invalid feet: Oops! Cannot be less than 4 feet");
		Thread.sleep(1000);
		myElement.clear();

		// check the field should be empty -- added again to make sure its clear
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty");

	}

	@Test(priority = 13, enabled = true)
	public void heightinvalidmaxfeet1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-height-feet"));

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("10");
		log.debug("Invalid max feet entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
       
		//check the error message for invalid maximum feet input
		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.6.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Cannot be more than 9 feet",
				"Expected error message does not match with text: Oops! Cannot be more than 9 feet");
		log.debug("Checked on entering invalid date DOB:Oops! Cannot be more than 9 feet");

		Thread.sleep(1000);
		myElement.clear();

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty ");

	}

	@Test(priority = 14, enabled = true)
	public void heightinvalidformat1feet1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-height-feet"));

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("jhvj");
		log.debug("Character entered for feet field");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		
        // check the error message is as expected for invalid entry
		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.6.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text: Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB:Oops! Please use numbers only");

		Thread.sleep(1000);
		myElement.clear();

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty ");

	}

	@Test(priority = 15, enabled = true)
	public void heightinvalidformat2feet1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-height-feet"));

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("&%*967");
		log.debug("Speacial character entered for feet field");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.6.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text: Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB:Oops! Please use numbers only");

		Thread.sleep(1000);
		myElement.clear();

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty ");

	}

	@Test(priority = 16, enabled = true)
	public void heightinvalidformat3feet1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-height-feet"));

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("5.3");
		log.debug("Decimal value entered for feet field");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
       
		//checking the error message for invalid input for feet field
		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.6.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Decimal points not accepted",
				"Expected error message does not match with text: Oops! Decimal points not accepted");
		log.debug("Checked on entering invalid date DOB:Oops! Decimal points not accepted");

		Thread.sleep(1000);
		myElement.clear();

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty ");

	}

	@Test(priority = 17, enabled = true)
	public void heightvalidfeet1() throws InterruptedException {

		WebElement myElement = driver.findElement(By.className("nqa-height-feet"));
		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys(HeightFeet);
		log.debug("valid feet entered");
		Thread.sleep(1000);

		// check the field should be not empty
		Assert.assertNotEquals(myElement.getAttribute("value"), "", "Field for Feet is not empty");
		log.debug("Checked field for Feet is not empty");

	}

	@Test(priority = 18, enabled = true)
	public void heightinvalidmaxInches1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-height-inches"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Inches is empty - initally");

		myElement.sendKeys("12");
		log.debug("Invalid max Inches entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);

		// check the field should be empty
		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.6.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Inches cannot be more than 11",
				"Expected error message does not match with text: Oops! Inches cannot be more than 11");
		log.debug("Checked on entering invalid date DOB: Oops! Inches cannot be more than 11");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Inches is empty");
	}

	@Test(priority = 19, enabled = true)
	public void heightinvalidformat1Inches1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-height-inches"));

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("jhvj");
		log.debug("Invalid max feet entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.6.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text: Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB:Oops! Please use numbers only");

		Thread.sleep(1000);
		myElement.clear();

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty ");

	}

	@Test(priority = 20, enabled = true)
	public void heightinvalidformat2Inches1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-height-inches"));

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("&%*967");
		log.debug("Invalid max feet entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.6.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text: Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB:Oops! Please use numbers only");

		Thread.sleep(1000);
		myElement.clear();

		// check the field should be empty
		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty ");

	}

	@Test(priority = 21, enabled = true)
	public void heightvalidinches1() {

		WebElement myElement = driver.findElement(By.className("nqa-height-inches"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys(HeightInches);
		log.debug("height inches");

		Assert.assertNotEquals(myElement.getAttribute("value"), "", "Field for Feet is not empty - initally");
		log.debug("Checked field for Feet is not empty - initally");
	}

	// Q4 - working
	@Test(priority = 22, enabled = true)
	public void weightinvalidmin1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-weight"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Inches is empty - initally");

		myElement.sendKeys("99");
		log.debug("Invalid max Inches entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);

		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.7.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Cannot be less than 100 lbs",
				"Expected error message does not match with text:Oops! Cannot be less than 100 lbs");
		log.debug("Checked on entering invalid date DOB: Oops! Cannot be less than 100 lbs");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for weight is empty ");
	}

	@Test(priority = 23, enabled = true)
	public void weightinvalidmax() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-weight"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for weight is empty - initally");

		myElement.sendKeys("701");
		log.debug("Invalid max Inches entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.7.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Cannot be more than 700 lbs",
				"Expected error message does not match with text: Oops! Cannot be more than 700 lbs");
		log.debug("Checked on entering invalid date DOB: Oops! Cannot be more than 700 lbs");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty");
		log.debug("Checked field for weight is empty");
	}

	@Test(priority = 24, enabled = true)
	public void weightinvalidformat1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-weight"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for weight is empty - initally");

		myElement.sendKeys("gg76");
		log.debug("Invalid max Inches entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.7.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text: Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB: Oops! Please use numbers only");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty");
		log.debug("Checked field for weight is empty");
	}

	@Test(priority = 25, enabled = true)
	public void weightinvalidformat2() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-weight"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for weight is empty - initally");

		myElement.sendKeys("GHJ986");
		log.debug("Invalid max Inches entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.7.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text: Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB: Oops! Please use numbers only");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty");
		log.debug("Checked field for weight is empty");
	}

	@Test(priority = 26, enabled = true)
	public void weightinvalidformat3() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-weight"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for weight is empty - initally");

		myElement.sendKeys("%&^&");
		log.debug("Invalid max Inches entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.7.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text: Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB: Oops! Please use numbers only");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty");
		log.debug("Checked field for weight is empty");
	}

	@Test(priority = 27, enabled = true)
	public void weight1() {

		WebElement myElement = driver.findElement(By.className("nqa-weight"));
		myElement.sendKeys(WeightPounds);
		log.debug("weight");
	}

	// Q5
	@Test(priority = 28, enabled = true)
	public void waistinvalidmin1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-waist-pant-size"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Waist is empty - initally");

		myElement.sendKeys("9");
		log.debug("Invalid min waist entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.8.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Cannot be less than 10 inches",
				"Expected error message does not match with text: Oops! Cannot be less than 10 inches");
		log.debug("Checked on entering invalid date DOB: Oops! Cannot be less than 10 inches");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Waist is empty");
		log.debug("Checked field for Waist is empty");
	}

	@Test(priority = 29, enabled = true)
	public void waistinvalidmax() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-waist-pant-size"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("101");
		log.debug("Invalid max Waist entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.8.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Cannot be more than 100 inches",
				"Expected error message does not match with text: Oops! Cannot be more than 100 inches");
		log.debug("Checked on entering invalid date DOB: Oops! Cannot be more than 100 inches");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Waist is empty");
	}

	@Test(priority = 30, enabled = true)
	public void waistinvalidformat1() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-waist-pant-size"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("acbd");
		log.debug("Invalid max Waist entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.8.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text:Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB:Oops! Please use numbers only");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty ");
		log.debug("Checked field for Waist is empty");
	}

	@Test(priority = 31, enabled = true)
	public void waistinvalidformat2() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-waist-pant-size"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("ABD896");
		log.debug("Invalid max Waist entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.8.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text:Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB:Oops! Please use numbers only");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty ");
		log.debug("Checked field for Waist is empty");
	}

	@Test(priority = 32, enabled = true)
	public void waistinvalidformat3() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("nqa-waist-pant-size"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Feet is empty - initally");

		myElement.sendKeys("#$76");
		log.debug("Invalid max Waist entered");
		Thread.sleep(1000);
		myElement.sendKeys(Keys.TAB);
		// check the field should be empty

		WebElement myElement1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.0.0.0.2.$=10.0.0.0.8.0.0.0.0.1']"));
		Assert.assertEquals((myElement1.getText()), "Oops! Please use numbers only",
				"Expected error message does not match with text:Oops! Please use numbers only");
		log.debug("Checked on entering invalid date DOB:Oops! Please use numbers only");

		myElement.clear();

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty ");
		log.debug("Checked field for Waist is empty");
	}

	@Test(priority = 33, enabled = true)
	public void validwaist1() {

		WebElement myElement = driver.findElement(By.className("nqa-waist-pant-size"));

		Assert.assertEquals(myElement.getAttribute("value"), "", "Field for Feet is empty - initally");
		log.debug("Checked field for Waist is empty");

		myElement.sendKeys(waist);
		log.debug("waist");
	}

	@Test(priority = 34, enabled = true)
	public void nextbutton() {
		WebElement myElement = driver.findElement(By.className("nqa-next-button"));
		Assert.assertTrue(myElement.isEnabled(), "Verify Next Button is Enabled");
		myElement.click();
		log.debug("next button");
	}

	// page 2
	// Q6
	@Test(priority = 35, enabled = false)
	public void littletonophysical2() throws InterruptedException {
		Thread.sleep(2000);
		WebElement myElement = driver.findElement(By.cssSelector("[class='label-text'][for='no_to_little']"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();

		groupB = 1;
		log.debug("little to no physical activity");
	}

	@Test(priority = 36, enabled = true)
	public void mediumtohigh2() {
		WebElement myElement = driver.findElement(By.cssSelector("[class='label-text'][for='medium_to_high']"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();

		log.debug("medium to high phusical activity");
	}

	// Q7
	/*
	* writing the individual check box bcoz. I can test with either one or all
	* by enabling them
	*/
	@Test(priority = 37, enabled = true)
	public void HBP2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='high_blood_pressure_condition']"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		log.debug("Highbloodpressure");

	}

	@Test(priority = 38, enabled = true)
	public void HighCholestrol2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='high_cholesterol_condition']"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		log.debug("HighCholestrol");
	}

	@Test(priority = 39, enabled = true)
	public void Type2Diabetes2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='type_2_diabetes_condition']"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		log.debug("Type2Diabetes2");
	}

	// Q8
	@Test(priority = 40, enabled = true)
	public void medicationHBP2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='high_blood_pressure_medication']"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		groupB = 1;
		log.debug("medicationHBP2");
	}

	@Test(priority = 41, enabled = true)
	public void medicationHighCholestrol2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='high_cholesterol_medication']"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		groupB = 1;
		log.debug("medicationHighCholestrol");
	}

	@Test(priority = 42, enabled = true)
	public void medicationType2Diabetes2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='type_2_diabetes_medication']"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		groupB = 1;
		log.debug("medicationType2Diabetes");
	}

	// Q9
	@Test(priority = 43, enabled = false)
	public void alcohilicdrinkYes2() {
		WebElement myElement = driver.findElement(By.className("nqa-number-drinks-yes"));
		Assert.assertFalse(myElement.isSelected(), "Verify the radio box is not selected");
		myElement.click();

		groupB = 1;
		log.debug("alcohilic drink Yes");
	}

	@Test(priority = 44, enabled = true)
	public void alcohilicdrinkNo2() {
		WebElement myElement = driver.findElement(By.className("nqa-number-drinks-no"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		log.debug("alcohilic drink No");
	}

	// Q10
	@Test(priority = 45, enabled = false)
	public void smokeYes2() {
		WebElement myElement = driver.findElement(By.className("nqa-smoker-yes"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		groupB = 1;
		log.debug("smoke Yes");
	}

	@Test(priority = 46, enabled = true)
	public void smokeNo2() {
		WebElement myElement = driver.findElement(By.className("nqa-smoker-no"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		log.debug("smoke No");
	}

	// Q10.1
	@Test(priority = 47, enabled = false)
	public void smokein10yearsYes2() {
		WebElement myElement = driver.findElement(By.className("nqa-regular-smoker-10-yes"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();
		groupB = 1;
		log.debug("smoke in 10 years Yes");
	}

	@Test(priority = 48, enabled = true)
	public void smokein10yearsNo2() {
		WebElement myElement = driver.findElement(By.className("nqa-regular-smoker-10-no"));
		Assert.assertFalse(myElement.isSelected(), "Verify the checkbox box is not selected");
		myElement.click();

		log.debug("smoke in 10 years No");
	}

	@Test(priority = 49, enabled = true)
	public void submit2() {
		WebElement myElement = driver.findElement(By.className("nqa-submit-button"));
		Assert.assertTrue(myElement.isEnabled(), "Verify Next Button is Enabled");
		myElement.click();
		log.debug("submit 2");

	}
    /*
     * The logic below will calculate if the participant is at risk? If yes, then it will move to
	 * the registration page else it will quite.
	 */

	@Test(priority = 50, enabled = false)
	public void metsrisklogic() {
		Double WeightNormalizedPounds = Double.parseDouble(WeightPounds);
		Double waist1 = Double.parseDouble(waist);

		Double HeightFeetconverted = Double.parseDouble(HeightFeet);
		Double FeettoInches = (HeightFeetconverted * 12);

		Double HeightInches1 = Double.parseDouble(HeightInches);

		Double HeightNormalizedInches = (FeettoInches + HeightInches1);

		double BMI = (WeightNormalizedPounds / (HeightNormalizedInches * HeightNormalizedInches)) * 703;
		System.out.println(groupB + "groupB");
		System.out.println(gender + "This is the selected gender");
		if (gender == 10) {
			System.out.println("-----Female case selected-----");
			log.debug("Female case selected");
			if ((waist1 > 35 || BMI >= 30) && groupB == 1) {
				WebElement myElement = driver.findElement(By.className("button"));
				myElement.click();
				log.debug("Join Now Female");
				driver.quit();
			}

			// else
			// if ((waist1 > 35 || BMI >=30) && groupB == 0)

		}
	}
}
