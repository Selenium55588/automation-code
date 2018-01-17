package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Screener {
	WebDriver driver;
	// you can't have the driver mentioned here 	e.g.	driver.findElement();
	By myElement1 = By.xpath("//*[@id=\'rsQnA_0\']");
	By myElement2 = By.xpath("//*[@id=\'chkDemo_0\']");
	By weight = By.xpath("//*[@id='weight']");
	By height = By.xpath("//*[@id='height']");
	By calculate = By.xpath("//*[@id=\'chkRisk\']/tbody/tr[1]/td/div/form/div[4]/button");
	By bloodglucose = By.xpath("//*[@id='chkDemo_1']");
	By triglycerides = By.xpath("//*[@id='chkDemo_2']");
	By bloodpressure = By.xpath("//*[@id='chkDemo_3']");
	By hdllevels = By.xpath("//*[@id='chkDemo_4']");
	By checkeligibilty = By.xpath("/html/body/div[1]/div[2]/div[3]/button");
	By noteligiblemessage = By.xpath("//*[@id='pnlFailRegistration']/p/strong");
	By eligiblemessage = By.xpath("//*[@id=\'pnlStartRegistration\']/p/strong");

	
	
	public Screener(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCurrentlypregnantcheckbox() {
		driver.findElement(myElement1).click();

	}
	public void clickBMIcheckbox() {
		driver.findElement(myElement2).click();

	}
	public void inputweight(int inputweight) {
		driver.findElement(weight).sendKeys(String.valueOf(inputweight));

	}
	public void inputheight(int inputheight) {
		driver.findElement(height).sendKeys(String.valueOf(inputheight));

	}
	public void calculateBMI() {
		driver.findElement(calculate).click();

	}
	public void clickbloodglucose() {
		driver.findElement(bloodglucose).click();

	}
	public void clicktriglycerides() {
		driver.findElement(triglycerides).click();

	}
	public void clickbloodpressure() {
		driver.findElement(bloodpressure).click();

	}
	public void clickhdllevels() {
		driver.findElement(hdllevels).click();

	}
	public void clickcheckeligibilty() {
		driver.findElement(checkeligibilty).click();

	}
	public String verifynoteligiblemessage() {
		String S= driver.findElement(noteligiblemessage).getText();
		return S;

	}
	public String verifyeligiblemessage() {
		String S= driver.findElement(eligiblemessage).getText();
		return S;

	}
	
	
	
	
	
	
	

}
