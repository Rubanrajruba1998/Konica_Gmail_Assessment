package com.Gmail.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inbox_Page {
	public WebDriver driver;
	public Inbox_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//a[contains(@aria-label,\"tester\")]")
	public WebElement icon;
	
	
	public WebElement getIcon() {
		return icon;
	}
}
