package com.Radius.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Radius.qa.Base.TestBase;
import com.Radius.qa.Pages.ForgetPwd_Page;
import com.Radius.qa.Pages.Home_Page;
import com.Radius.qa.Pages.Login_Page;
import com.Radius.qa.Pages.SignUp_Page;

public class LoginPage_Test extends TestBase {
	Login_Page LoginObj;
	Home_Page HomeObj;
	SignUp_Page SignUpObj;
	ForgetPwd_Page FpwdObj;
	
	public LoginPage_Test() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initilization();
		LoginObj = new Login_Page();
	}
	
	@Test(priority=1)
	public void Verify_LoginTest() throws InterruptedException {
		HomeObj=LoginObj.Validate_Login(prop.getProperty("email_id"), prop.getProperty("pass_word"));
		String HomeTitle =driver.getTitle();
		System.out.println("Tittle of HomePage is: "+HomeTitle);
	}
	
	@Test
	public void SignUpTest() {
		SignUpObj=LoginObj.validate_SignUp();
		String SignUpTitle =driver.getTitle();
		System.out.println("Tittle of  SignUp page is "+SignUpTitle);
	}
	
	@Test
	public void ForgotPasswordTest() {
		FpwdObj=LoginObj.Validate_ForgetPwd();
		String ForgotpwdTitle =driver.getTitle();
		System.out.println("Tittle of Forgot Pwd is: "+ForgotpwdTitle);		
	}
	
	@Test
	public void Logo_Test() {
		Boolean img = LoginObj.validate_Logo();
		Assert.assertTrue(img);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
