package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration1 {
	WebDriver driver;
	By firstname = By.xpath("//*[@id=\"fname\"]/input");
	By lastname = By.xpath("//*[@id=\"lname\"]/input");
	By dateofbirth = By.xpath("//*[@id=\"db\"]/input");
	By nextbutton = By.xpath("/html/body/div[3]/div[1]/div[2]/button");

	public Registration1(WebDriver driver) {
		this.driver = driver;
	}

	public void inputfname(String fname) {
		driver.findElement(firstname).sendKeys(fname);
	}

	public void inputlname(String lname) {
		driver.findElement(lastname).sendKeys(lname);
	}

	public void inputdob(String dob) {
		driver.findElement(dateofbirth).sendKeys(dob);
	}
	public void nextbutton() {
		driver.findElement(nextbutton).click();
	}
	

}
