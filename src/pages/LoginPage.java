package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginPage {

	WebDriver driver;
	
	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream("C:\\Kangana\\Software Testing\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Kangana\\Software Testing\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();													//opens firefox browser
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Kangana\\Software Testing\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();													//opens chrome browser
		}else{
			System.setProperty("webdriver.ie.driver", "C:\\Kangana\\Software Testing\\SeleniumJars\\iedriver.exe");
			driver = new InternetExplorerDriver();								//opens ie browser
		}
			}
	
	public void openScotiaBankLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=qzrhbBiytzs&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoicXpyaGJCaXl0enMiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYyMDU3MzU1MywiaWF0IjoxNjIwNTcyMzUzLCJqdGkiOiIzNmJlYjM0OS00MTk0LTQ1NWMtYmRjYi02YjNiNzMyNDBjNjUiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.yNqJMB5Qj393ESZnbxYvwN1iXVH4x_2cIY4EDUz-vhWSnYvbBhYi-d6sPgTq3LEkSSE9o75TXE7mxcGphrBiueTFQU43Zd_ysQ-Z-lZdYDv7KEBMlA7M4QuWr_JM0OezMvyjpp4s2d3xodV_qOKWkV1q2oH36eWh7O0U3G6iQzehfar0mAVOU3b9KjzimW1UxcnCl5whzgfZmH1WYgGYoeYazu8BiXlS2geO_VCv37bGmrpFq2kXKFM_g0UyHaGERNJ");	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String email, String password ) throws InterruptedException {
		 driver.findElement(By.id("usernameInput-input")).sendKeys(email); 		
		  driver.findElement(By.name("password")).sendKeys(password); 		
		  driver.findElement(By.id("signIn")).click();		 		
		  Thread.sleep(2000); 		 			
	}
	
	public String readGlobalErr() {
		String actualErrMsg = driver.findElement(By.id("globalError")).getText();
		System.out.println(actualErrMsg);
		return actualErrMsg;
	}
	
	public String readErr() {
		String actualErr= driver.findElement(By.className("Error__text")).getText(); 		
		  System.out.println(actualErr);
		return actualErr; 	
		 
	}
}
