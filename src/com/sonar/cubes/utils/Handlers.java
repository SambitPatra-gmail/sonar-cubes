package com.sonar.cubes.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Handlers {
	
	public static void acceptAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public static void dismissAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public static String getAlertTxt(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		return alt.getText();
	}
	
	public static void enterTexttoAlert(WebDriver driver,String data)
	{
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(data);
	}
	public static void selectDDLByIndex(WebElement element, int index)
	{
		Select sct = new Select(element);
		sct.selectByIndex(index);
	}
	public static void selectDDLByText(WebElement element, String text)
	{
		Select sct = new Select(element);
		sct.selectByVisibleText(text);
	}
	
	public static void selectDDLByValue(WebElement element, String value)
	{
		Select sct = new Select(element);
		sct.selectByValue(value);
	}
	public static boolean isDDLMultiple(WebElement element)
	{
		Select sct = new Select(element);
		return sct.isMultiple();
	}
	
	public static void deSelectDDLByIndex(WebElement element, int index)
	{
		Select sct = new Select(element);
		sct.deselectByIndex(index);
	}
	public static void deSelectDDLByText(WebElement element, String text)
	{
		Select sct = new Select(element);
		sct.deselectByVisibleText(text);
	}
	
	public static void deSelectDDLByValue(WebElement element, String value)
	{
		Select sct = new Select(element);
		sct.deselectByValue(value);
	}
	public static void deSelectDDLAll(WebElement element)
	{
		Select sct = new Select(element);
		sct.deselectAll();
	}
	
	
	
	

}
