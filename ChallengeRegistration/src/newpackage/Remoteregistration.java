package automationlab;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.net.URL;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Remoteregistration {

	private WebDriver driver;
	static int gender;// 0 female & 1 male
	static String waist = "42";
	static String WeightPounds = "220";
	static String HeightFeet = "6";
	static String HeightInches = "0";
	static int groupB;
	Logger log = Logger.getLogger("devpinoyLogger");
	
	/*
	*This test script uses Browser stack's platform to run 
	*I am using capabilities which allows me to run the 
	*script on any browser and platform e.g. Windows and Mac
	*/

	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		//capability.setPlatform(Platform.WINDOWS);

		capability.setCapability("browser", "IE");
		capability.setCapability("browser_version", "11");
		capability.setCapability("os", "Windows");
		capability.setCapability("os_version", "10");
		capability.setCapability("browserstack.debug", "true");
		//capability.setCapability("browserstack.video", "true");

		capability.setCapability("build", "TestNG - Sample");
		String s = capability.getBrowserName();
		System.out.println(s);
		System.out.println(capability.getBrowserName());
		System.out.println(capability.getPlatform());
		System.out.println(capability.getVersion());

		driver = new RemoteWebDriver(
				new URL("your Browser Stack URL with access keys"), capability);
	}

	@Test
	public void geturl() {
		driver.get("target url");
		driver.manage().window().maximize();
		String expectedTitle = "Personal Profile";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Not the expected title");
		log.debug("Expected Title is: Personal Profile");
	}

	@AfterMethod
	public void home() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Test(groups = { "female" }, priority = 1, enabled = false)
	public void startbutton() throws InterruptedException {
		Thread.sleep(2000);
		WebElement myElement = driver.findElement(By.className("btn_blue"));
		myElement.click();
		gender = 0;
		log.debug("Female gender selected");
	}

	// Q1
	@Test(groups = { "female" }, priority = 2, enabled = true)
	public void genderFemale1() {
		WebElement myElement = driver.findElement(By.className("nqa-gender-female"));
		myElement.click();
		gender = 0;
		log.debug("Female gender selected");
	}

	@Test(priority = 3, enabled = false)
	public void genderMale1() {
		WebElement myElement = driver.findElement(By.className("nqa-gender-male"));
		myElement.click();
		gender = 1;
		log.debug("Male gender selected");
	}

	// Q1.1
	@Test(priority = 4, enabled = true)
	public void diabetesYes1() {
		WebElement myElement = driver.findElement(By.className("nqa-pregnant-diabetes-yes"));
		myElement.click();
		groupB = 1;
		log.debug("Diabetes Yes");
	}

	@Test(priority = 5, enabled = false)
	public void diabetesNo1() {
		WebElement myElement = driver.findElement(By.className("nqa-pregnant-diabetes-no"));
		myElement.click();
		log.debug("Diabetes No");
	}

	// Q1.2
	@Test(priority = 6, enabled = true)
	public void babyweightYes1() {
		WebElement myElement = driver.findElement(By.className("nqa-baby-weight-yes"));
		myElement.click();
		groupB = 1;
		log.debug("Babyweight Yes");
	}

	@Test(priority = 7, enabled = false)
	public void babyweightNo1() {
		WebElement myElement = driver.findElement(By.className("nqa-baby-weight-no"));
		myElement.click();
		log.debug("Babyweight No");
	}

	// Q1.3
	@Test(priority = 8, enabled = true)
	public void pregnantYes1() {
		WebElement myElement = driver.findElement(By.className("nqa-current-pregnant-yes"));
		myElement.click();
		log.debug("pregnant Yes");
	}

	@Test(priority = 9, enabled = false)
	public void pregnantNo1() {
		WebElement myElement = driver.findElement(By.className("nqa-current-pregnant-no"));
		myElement.click();
		log.debug("pregnant No");
	}

	// Q2
	@Test(priority = 10, enabled = true)
	public void ageYes1() {
		WebElement myElement = driver.findElement(By.className("nqa-over-40-yes"));
		myElement.click();
		groupB = 1;
		log.debug("age40 Yes");
	}

	@Test(priority = 11, enabled = false)
	public void ageNo1() {
		WebElement myElement = driver.findElement(By.className("nqa-over-40-no"));
		myElement.click();
		log.debug("age40 No");
	}

	// Q3
	@Test(priority = 12, enabled = true)
	public void heightfeet1() {
		WebElement myElement = driver.findElement(By.className("nqa-height-feet"));
		myElement.sendKeys(HeightFeet);
		log.debug("height feet");
	}

	@Test(priority = 13, enabled = true)
	public void heightinches1() {
		WebElement myElement = driver.findElement(By.className("nqa-height-inches"));
		myElement.sendKeys(HeightInches);
		log.debug("height inches");
	}

	// Q4
	@Test(priority = 14, enabled = true)
	public void weight1() {
		WebElement myElement = driver.findElement(By.className("nqa-weight"));
		myElement.sendKeys(WeightPounds);
		log.debug("weight");
	}

	// Q5
	@Test(priority = 15, enabled = true)
	public void waist1() {
		WebElement myElement = driver.findElement(By.className("nqa-waist-pant-size"));
		myElement.sendKeys(waist);
		log.debug("waist");
	}

	@Test(priority = 16, enabled = true)
	public void nextbutton() {
		WebElement myElement = driver.findElement(By.className("nqa-next-button"));
		myElement.click();
		log.debug("next button");
	}

	// page 2
	// Q6
	@Test(priority = 17, enabled = true)
	public void littletonophysical2() throws InterruptedException {
		Thread.sleep(2000);
		WebElement myElement = driver.findElement(By.cssSelector("[class='label-text'][for='no_to_little']"));
		myElement.click();
		groupB = 1;
		log.debug("little to no physical activity");
	}

	@Test(priority = 18, enabled = false)
	public void mediumtohigh2() {
		WebElement myElement = driver.findElement(By.cssSelector("[class='label-text'][for='medium_to_high']"));
		myElement.click();
		log.debug("medium to high phusical activity");
	}

	// Q7
	@Test(priority = 19, enabled = true)
	public void HBP2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='high_blood_pressure_condition']"));
		myElement.click();
		log.debug("Highbloodpressure");

	}

	@Test(priority = 20, enabled = true)
	public void HighCholestrol2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='high_cholesterol_condition']"));
		myElement.click();
		log.debug("HighCholestrol");
	}

	@Test(priority = 21, enabled = true)
	public void Type2Diabetes2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='type_2_diabetes_condition']"));
		myElement.click();
		log.debug("Type2Diabetes2");
	}

	// Q8
	@Test(priority = 22, enabled = true)
	public void medicationHBP2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='high_blood_pressure_medication']"));
		myElement.click();
		groupB = 1;
		log.debug("medicationHBP2");
	}

	@Test(priority = 23, enabled = true)
	public void medicationHighCholestrol2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='high_cholesterol_medication']"));
		myElement.click();
		groupB = 1;
		log.debug("medicationHighCholestrol");
	}

	@Test(priority = 24, enabled = true)
	public void medicationType2Diabetes2() {
		WebElement myElement = driver.findElement(By.cssSelector("[for='type_2_diabetes_medication']"));
		myElement.click();
		groupB = 1;
		log.debug("medicationType2Diabetes");
	}

	// Q9
	@Test(priority = 25, enabled = true)
	public void alcohilicdrinkYes2() {
		WebElement myElement = driver.findElement(By.className("nqa-number-drinks-yes"));
		myElement.click();
		groupB = 1;
		log.debug("alcohilic drink Yes");
	}

	@Test(priority = 26, enabled = false)
	public void alcohilicdrinkNo2() {
		WebElement myElement = driver.findElement(By.className("nqa-number-drinks-no"));
		myElement.click();
		log.debug("alcohilic drink No");
	}

	// Q10
	@Test(priority = 27, enabled = true)
	public void smokeYes2() {
		WebElement myElement = driver.findElement(By.className("nqa-smoker-yes"));
		myElement.click();
		groupB = 1;
		log.debug("smoke Yes");
	}

	@Test(priority = 28, enabled = false)
	public void smokeNo2() {
		WebElement myElement = driver.findElement(By.className("nqa-smoker-no"));
		myElement.click();
		log.debug("smoke No");
	}

	// Q10.1
	@Test(priority = 29, enabled = false)
	public void smokein10yearsYes2() {
		WebElement myElement = driver.findElement(By.className("nqa-regular-smoker-10-yes"));
		myElement.click();
		groupB = 1;
		log.debug("smoke in 10 years Yes");
	}

	@Test(priority = 30, enabled = false)
	public void smokein10yearsNo2() {
		WebElement myElement = driver.findElement(By.className("nqa-regular-smoker-10-no"));
		myElement.click();
		log.debug("smoke in 10 years No");
	}

	@Test(priority = 31, enabled = true)
	public void submit2() {
		WebElement myElement = driver.findElement(By.className("nqa-submit-button"));
		myElement.click();
		log.debug("submit 2");

	}
	
	@Test(priority = 32, enabled = true)
	public void metsrisklogic() {
		Double WeightNormalizedPounds = Double.parseDouble(WeightPounds);
		Double waist1 = Double.parseDouble(waist);

		Double HeightFeetconverted = Double.parseDouble(HeightFeet);
		Double FeettoInches = (HeightFeetconverted * 12);

		Double HeightInches1 = Double.parseDouble(HeightInches);

		Double HeightNormalizedInches = (FeettoInches + HeightInches1);

		double BMI = (WeightNormalizedPounds / (HeightNormalizedInches * HeightNormalizedInches)) * 703;
		System.out.println(groupB);
		System.out.println(gender);
		if (gender == 0) {
			if (waist1 > 35 || BMI >= 30 && groupB == 1) {
				WebElement myElement = driver.findElement(By.className("button"));
				myElement.click();
				log.debug("Join Now");
			}

			else {
				System.out.println("Not at risk");
				log.debug("Not at risk");
				driver.quit();
			}
		} else if (gender == 1) {
			if (waist1 > 40 || BMI >= 30 && groupB == 1) {
				WebElement myElement = driver.findElement(By.className("button"));
				myElement.click();
				log.debug("Join Now");
			}

			else {
				System.out.println("Not at risk");
				log.debug("Not at risk");
				driver.quit();
			}
		}

	}

	@Test(priority = 33, enabled = true)
	public void ontoregistration() {
		WebElement myElement = driver.findElement(By.className("button"));
		myElement.click();
		log.debug("On To Registration - Join Now");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

}