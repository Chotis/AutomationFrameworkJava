package com.automation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.pageobjects.BasePage;
import com.automation.pageobjects.LoanRepaymentCalculatorPage;
import com.automation.pageobjects.NabHomePage;
import com.automation.pageobjects.SearchResultsPage;
import com.automation.testbase.TestSetup;

public class CompleteLoanRepaymentForm extends TestSetup{
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void completeLoanRepaymentForm() {
		System.out.println("Search for NAB site...");
		BasePage basePage = new BasePage(driver);
		basePage.enterSearchText("NAB").clickSearchButton();
		SearchResultsPage sp = new SearchResultsPage(driver);
		sp.verifyPageResults();
		sp.clickNabLink();
		NabHomePage nhp = new NabHomePage(driver);
		nhp.clickLoanRepaymentButton();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoanRepaymentCalculatorPage lrcp = new LoanRepaymentCalculatorPage(driver);
		lrcp.selectChoicePackage(false)
		.selectInterestRate()
		.clickContinueButton()
		.verifyResultsSection();
		
		
	
	}

}
