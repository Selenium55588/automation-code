package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration3 {
	WebDriver driver;
	By profilename = By.xpath("//*[@id=\'profile-name\']/input");
	By email = By.xpath("//*[@id=\'email\']/input");
	By password = By.xpath("//*[@id=\'password\']/input");
	By confirmpassword = By.xpath("//*[@id=\'confirm-pass\']/input");
	By addressl1 = By.xpath("//*[@id='address-line-1\']/input");
	By addressl2 = By.xpath("//*[@id=\'address-line-2\']/input");
	By city = By.xpath("//*[@id=\'city\']/input");
	By zipcode = By.xpath("//*[@id=\'zip\']/input");
	By phone = By.xpath("//*[@id=\'phone\']/input");
	By state = By.xpath("//*[@id='state']");
	By pickstate = By.xpath("//*[@id='Combobox-1-0']");
	By nextbutton = By.className("next");
	
	public Registration3(WebDriver driver) {
		this.driver = driver;
	}

	public void inputprofilename() {
		driver.findElement(profilename).sendKeys("Test");
	}
	public void inputemail(String emailaddress) {
		driver.findElement(email).sendKeys(emailaddress);
	}
	public void inputpassword() {
		driver.findElement(password).sendKeys("Passw0rd");
	}
	public void inputconfirmpassword() {
		driver.findElement(confirmpassword).sendKeys("Passw0rd");
	}
	public void inputaddressl1() {
		driver.findElement(addressl1).sendKeys("20 York Mills");
	}
	public void inputaddressl2() {
		driver.findElement(addressl2).sendKeys("Road");
	}
	public void choosestate(){
		driver.findElement(state).click();
		driver.findElement(pickstate).click();
		}
	public void inputcity() {
		driver.findElement(city).sendKeys("Toronto");
	}
	public void inputzip() {
		driver.findElement(zipcode).sendKeys("12345");
	}
	public void inputphonenumber() {
		driver.findElement(phone).sendKeys("647 256 86521");
	}
	public void clicknext() {
		driver.findElement(nextbutton).click();
	}
	
	
	

}


