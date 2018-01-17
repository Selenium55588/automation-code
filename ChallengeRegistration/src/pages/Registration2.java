package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration2 {
	WebDriver driver;
	By StandardIDNumber = By.xpath("//*[@id=\"ssn\"]/input");
	By nextbutton = By.xpath("/html/body/div[3]/div[1]/div[2]/button[2]");
	

	public Registration2(WebDriver driver) {
		this.driver = driver;
	}

	public void inputfname(int sid) {
		driver.findElement(StandardIDNumber).sendKeys(String.valueOf(sid));
	}
	public void clicknext() {
		driver.findElement(nextbutton).click();
	}
	

}
