package util;

import org.openqa.selenium.WebDriver;

public class GeneralInfo {
	
	// current URL, title, page source, window handle
	
	private WebDriver driver;

	
	public GeneralInfo(WebDriver driver) {
		this.driver = driver;
	}
	

	// GET URL
	public String getUrl() {	
		return driver.getCurrentUrl();
	}
	// GET PAGE TITLE
	public String getTitle() {		
		return driver.getTitle();
	}
	// PAGE SOURCE
	public String getPageSource() {
		return driver.getPageSource();
	}
	// WINDOW HANDLE
	public String getMyWindowHandle() {
		return driver.getWindowHandle();
	}
	
	public void generalInfos() {
		System.out.println("Current URL:	" + getUrl());
		System.out.println("Page title:	" + getTitle());
		System.out.println("Page source:	" + getPageSource());
		System.out.println("Page window handle:	" + getMyWindowHandle());
	}
	
}
