package com.Gamil_Project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	
	public static WebDriver driver; // --------------null

	// Browser launch()
	public static WebDriver getBrowser(String type) {
		if (type.equalsIgnoreCase("Chrome")) {

	ChromeOptions co =new ChromeOptions();
	co.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
			
			
		} else if (type.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Admin\\eclipse-workspace\\Adactin_Project\\Driver");

			driver = new FirefoxDriver();
		} else if (type.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Admin\\eclipse-workspace\\Adactin_Project\\Driver");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		return driver;
	}

	// close
	public static void close() {
		driver.close();
	}
	// quit

	public static void quit() {
		driver.quit();
	}

	
//		Navigate to
	public static void navigations(String navigationname, String url) {
		if (navigationname.equalsIgnoreCase("to")) {
			driver.navigate().to(url);
		} else if (navigationname.equalsIgnoreCase("back")) {
			driver.navigate().back();
		} else if (navigationname.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (navigationname.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}
	}

//		Get 

	public static void url(String url) {
		driver.get(url);

	}

//		Alert
public static void alert(String type) {
	Alert alert = driver.switchTo().alert();
	if (type.equalsIgnoreCase("Simple_alert")) {
		alert.accept();
	}else if (type.equalsIgnoreCase("Confrm_ok")) {
alert.accept();		
	}else if (type.equalsIgnoreCase("Confirm_cancel")) {
		alert.dismiss();
	} else if (type.equalsIgnoreCase("Prompt")) {
		String s = null;
		alert.sendKeys(s);
	alert.accept();
	}
}public static void waitforElementVisiblity(WebElement element) {
	try {
		WebDriverWait wb = new WebDriverWait(driver, 60);
		wb.until(ExpectedConditions.visibilityOf(element));
	} catch (Exception e) {

		e.printStackTrace();
	}
}
	
	
	
	// Action

	public static void getactions(WebElement element, String actionName) {

		Actions a = new Actions(driver);

		if (actionName.equalsIgnoreCase("moveto")) {
			a.moveToElement(element).build().perform();
		} else if (actionName.equalsIgnoreCase("click")) {
			a.moveToElement(element).build().perform();
		} else if (actionName.equalsIgnoreCase("doubleclick")) {
			a.moveToElement(element).build().perform();
		} else if (actionName.equalsIgnoreCase("contextclick")) {
			a.moveToElement(element).build().perform();
		}

	}
	public static void mouseHoverToElement(WebElement element) {
		try {
			waitforElementVisiblity(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

//		Frames	
	public static void frame(String frametype, String id, String index, WebElement element) {
		if (frametype.equalsIgnoreCase("id")) {
			driver.switchTo().frame(id);
		} else if (frametype.equalsIgnoreCase("index")) {
			driver.switchTo().frame(index);
		} else if (frametype.equalsIgnoreCase("webelement")) {
			driver.switchTo().frame(element);
		} else if (frametype.equalsIgnoreCase("parentframe")) {
			driver.switchTo().parentFrame();
		} else if (frametype.equalsIgnoreCase("default")) {
			driver.switchTo().defaultContent();
		}
	}

//		Robot
          //public static void keyboardActions(String keyboardOptions,String keys) throws AWTException {
	public static void keyboardActions(String keyboardOptions,String keys) throws AWTException {
	Robot r = new Robot();
           //	if (keyboardOptions.equalsIgnoreCase("enter")) {	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);

}	
	
	//		Drop down 
	public static void dropselect(WebElement element, String selecttype, String value) {
		Select s = new Select(element);
		if (selecttype.equalsIgnoreCase("byvalue")) {
			s.selectByValue(value);
		} else if (selecttype.equalsIgnoreCase("byindex")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		} else if (selecttype.equalsIgnoreCase("byvisibletext")) {
			s.selectByVisibleText(value);
		}
	}

	public static void deselect(WebElement element, String selecttype, String value) {
		Select d = new Select(element);
		if (selecttype.equalsIgnoreCase("byvalue")) {
			d.deselectByValue(value);
		} else if (selecttype.equalsIgnoreCase("byindex")) {
			int index = Integer.parseInt(value);
			d.deselectByIndex(index);
		} else if (selecttype.equalsIgnoreCase("byvisibletext")) {
			d.deselectByVisibleText(value);
		} else if (selecttype.equalsIgnoreCase("deselectall")) {
			d.deselectAll();
		}
	}

	public static void dgetoptions(WebElement element, String gettypes) {
		Select g = new Select(element);
		if (gettypes.equalsIgnoreCase("getoptions")) {
			g.getOptions();
		} else if (gettypes.equalsIgnoreCase("getallselectedoption")) {
			g.getAllSelectedOptions();
		} else if (gettypes.equalsIgnoreCase("getfirstselectedoptions")) {
			g.getFirstSelectedOption();
		}
	}


	
	
	
	
	
	
	//		Is enable
	public static void isenable(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	// Is displayed
	public static void isdisplay(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}

	// Is selected
	public static void isSelect(WebElement element) {
		boolean Select = element.isSelected();
		System.out.println(Select);
	}


//		Get title
	public static void getthetitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

//		Get current url 
	public static void getthecurrentURL(WebElement element) {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

//		Get text 
	public static void getthetext(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	// Get attribute
	public static void gettheattribute(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
	}

	// sleep
	public static void sleep(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	// Wait------>>>
	   //implicitwait
	public static void implicitwait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
        //expliitwait
	public static void explicitwait(int seconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
        //fluentwait
	public static void fluentwait(int a) {

	}

//		Take screenshot
	public static void screenshot(String TSfolderpath) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(TSfolderpath);
		FileUtils.copyFile(source, destination);
		
	}
	
	

	// Scroll up and down
	public static void scrollelements(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
			JavascriptExecutor jws = (JavascriptExecutor) driver;
				jws.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	//scroll range
	public static void scrollrange(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");		
	}
	// Sendkeys
	public static void inputvalues(WebElement element, String value) {
		element.sendKeys(value);
	}

//		Click()
	public static void clickOptions(WebElement element) {
		element.click();
	}

//clear
	public static void delete(WebElement element) {
		element.click();
		element.clear();
	}

}
