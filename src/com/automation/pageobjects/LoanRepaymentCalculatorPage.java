package com.automation.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LoanRepaymentCalculatorPage {

private WebDriver driver;

//page elements
private By loanAmount = By.xpath("//div[@data-label='Loan amount']/div/input[2]"); //not the best selector
private By loanTerm = By.xpath("//div[@data-label='Loan term']/div/input[2]"); 
private By interestRateList = By.id("nab-loan-calc-app__repayments--interest-rate");
private By continueButton = By.xpath("//button[@ng-click='gotoResultsRepayment()']");

	public LoanRepaymentCalculatorPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoanRepaymentCalculatorPage verifyPage() {
		WebElement element = driver.findElement(By.xpath("//h1[text()='Loan repayments calculator']"));
		return this;
	}
	
	public LoanRepaymentCalculatorPage enterLoanAmount(String value) {
		WebElement element = driver.findElement(loanAmount);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(element.isDisplayed() || element.isEnabled())
		{
			element.click();
			element.sendKeys(value);
		}
		return this;
	}
	
	public LoanRepaymentCalculatorPage enterLoanTerm(String value) {
		WebElement element = driver.findElement(loanTerm);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(element.isDisplayed() || element.isEnabled())
		{
			element.click();
			element.sendKeys(value);
		}
		return this;
	}
	
	public LoanRepaymentCalculatorPage selectChoicePackage(Boolean value) {
		
		WebElement element;
		
		if(value)
		{
			element = driver.findElement(By.xpath("//div[@data-btn-group='OPTIONS.CHOICE_PACKAGE']//div/button[text()='Yes']"));
		}
		else
		{
			element = driver.findElement(By.xpath("//div[@data-btn-group='OPTIONS.CHOICE_PACKAGE']//div/button[text()='No']"));
		}
		
		if(element.isDisplayed() || element.isEnabled())
		{
			element.click();
		}
		
		return this;
	}
	
	public LoanRepaymentCalculatorPage selectInterestRate() {
		Select element = new Select(driver.findElement(interestRateList));
		element.selectByIndex(2);
		return this;
	}
	
	public LoanRepaymentCalculatorPage clickContinueButton() {
		WebElement element = driver.findElement(continueButton);
		if(element.isDisplayed() || element.isEnabled())
		{
			element.click();
		}
		return this;
	}
	
	public LoanRepaymentCalculatorPage verifyResultsSection()
	{
		WebElement element = driver.findElement(By.xpath("//div[@id='nab-loan-calc-results-borrow']/h2[text()='Your estimated results']"));
		return this;
	}
	
}