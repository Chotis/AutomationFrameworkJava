package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {

private WebDriver driver;

//page elements
private By nabResultItem = By.xpath("//a[text()='NAB Personal Banking - insurance, loans, accounts, credit cards - NAB']");

	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public NabHomePage clickNabLink()
	{
	    WebElement element = driver.findElement(nabResultItem);
	   
	    if (element.isDisplayed() || element.isEnabled()) {
			element.click();
		}
	    else System.out.println("Element not found");
	    
	    return new NabHomePage(driver);
	}
	
	public SearchResultsPage verifyPageResults() {
		WebElement element = driver.findElement(By.xpath("//a[text()='NAB Personal Banking - insurance, loans, accounts, credit cards - NAB']"));
		return this;
	}
	
	
}
