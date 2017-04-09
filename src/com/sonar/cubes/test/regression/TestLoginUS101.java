package com.sonar.cubes.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sonar.cubes.project.utils.CreateDriver;
import com.sonar.cubes.ui.LoginPage;
import com.sonar.cubes.utils.GetData;

public class TestLoginUS101 
{
	WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp()
	{
		driver = CreateDriver.getDriver();
		loginPage = new LoginPage(driver);
	}
	@Test
	public void testInValidLoginTC1358() throws InterruptedException
	{
		String un = GetData.fromExcel("data", "US001", 0, 0);
		loginPage.WaitForLoginPage();
		loginPage.getUsernameTextbox().sendKeys(un);
		loginPage.getPasswordTextbox().sendKeys("gdgdgdg");
		Thread.sleep(5000);
		loginPage.getLoginbutton().click();
		String actualMsg = 
				loginPage.getLoginErrorMessage().getText();
		String expectedMsg = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	@Test
	public void testInValidLoginTC1359() throws InterruptedException
	{
		String pwd = GetData.fromExcel("data", "US001", 0, 1);
		loginPage.WaitForLoginPage();
		loginPage.getUsernameTextbox().sendKeys("dgsgdg");
		loginPage.getPasswordTextbox().sendKeys(pwd);
		loginPage.getLoginbutton().click();
		Thread.sleep(5000);
		String actualMsg = 
				loginPage.getLoginErrorMessage().getText();
		String expectedMsg = "Username or Password is invalid. "
				+ "Please try again.";
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
