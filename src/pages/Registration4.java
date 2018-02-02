package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration4 {
		WebDriver driver;
		By geneticsconsent = By.xpath("//*[@id=\'page-form\']/ul/li[1]/div[2]/label/span[4]");
		By policyconsent = By.xpath("//*[@id=\'page-form\']/ul/li[2]/div[2]/label/span[4]");
		
		public Registration4(WebDriver driver) {
			this.driver = driver;
		}
		public void clickgeneticsconsent() {
			driver.findElement(geneticsconsent).click();
		}
		public void policyconsent() {
			driver.findElement(policyconsent).click();
		}
		
		
		
}