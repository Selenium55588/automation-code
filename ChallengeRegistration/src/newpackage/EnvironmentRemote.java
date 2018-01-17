package newpackage;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EnvironmentRemote {
	public static RemoteWebDriver driver ;
	public void setup() throws Exception
	{
		String baseUrl = "https://cloud.my.newtopia.com/uat_registration_v3?nors_id=a1H36000006wdnVEAQ&rc=JPMCPILOT";
	
    DesiredCapabilities capability = new DesiredCapabilities();
    //capability.setPlatform(Platform.WINDOWS);
    capability.setCapability("browser", "IE");
    capability.setCapability("browser_version", "11");
    capability.setCapability("os", "Windows");
    capability.setCapability("os_version", "10");
    capability.setCapability("browserstack.debug", "true");

    capability.setCapability("build", "TestNG - Sample");
    String s = capability.getBrowserName();
    System.out.println(s);

    driver = new RemoteWebDriver(new URL("https://charanjitsingh3:nG8p4wgvp9XTxdw9iKVi@hub.browserstack.com/wd/hub"),
     capability);
    
   	}
	

}
