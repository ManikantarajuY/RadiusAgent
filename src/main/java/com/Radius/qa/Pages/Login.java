package com.Radius.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\SW_64bit\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://radiusagent.com/login");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("777manikantaraju@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.close();
	}

}
