package newpackage;

import java.net.URL;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.Registration1;
import pages.Registration2;
import pages.Registration3;
import pages.Registration4;

import pages.Screener;

public class Onboarding {
	public static WebDriver driver;
	Registration1 r1;
	Registration2 r2;
	Registration3 r3;
	Registration4 r4;
	String Firstname = "Test_Fname_351";
	String Lastname = "Test_Lname_134_0115";
	String DateofBirth = "03/16/1998";
	String emailaddress = "test@mailinator.com";
	int SIDnumber = 1234;

	  String baseUrl = "";

	Screener sof;

	@Test(priority = 1, enabled = true)
	public void Setup() throws Exception {
		
		 driver = new ChromeDriver(); driver.get(baseUrl);
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

	@Test(priority = 2, enabled = true)
	public void fname() throws InterruptedException {

		r1 = new Registration1(driver);
		r1.inputfname(Firstname);

	}

	@Test(priority = 3, enabled = true)
	public void lname() throws InterruptedException {

		r1 = new Registration1(driver);
		r1.inputlname(Lastname);
	}

	@Test(priority = 4, enabled = true)
	public void Dob() throws InterruptedException {

		r1 = new Registration1(driver);
		r1.inputdob(DateofBirth);
	}

	@Test(priority = 5, enabled = true)
	public void nextbutton() throws InterruptedException {

		r1 = new Registration1(driver);
		r1.nextbutton();
	}

	@Test(priority = 6, enabled = true)
	public void inputsid() {
		r2 = new Registration2(driver);
		r2.inputfname(SIDnumber);
	}

	@Test(priority = 7, enabled = true)
	public void clicknext() {
		r2 = new Registration2(driver);
		r2.clicknext();
	}

	@Test(priority = 8, enabled = true)
	public void profilename() {
		r3 = new Registration3(driver);
		r3.inputprofilename();
	}

	@Test(priority = 9, enabled = true)
	public void email() {
		r3 = new Registration3(driver);
		r3.inputemail(emailaddress);
	}

	@Test(priority = 10, enabled = true)
	public void password() {
		r3 = new Registration3(driver);
		r3.inputpassword();
	}

	@Test(priority = 11, enabled = true)
	public void confirmpassword() {
		r3 = new Registration3(driver);
		r3.inputconfirmpassword();
	}

	@Test(priority = 12, enabled = true)
	public void addressl1() {
		r3 = new Registration3(driver);
		r3.inputaddressl1();
	}

	@Test(priority = 13, enabled = true)
	public void addressl2() {
		r3 = new Registration3(driver);
		r3.inputaddressl2();
	}

	@Test(priority = 14, enabled = true)
	public void state() {
		r3 = new Registration3(driver);
		r3.choosestate();
	}

	@Test(priority = 15, enabled = true)
	public void city() {
		r3 = new Registration3(driver);
		r3.inputcity();
	}

	@Test(priority = 16, enabled = true)
	public void zipcode() {
		r3 = new Registration3(driver);
		r3.inputzip();
	}

	@Test(priority = 17, enabled = true)
	public void phone() {
		r3 = new Registration3(driver);
		r3.inputphonenumber();
	}

	@Test(priority = 18, enabled = true)
	public void Nextbutton() {
		r3 = new Registration3(driver);
		r3.clicknext();
	}

	@Test(priority = 19, enabled = true)
	public void Geneticsconsent() {
		r4 = new Registration4(driver);
		r4.clickgeneticsconsent();
	}

	@Test(priority = 20, enabled = true)
	public void Policyconsent() {
		r4 = new Registration4(driver);
		r4.policyconsent();
	}

}
