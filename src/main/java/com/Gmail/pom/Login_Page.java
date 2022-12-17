package com.Gmail.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public WebDriver driver;
	public Login_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='email']")
	public WebElement username;
	
	
	public WebElement getUsername() {
		return username;
	}
	
	@FindBy(xpath = "//span[@class='VfPpkd-vQzf8d'][text()='Next']")
	public WebElement nextbtn;
	
	
	public WebElement getNextbtn() {
		return nextbtn;
	}
	
	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;
	
	
	public WebElement getPassword() {
		return password;
	}
	

	@FindBy(xpath = "//span[@class='VfPpkd-vQzf8d'][text()='Next']")
	public WebElement passwordbtn;
	
	
	public WebElement getPasswordbtn() {
		return passwordbtn;
	}
	
	
}
