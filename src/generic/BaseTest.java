package generic;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String ip,String browser) throws Exception {
		String appURL=AutoUtil.getProperty(CONFIG_PATH,"URL");
		String strITO = AutoUtil.getProperty(CONFIG_PATH,"ITO");
		long ITO = Long.parseLong(strITO);
		
		URL whichSystem=new URL("http://"+ip+":4444/wd/hub");
		DesiredCapabilities whichBrowser=new DesiredCapabilities();
		whichBrowser.setBrowserName(browser);
		driver=new RemoteWebDriver(whichSystem, whichBrowser);

		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
	}
	
	//---------------------------------------------------------------------
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult test) {
		String name=test.getName();
		int status=test.getStatus();
		if(status==1) {
			Reporter.log(name+" is PASSED",true);
		}
		else {
			Reporter.log(name+" is FAILED",true);
			AutoUtil.getPhoto(driver,IMG_PATH,name);
		}
		driver.quit();
	}
}


















