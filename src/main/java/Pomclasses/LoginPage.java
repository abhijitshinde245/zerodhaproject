package Pomclasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilclass.UtilClass1;



public class LoginPage extends UtilClass1 {
	static WebDriver driver;
	@FindBy(xpath = "//input[@id='userid']") private WebElement userid;
	@FindBy(xpath = "//input[@id='password']") private WebElement password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement submitbutton;
	@FindBy(xpath = "//span[text()='Abhijeet']") private WebElement profilename;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	public void Userid() throws IOException {
		
		userid.sendKeys(UtilClass1.getdata("userid"));
	}
	public void Password() throws IOException {
		password.sendKeys(UtilClass1.getdata("password"));
	}
	public void Submitbutton() {
	submitbutton.click();
	}
	public  String getprofilename() {
		explicitlywait(driver,profilename,10);
		String Profilename = profilename.getText();
		System.out.println("Profile Name is : " +Profilename);
		return Profilename;
	}
	
	
}
