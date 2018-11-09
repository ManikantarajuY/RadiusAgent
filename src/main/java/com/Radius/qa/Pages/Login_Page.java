package com.Radius.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Radius.qa.Base.TestBase;

public class Login_Page extends TestBase {
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Email']")
	WebElement Email_ID;
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Password']")
	WebElement Pass_Word;
	
	@FindBy(how=How.XPATH, using="//div[text()='Forgot your password?']")
	WebElement ForgetPassword_link;
	
	@FindBy(how=How.XPATH, using="//button[text()='Login']")
	WebElement Login_Button;
	
	@FindBy(how=How.XPATH, using="//img[@class='withRegisterContainer__SideImage-wglpm6-3 FOJeb']")
	WebElement Radius_Logo;
	
	@FindBy(how=How.XPATH, using="//a[text()='Sign Up']")
	WebElement SignUp;
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_Title() {
		return driver.getTitle();
	}
	
	public boolean validate_Logo() {
		return Radius_Logo.isDisplayed();
	}
	
	public boolean Validate_SignUPLink() {
		return SignUp.isDisplayed();
	}
	
	public boolean Validate_ForgotPasswordLink() {
		return ForgetPassword_link.isDisplayed();
	}
	
	public Home_Page Validate_Login(String un, String Pwd) throws InterruptedException {
		Email_ID.sendKeys(un);	
		Thread.sleep(1500);
		Pass_Word.sendKeys(Pwd);
		Thread.sleep(1500);
		Login_Button.click();
		Thread.sleep(1000);
		return new Home_Page();		
	}
	
	public SignUp_Page validate_SignUp() {
		SignUp.click();
		return new SignUp_Page();
	}
	
	public ForgetPwd_Page Validate_ForgetPwd() {
		ForgetPassword_link.click();
		return new ForgetPwd_Page();
	}
}