package com.Filereader;

import org.openqa.selenium.WebDriver;

import com.Gmail.pom.Inbox_Page;
import com.Gmail.pom.Login_Page;
import com.ebay.pom.Ebay_page;


public class Page_Object_manager {
public static WebDriver driver;

	private Login_Page login;
	private Inbox_Page inbox;
	private Ebay_page ebay;
	
	
	
	
	public Page_Object_manager(WebDriver driver2) {
	this.driver= driver2;
	}
	public Login_Page getLogin() {
		if (login ==null) {
			 login = new Login_Page(driver);
		}		return login;
	}
	public Inbox_Page getInbox() {
		if (inbox ==null) {
			inbox = new Inbox_Page(driver);
		}		return inbox;
	}
	public Ebay_page getEbay() {
		if (ebay ==null) {
			ebay = new Ebay_page(driver);
		}		return ebay;
	}
}
