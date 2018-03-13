package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.EnterPage;
import page.LoginPage;

public class CheckProductVersion extends BaseTest {
@Test(priority=3,groups="login")
public void testCheckProductVersion()
{
	String un=Excel.getValue(XL_PATH, "CheckProductVersion", 1, 0);
	String pw=Excel.getValue(XL_PATH, "CheckProductVersion", 1, 1);
	String eTitle=Excel.getValue(XL_PATH, "CheckProductVersion", 1, 2);
	String eVersion=Excel.getValue(XL_PATH, "CheckProductVersion", 1, 3);
	
	
	LoginPage l=new LoginPage(driver);
	l.setUserName(un);
	l.setPassword(pw);
	l.clickLogin();
	
	EnterPage e=new EnterPage(driver);
	e.verifyHomePageIsDisplayed(driver, eTitle);
	e.clickHelp();
	e.clickAboutActiTIME();
	e.verifyProductVersion(eVersion);
}
}
