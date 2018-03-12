package script;


import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;

import page.LoginPage;

public class InvalidLogin extends BaseTest {
@Test(priority=2,groups="login")
public void testInvalidLogin()
{
	int rc = Excel.getRowCount(XL_PATH, "InvalidLogin");
	for(int i=1;i<rc;i++)
	{

	String un = Excel.getValue(XL_PATH, "InvalidLogin", i, 0);
	String pw = Excel.getValue(XL_PATH, "InvalidLogin", i, 1);
	String expectedErrmsg = Excel.getValue(XL_PATH, "InvalidLogin", i, 2);
	LoginPage l=new LoginPage(driver);
	//Enter Valid UN
			l.setUserName(un);
			//Enter Valid pw
			l.setPassword(pw);
			//Click login
			l.clickLogin();
			//Verify error msg
			l.verifyErrMsg(expectedErrmsg);
			
	}

}
}