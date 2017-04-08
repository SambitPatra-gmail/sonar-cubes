package com.sonar.cubes.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void WaitForBasePage(){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("LoginForm")));
	}
	public WebElement getLogoutButton(){
		return driver.findElement(By.id("logoutLink"));
	}

}
