package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.pageobjects.BasePage;
import com.automation.pageobjects.SearchResultsPage;
import com.automation.testbase.TestSetup;

public class BasePageTest extends TestSetup{
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void searchForNABSite() {
		System.out.println("Search for NAB site...");
		BasePage basePage = new BasePage(driver);
		basePage.enterSearchText("NAB").clickSearchButton();
		System.out.println("Verify search results...");
		SearchResultsPage sp = new SearchResultsPage(driver);
		sp.verifyPageResults();
	
	}

}
