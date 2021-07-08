package tests;
import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
		
  @Test
  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
	   lp.login(df.incorrectEmail, df.incorrectPassword);
	   Assert.assertEquals(lp.readGlobalErr(), df.globalErr);	
	}
  
  @Test   
  public void loginWithInvalidEmailTest() throws InterruptedException {  	
	  lp.login(df.inValidEmail, df.incorrectPassword);
	  Assert.assertEquals(lp.readErr(), df.emailSpecialCharErr);   
	  }
  
  @Test
  public void loginWithEmptyEmailTest() throws InterruptedException {
	    lp.login("",df.incorrectPassword);	
		Assert.assertEquals(lp.readErr(), df.emptyEmailErr);
  }
  
  @Test
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	    lp.login(df.incorrectEmail, "");	
		Assert.assertEquals(lp.readErr(), df.emptyPasswordErr);
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	    lp.openBrowser();
	    lp.openScotiaBankLoginPage();
  }

  @AfterMethod
  public void afterMethod() {    
	  lp.closeBrowser();
  }

}
