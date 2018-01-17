package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration4 {
		WebDriver driver;
		By geneticsconsent = By.xpath("//*[@id=\'page-form\']/ul/li[1]/div[2]/label/span[4]");
		By policyconsent = By.xpath("//*[@id=\'page-form\']/ul/li[2]/div[2]/label/span[4]");
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