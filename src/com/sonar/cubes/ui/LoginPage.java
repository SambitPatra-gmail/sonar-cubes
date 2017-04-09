package com.sonar.cubes.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void WaitForLoginPage(){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("LoginForm")));
	}
		
	public WebElement getUsernameTextbox()
	{
	WebElement element = driver.findElement(By.id("username"));
	return element;
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("pwd"));
	}
	public WebElement getLoginbutton()
	{
		return driver.findElement(By.id("loginButton"));
		
	}
	public WebElement getLoginErrorMessage()
	{
		return driver.findElement(By.xpath("(//span[@class='errormsg'])[1]"));
	}		

}
