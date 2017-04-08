package com.sonar.cubes.test.smoke;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sonar.cubes.project.utils.CreateDriver;
import com.sonar.cubes.ui.BasePage;
import com.sonar.cubes.ui.LoginPage;
import com.sonar.cubes.utils.GetData;

public class TestLoginUS001 {
	WebDriver driver;
	LoginPage loginPage;
	BasePage basePage;

	@BeforeMethod
	public void Setup()
	{
		driver = CreateDriver.getDriver();
		loginPage = new LoginPage(driver);
		basePage = new BasePage(driver);
	}
	@Test
  public void testValidLoginTC001() throws InterruptedException 
  	{
	String UN=GetData.fromExcel("excel1","US001",0,0);
	
	loginPage.WaitForLoginPage();
	Thread.sleep(10000);
	loginPage.getUsernameTextbox().sendKeys(UN);
	loginPage.getPasswordTextbox().sendKeys(GetData.fromExcel("excel1","US001",0,1));
	loginPage.getLoginbutton().click();
	basePage.WaitForBasePage();
	boolean actual = basePage.getLogoutButton().isDisplayed();
	Assert.assertEquals(actual, true);
	}
	@AfterMethod
	public void Teardown() throws InterruptedException
	{
		Thread.sleep(5000);
		basePage.getLogoutButton().click();
		Thread.sleep(5000);
		driver.close();
	}
	
	
}
