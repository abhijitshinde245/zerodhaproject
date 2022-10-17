package Pomclasses;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilclass.UtilClass1;

public class HomePage extends UtilClass1{
  static WebDriver driver;
	@FindBy(xpath = "//span[text()='Funds']") private WebElement fundbutton;
	@FindBy(xpath = "//button[@type='button']") private WebElement addfundbotton;
	@FindBy(xpath = "(//input[@type='text'])[1]") private WebElement amount;
	@FindBy(xpath = "(//input[@type='text'])[2]") private WebElement upiid;
	@FindBy(xpath = "//button[@type='submit']") private WebElement continuebutton;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void Fundbutton() {
		//UtilClass1.explicitlywait().until(ExpectedConditions.visibilityOf(fundbutton));
		fundbutton.click();
	}
	public void Addfundbotton() {
		addfundbotton.click();
	}
	public static WebDriver switchtopage() {
		
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator<String> it = windowhandle.iterator();
		String mainwindow = it.next();
		String childwindow = it.next();
		WebDriver Childwindow = driver.switchTo().window(childwindow);
		
			return Childwindow;
			
		
	}
	public void addmoney() {
		
		
		amount.sendKeys("10");
	}
	public void Upiid(String key) throws IOException {
		amount.sendKeys(UtilClass1.getdata("upiid"));
	}
	public void Continuebutton()  {
		continuebutton.click();
	}
}
