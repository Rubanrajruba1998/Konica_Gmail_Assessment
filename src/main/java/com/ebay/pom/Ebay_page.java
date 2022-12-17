package com.ebay.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Ebay_page {

	public WebDriver driver;
	

	
	public Ebay_page(WebDriver driver2) {

		this.driver = driver2;
		PageFactory.initElements(driver, this);
		}


	public WebDriver getDriver() {
		return driver;
	}

@FindBy(xpath="//span[@class='DEFAULT']/parent::span[@class='s-item__price']")
public List<WebElement> priceList;
	

	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchfield;
	
	
	public WebElement getSearchfield() {
		return searchfield;
	}

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement searchbtn;
	
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	
	@FindBy(xpath = "//div/child::span[text()[contains(.,\"Electric Guitar\")]]")
	public WebElement price;
	
	
	public WebElement getPrice() {
		return price;
	}
	
	public List<WebElement> getPriceList() {
		return priceList;
	}


	
	
	@FindBy(xpath = "//div[text()='Continue as Rubanraj.tester']")
	public WebElement gmailButton;



	public WebElement getGmailButton() {
		return gmailButton;
	}
	
	@FindBy(xpath = "//iframe[@title='Sign in with Google Dialog']")
	public WebElement iframe;

	
	public WebElement getIframe() {
		return iframe;
	}
	
	public String getprodprice()
	{
		for(int i=0;i<priceList.size();i++) 
		{
			if(i==0) 
			{
				return priceList.get(i).getText();
				
			}
			else
			{
				break;
			}
		}
		return null;
	}
	
}
