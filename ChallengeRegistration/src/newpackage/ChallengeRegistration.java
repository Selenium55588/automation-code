package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;

public class ChallengeRegistration {
	public static WebDriver driver = new ChromeDriver();
	public static int i = 50;
	public static String baseUrl = "";

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get(baseUrl);

		signin();
		playername();
		System.out.println(i);
		driver.close();	
	}

	public static void signin() throws InterruptedException {
		WebElement myElement = driver.findElement(By.className("form-control"));
		myElement.click();
		myElement.sendKeys("challenge" + i + "@mailinator.com");

		WebElement myElement1 = driver.findElement(By.className("ng-empty"));
		myElement1.click();
		myElement1.sendKeys("000000000000");

		WebElement myElement2 = driver.findElement(By.className("btn"));
		myElement2.click();

		Thread.sleep(2000);
	}

	public static void playername() throws InterruptedException {
		WebElement myElement3 = driver
				.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/div/div/div/div[2]/input"));
		myElement3.sendKeys("challenge" + i + "a");
		myElement3.click();

		WebElement myElement4 = driver
				.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/div/div/div/div[3]/button"));
		myElement4.click();
		Thread.sleep(2000);		
	}
}
