package script;


import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;

import page.LoginPage;

public class InvalidLogin extends BaseTest {
@Test(priority=2,groups="login")
public void testInvalidLogin()
{
	int r=Excel.getRowCount(XL_PATH, "InvalidLogin");
	for(int i=1;i<=r;i++)
	{
	String un=Excel.getValue(XL_PATH, "InvalidLogin", i, 0);
	String pw=Excel.getValue(XL_PATH, "InvalidLogin", i, 1);
	String expectedMSG=Excel.getValue(XL_PATH, "InvalidLogin", i, 2);
	
	LoginPage l=new LoginPage(driver);
	
	l.setUserName(un);
	l.setPassword(pw);
	l.clickLogin();
	
	l.verifyErrMsg(expectedMSG);
	}
}
}