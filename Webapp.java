package automationlab;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Notes
*This script add data e.g. food and activity to the account  
*/

public class Webapp {

	String baseUrl = "Your URL";

	public static String calorieApp1;
	public static String caloriesApp = "hello";

	public static WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void url() throws InterruptedException {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		String expectedTitle = "Title";
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest(enabled = false)
	public void end() {
		driver.quit();
	}

	@AfterMethod(enabled = true)
	public void sleeptime() throws InterruptedException {
		Thread.sleep(2000);

	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public static void home() throws InterruptedException {
		Thread.sleep(4000);
		driver.navigate().to("Navigate to URL specific page");
	}

	@Test(priority = 1)
	public void login() {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		By byCss19 = By.cssSelector("[type='email'][data-reactid='.0.1.1.1.2']");
		driver.findElement(byCss19).click();

		By byCss20 = By.cssSelector("[type='email'][data-reactid='.0.1.1.1.2']");
		driver.findElement(byCss20).sendKeys("demo@company.com");

		By byCss21 = By.cssSelector("[type='password'][data-reactid='.0.1.1.4.2']");
		driver.findElement(byCss21).sendKeys("Password");

		WebElement s = driver.findElement(By.cssSelector("[class='ntp-button-punched-out'][data-reactid='.0.1.1.7']"));
		s.click();
		// login button is selected ??
		AssertJUnit.assertFalse(s.isSelected());

	}

	@Test(priority = 2, enabled = true)
	public void dvideo() throws InterruptedException {

		WebElement d = driver.findElement(By.cssSelector("[id='video-play-button']"));
		d.click();
		Thread.sleep(1000);
		By byCss128 = By.cssSelector("[id='video-pause-button']");
		// working if you would like to stop the video
		driver.findElement(byCss128).click();
		By byCss1128 = By.cssSelector("[class='icon-arrowRight fa-1x']");
		driver.findElement(byCss1128).click();

		WebElement myElement7 = driver
				.findElement(By.cssSelector("[data-reactid='.0.1.1.0.0.0.$3.0.0.0:$=1$1:0.0.0.0.0.0.1:0.0.0']"));
		Assert.assertEquals((myElement7.getText()),
				"Book a coaching session. Please call or contact us at to book your coaching session.");

		WebElement d1 = driver
				.findElement(By.cssSelector("[data-reactid='.0.1.1.0.0.0.$3.0.0.0:$=1$2:0.0.0.0.0.0.1.1.0.0.0.0']"));
		String caloriesApp1 = d1.getText();
		System.out.println(caloriesApp1 + "calorie value");
		System.out.println(caloriesApp1.substring(0, 5) + "Yappiee");

	}

	@Test(priority = 3, enabled = true)
	public void dwater() throws InterruptedException {
		By byCss28 = By.cssSelector("[class='glass'][value='0']");
		driver.findElement(byCss28).click();
		Thread.sleep(2000);
		By byCss29 = By.cssSelector("[class='glass'][value='1']");
		driver.findElement(byCss29).click();
		Thread.sleep(2000);
		By byCss30 = By.cssSelector("[class='glass'][value='2']");
		driver.findElement(byCss30).click();
		Thread.sleep(2000);
		By byCss31 = By.cssSelector("[class='glass'][value='3']");
		driver.findElement(byCss31).click();
		Thread.sleep(2000);
		By byCss32 = By.cssSelector("[class='glass'][value='4']");
		driver.findElement(byCss32).click();
		Thread.sleep(2000);
		By byCss33 = By.cssSelector("[class='glass'][value='5']");
		driver.findElement(byCss33).click();
		Thread.sleep(2000);
		By byCss34 = By.cssSelector("[class='glass'][value='6']");
		driver.findElement(byCss34).click();
		Thread.sleep(2000);
		By byCss35 = By.cssSelector("[class='glass'][value='7']");
		driver.findElement(byCss35).click();
		Thread.sleep(2000);

	}

	@Test(priority = 14, enabled = false)
	public void dcraving() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		JavascriptExecutor je = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(By.className("pure-u-1-3"));

		je.executeScript("arguments[0].scrollIntoView(true);", element);

		By byCss222 = By.cssSelector(
				"#wrapper > div.ntp-container > div > div > div > div > div > div.react-draggable.react-grid-item.cssTransforms.box-draggable-cravings > div > div > div > div > div.front > div.footer > div > div > div > div > div > button > div:nth-child(1) > span");
		driver.findElement(byCss222).click();

		Thread.sleep(1000);

		By byCss31 = By.cssSelector("[id='id4']");
		driver.findElement(byCss31).click();

		Thread.sleep(1000);

		By byCss311 = By.cssSelector("[class='card_button_bar pure-u-24-24']");
		driver.findElement(byCss311).click();

	}

	@Test(priority = 4, enabled = false)
	public void dweight() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.className("pure-u-1-3"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		By byCss222 = By.cssSelector(
				"#wrapper > div.ntp-container > div > div > div > div > div > div.react-draggable.react-grid-item.cssTransforms.box-draggable-weight > div > div > div > div > div.front > div.footer > div > div > div > div > div > button > div:nth-child(1) > span");
		driver.findElement(byCss222).click();

		home();

		Thread.sleep(2000);

		refresh();

		By byCss251 = By.cssSelector("[class='icon-plus fa-small mui-font-icon']");
		driver.findElement(byCss251).click();

		By byCss231 = By.cssSelector("[class='input-style']");
		driver.findElement(byCss231).sendKeys("252");
		String x = driver.findElement(byCss231).getAttribute("value");
		System.out.println(x);

		Thread.sleep(2000);

		By byCss22111 = By.cssSelector("[class='card_button_bar pure-u-24-24']");
		driver.findElement(byCss22111).click();

		Thread.sleep(1000);

		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.className("currentWeightNumber"));
		je1.executeScript("arguments[0].scrollIntoView(true);", element1);
		WebElement myElement7 = driver.findElement(By.cssSelector("[class='currentWeightNumber']"));
		Assert.assertEquals((myElement7.getText()), x);
		System.out.println(myElement7.getText());
		refresh();

		Thread.sleep(2000);

	}

	public static void activitylanding() {
		driver.navigate().to("https://app.newtopia.com/#/app/exercise");
	}

	public static void activitydetails() {
		driver.navigate().to("https://app.newtopia.com/#/app/exercise/daily");
	}

	public static void activityhistory() {
		driver.navigate().to("https://app.newtopia.com/#/app/exercise/tracked");
	}

	public static void delete() throws InterruptedException {
		WebElement myElement18 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		myElement18.click();

		// scroll down to view the element
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.className("mui-raised-button-label"));
		// now execute query which actually will scroll until that element is
		// not appeared on page
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		WebElement myElement218 = driver.findElement(By.cssSelector("[class='mui-raised-button-label']"));
		myElement218.click();

		WebElement myElement2118 = driver.findElement(By.cssSelector("[class='mui-raised-button-label']"));
		myElement2118.click();

	}

	@Test(priority = 5, enabled = false)
	public void walkactivity() throws InterruptedException {

		activitylanding();
		Thread.sleep(1000);

		// CLICK ON THE WALK
		By byCss451 = By.cssSelector("[class='nt-icon icon-activityWalking fa-3x']");
		driver.findElement(byCss451).click();

		Thread.sleep(1000);

		By byCss37 = By.cssSelector("[class='input-style']");
		driver.findElement(byCss37).sendKeys("40");
		String x = driver.findElement(byCss37).getAttribute("value");
		System.out.println(x + "entered value");

		By byCss38 = By.cssSelector("[class='icon-intensity-1']");
		driver.findElement(byCss38).click();

		Thread.sleep(1000);

		// scroll down to view the element
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.className("intensity-description"));
		// now execute query which actually will scroll until that element is
		// not appeared on page
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		// Done
		By byCss39 = By.cssSelector("[class='mui-raised-button-container mui-enhanced-button']");
		driver.findElement(byCss39).click();

		Thread.sleep(1000);
		activitylanding();

		Thread.sleep(2000);
		
		activitydetails();

		WebElement myElement7 = driver
				.findElement(By.cssSelector("[data-reactid='.0.1.1.0.0.0.$8.0.0.$0.0.0.0.1.1:$0.1.0']"));
		Assert.assertEquals((myElement7.getText()), "Walking");
		
		WebElement myElement8 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement8.getText()), x + " min");
		System.out.println(myElement8.getText() + "value from the object");
		
		Thread.sleep(2000);

		activityhistory();

		Thread.sleep(2000);

		WebElement myElement18 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement18.getText()), x + " min");
		System.out.println(myElement18.getText() + "value from the object");
		

		System.out.println("workinggg");
		delete();

		Thread.sleep(1000);

	}

	@Test(priority = 6, enabled = false)
	public void joggingactivity() throws InterruptedException {
		System.out.println("jog");
		
		By byCss4501 = By.cssSelector("[class='nt-icon icon-activityJogging fa-3x']");
		driver.findElement(byCss4501).click();

		By byCss37 = By.cssSelector("[class='input-style']");
		// DO NOT CHANGE THE VALUE 25 THE ID IS MAPPED FOR 25
		driver.findElement(byCss37).sendKeys("25");
		String x = driver.findElement(byCss37).getAttribute("value");
		System.out.println(x + "entered value");

		By byCss38 = By.cssSelector("[class='icon-intensity-1']");
		driver.findElement(byCss38).click();

		Thread.sleep(1000);

		// scroll down to view the element
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.className("intensity-description"));
		// now execute query which actually will scroll until that element is
		// not appeared on page
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		// Done
		By byCss39 = By.cssSelector("[class='mui-raised-button-container mui-enhanced-button']");
		driver.findElement(byCss39).click();

		Thread.sleep(1000);
		activitylanding();
		Thread.sleep(2000);
		activitydetails();

		WebElement myElement8 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement8.getText()), x + " min");
		System.out.println(myElement8.getText() + "value from the object from Today's Details");
		
		Thread.sleep(2000);
		activityhistory();
		Thread.sleep(2000);

		WebElement myElement18 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement18.getText()), x + " min");
		System.out.println(myElement18.getText() + "value from the object from History");
		delete();
		Thread.sleep(1000);

	}

	@Test(priority = 7, enabled = false)
	public void yogaactivity() throws InterruptedException {

		// SELECT YOGA
		By byCss4501 = By.cssSelector("[class='nt-icon icon-activityYoga fa-3x']");
		driver.findElement(byCss4501).click();

		By byCss37 = By.cssSelector("[class='input-style']");
		driver.findElement(byCss37).sendKeys("7");
		String x = driver.findElement(byCss37).getAttribute("value");
		System.out.println(x + "entered value");

		By byCss38 = By.cssSelector("[class='icon-intensity-1']");
		driver.findElement(byCss38).click();

		Thread.sleep(1000);

		// scroll down to view the element
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.className("intensity-description"));
		// now execute query which actually will scroll until that element is
		// not appeared on page
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		// Done
		By byCss39 = By.cssSelector("[class='mui-raised-button-container mui-enhanced-button']");
		driver.findElement(byCss39).click();

		Thread.sleep(1000);
		activitylanding();

		Thread.sleep(2000);
		activitydetails();
		
		WebElement myElement8 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement8.getText()), x + " min");
		System.out.println(myElement8.getText() + "value from the object from Today's Details");
	
		Thread.sleep(2000);
		activityhistory();
		Thread.sleep(2000);

		WebElement myElement18 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement18.getText()), x + " min");
		System.out.println(myElement18.getText() + "value from the object from History");

		delete();

		Thread.sleep(1000);

	}

	@Test(priority = 8, enabled = false)
	public void bicycleactivity() throws InterruptedException {

		// SELECT BICYCLE
		By byCss4501 = By.cssSelector("[class='nt-icon icon-activityBiking fa-3x']");
		driver.findElement(byCss4501).click();

		By byCss37 = By.cssSelector("[class='input-style']");
		driver.findElement(byCss37).sendKeys("5");
		String x = driver.findElement(byCss37).getAttribute("value");
		System.out.println(x + "entered value");

		By byCss38 = By.cssSelector("[class='icon-intensity-1']");
		driver.findElement(byCss38).click();

		Thread.sleep(2000);

		// scroll down to view the element
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.className("intensity-description"));
		// now execute query which actually will scroll until that element is
		// not appeared on page
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		// Done
		By byCss39 = By.cssSelector("[class='mui-raised-button-container mui-enhanced-button']");
		driver.findElement(byCss39).click();

		Thread.sleep(1000);
		activitylanding();

		Thread.sleep(2000);
		activitydetails();

		WebElement myElement8 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement8.getText()), x + " min");
		System.out.println(myElement8.getText() + "value from the object from Today's Details");
		// log.debug("To check exercise min entered by the user matches in the
		// the details);
		Thread.sleep(2000);
		activityhistory();
		Thread.sleep(2000);

		WebElement myElement18 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement18.getText()), x + " min");
		System.out.println(myElement18.getText() + "value from the object from History");

		delete();
		Thread.sleep(1000);

	}

	@Test(priority = 9, enabled = false)
	public static void swimactivity() throws InterruptedException {

		// CLICK ON THE swim
		By byCss451 = By.cssSelector("[class='nt-icon icon-activitySwimming fa-3x']");
		driver.findElement(byCss451).click();

		By byCss37 = By.cssSelector("[class='input-style']");
		driver.findElement(byCss37).sendKeys("5");
		String x = driver.findElement(byCss37).getAttribute("value");
		System.out.println(x + "entered value");

		By byCss38 = By.cssSelector("[class='icon-intensity-1']");
		driver.findElement(byCss38).click();

		Thread.sleep(1000);

		// scroll down to view the element
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.className("intensity-description"));
		// now execute query which actually will scroll until that element is
		// not appeared on page
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		// Done
		By byCss39 = By.cssSelector("[class='mui-raised-button-container mui-enhanced-button']");
		driver.findElement(byCss39).click();

		Thread.sleep(1000);
		activitylanding();

		Thread.sleep(2000);
	
		activitydetails();

		WebElement myElement8 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement8.getText()), x + " min");
		System.out.println(myElement8.getText() + "value from the object from Today's Details");
		
		Thread.sleep(2000);
		activityhistory();
		Thread.sleep(2000);

		WebElement myElement18 = driver.findElement(By.cssSelector("[class='pure-u-sm-5-24 pure-u-5-24']"));
		Assert.assertEquals((myElement18.getText()), x + " min");
		System.out.println(myElement18.getText() + "value from the object from History");
		
		delete();
		Thread.sleep(1000);
		home();

	}

	@Test(priority = 10, enabled = false)
	public void breakfastNutrition() {
		// Dashboard - Nutrition
		By byCss223 = By.cssSelector("[class='mui-raised-button-label']");
		driver.findElement(byCss223).click();

		// Breakfast
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		By byCss25 = By.cssSelector("[class='select-meal-card-icon pure-u-8-24']");
		driver.findElement(byCss25).click();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);


		By byCss26 = By.cssSelector("[class='mui-text-field-input']");
		driver.findElement(byCss26).sendKeys("coffee");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		By byCss261 = By.cssSelector("[class='food-item ntp-list-item ntp-hover-item']");
		driver.findElement(byCss261).click();

		// Done
		By byCss262 = By.cssSelector("[class='mui-raised-button-label']");
		driver.findElement(byCss262).click();

	}

	@Test(priority = 11, enabled = false)
	public void lunchNutrition() throws InterruptedException {
		home();
		// Dashboard - Nutrition
		By byCss223 = By.cssSelector("[class='mui-raised-button-label']");
		driver.findElement(byCss223).click();

		// Lunch
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		By byCss25 = By.cssSelector("[class='icon-nutritionLunch fa-3x ']");
		driver.findElement(byCss25).click();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		By byCss26 = By.cssSelector("[class='mui-text-field-input']");

		driver.findElement(byCss26).sendKeys("coffee");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		By byCss261 = By.cssSelector("[class='food-item ntp-list-item ntp-hover-item']");
		driver.findElement(byCss261).click();

		// Done
		By byCss262 = By.cssSelector("[class='mui-raised-button-label']");
		driver.findElement(byCss262).click();

	}

	@Test(priority = 12, enabled = false)
	public void dinnerNutrition() throws InterruptedException {
		home();
		// Dashboard - Nutrition
		By byCss223 = By.cssSelector("[class='mui-raised-button-label']");
		driver.findElement(byCss223).click();

		// Dinner
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		By byCss25 = By.cssSelector("[class='icon-nutritionDinner fa-3x ']");
		driver.findElement(byCss25).click();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		By byCss26 = By.cssSelector("[class='mui-text-field-input']");

		driver.findElement(byCss26).sendKeys("coffee");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		By byCss261 = By.cssSelector("[class='food-item ntp-list-item ntp-hover-item']");
		driver.findElement(byCss261).click();

		// Done
		By byCss262 = By.cssSelector("[class='mui-raised-button-label']");
		driver.findElement(byCss262).click();
	}

	@Test(priority = 13, enabled = false)
	public void snackNutrition() throws InterruptedException {
		home();
		// Dashboard - Nutrition
		By byCss223 = By.cssSelector("[class='mui-raised-button-label']");
		driver.findElement(byCss223).click();

		// Snacks
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		By byCss25 = By.cssSelector("[class='icon-nutritionSnack fa-3x ']");
		driver.findElement(byCss25).click();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		By byCss26 = By.cssSelector("[class='mui-text-field-input']");

		driver.findElement(byCss26).sendKeys("tea");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		By byCss261 = By.cssSelector("[class='food-item ntp-list-item ntp-hover-item']");
		driver.findElement(byCss261).click();

		// Done
		By byCss262 = By.cssSelector("[class='mui-raised-button-label']");
		driver.findElement(byCss262).click();
	}

	@Test(priority = 15, enabled = false)
	public void stressWellbeing() throws InterruptedException {

		By byCss26 = By.cssSelector("[data-reactid='.0.1.0.1.0.3.0.0.0']");
		driver.findElement(byCss26).click();

		By byCss30 = By.cssSelector("[class='nt-icon icon-stress fa-2x']");
		driver.findElement(byCss30).click();

		By byCss31 = By.cssSelector("[class='d3-radial']");
		driver.findElement(byCss31).click();

		By byCss32 = By.cssSelector("[data-reactid='.0.1.1.0.0.0.$7.0.0.0.0.0.0.0.2.0.0.0.0.0.0.$touchRipple.1']");
		driver.findElement(byCss32).click();

	}

	@Test(priority = 16, enabled = false)
	public void moodWellbeing() throws InterruptedException {

		By byCss26 = By.cssSelector("[data-reactid='.0.1.0.1.0.3.0.0.0']");
		driver.findElement(byCss26).click();

		By byCss30 = By.cssSelector("[class='nt-icon icon-mood fa-2x']");
		driver.findElement(byCss30).click();

		By byCss31 = By.cssSelector("[class='d3-radial']");
		driver.findElement(byCss31).click();

		Thread.sleep(100);

		By byCss32 = By.cssSelector("[data-reactid='.0.1.1.0.0.0.$7.0.0.0.0.0.0.0.2.0.0.0.0.0.0.$touchRipple.1']");
		driver.findElement(byCss32).click();
	}

	@Test(priority = 17, enabled = false)
	public void anxietyWellbeing() throws InterruptedException {

		By byCss26 = By.cssSelector("[data-reactid='.0.1.0.1.0.3.0.0.0']");
		driver.findElement(byCss26).click();

		By byCss30 = By.cssSelector("[class='nt-icon icon-anxiety fa-2x']");
		driver.findElement(byCss30).click();

		By byCss31 = By.cssSelector("[class='d3-radial']");
		driver.findElement(byCss31).click();

		By byCss32 = By.cssSelector("[data-reactid='.0.1.1.0.0.0.$7.0.0.0.0.0.0.0.2.0.0.0.0.0.0.$touchRipple.1']");
		driver.findElement(byCss32).click();
	}

	@Test(priority = 18, enabled = false)
	public void cravingsWellbeing() throws InterruptedException {

		By byCss26 = By.cssSelector("[data-reactid='.0.1.0.1.0.3.0.0.0']");
		driver.findElement(byCss26).click();

		By byCss30 = By.cssSelector("[class='nt-icon icon-cravings-icecream fa-2x']");
		driver.findElement(byCss30).click();

		By byCss31 = By.cssSelector("[class='d3-radial']");
		driver.findElement(byCss31).click();

		By byCss32 = By.cssSelector("[data-reactid='.0.1.1.0.0.0.$7.0.0.0.0.0.0.0.2.0.0.0.0.0.0.$touchRipple.1']");
		driver.findElement(byCss32).click();
	}

	@Test(priority = 19, enabled = false)
	public void device() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By byCss27 = By.cssSelector("[data-reactid='.0.1.0.1.0.4']");
		driver.findElement(byCss27).click();
	}

	@Test(priority = 20, enabled = false)
	public void logout() {
		By byCss70 = By.cssSelector("[data-reactid='.0.1.0.1.0.5.0.0.1']");
		driver.findElement(byCss70).click();
		// genetic report
		By byCss31 = By.cssSelector("[data-reactid='.0.1.0.1.0.5.0.0.2.0']");
		driver.findElement(byCss31).click();
		// logout
		By byCss71 = By.cssSelector("[data-reactid='.0.1.0.1.0.5.0.0.2.1']");
		driver.findElement(byCss71).click();
	}

}
