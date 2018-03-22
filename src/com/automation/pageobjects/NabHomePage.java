package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NabHomePage {

private WebDriver driver;

//page elements

	
	public NabHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public NabHomePage verifyHomePage() {
		WebElement element = driver.findElement(By.xpath("//li/a[text()='Personal']"));
		return this;
	}
	
	public LoanRepaymentCalculatorPage clickLoanRepaymentButton() {
		WebElement element = driver.findElement(By.xpath("//p[text()='Loan repayments calculator']"));
		
		if(element.isDisplayed() || element.isEnabled())
		{
			element.click();
		}
		 else System.out.println("Element not found or not clickable");
		
		return new LoanRepaymentCalculatorPage(driver);
	}
	
}