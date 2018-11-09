package com.Radius.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Radius.qa.Util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\HOME\\Testing\\RadiusAgent\\src\\main\\java\\com\\Radius\\qa\\Config\\Config.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
	
	public static void initilization() {
		String Browser_name = prop.getProperty("browser");
		if (Browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (Browser_name.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.out.println("No Browser is Avalible");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
