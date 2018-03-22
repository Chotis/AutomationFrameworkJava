package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	//webdriver
	protected WebDriver driver;
	
	//page elements
	private By searchBar = By.xpath("//input[@title='Search']");
	private By searchButton = By.xpath("//input[@value='Google Search']");
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//enters search text 
	public BasePage enterSearchText(String searchTerm)
	{
		WebElement searchBarElement=driver.findElement(searchBar);
		if(searchBarElement.isDisplayed()||searchBarElement.isEnabled())
		{
			searchBarElement.sendKeys(searchTerm);
		}
		else System.out.println("Element not found");
		
		return this;
	}
		
	//takes user to search results page
	public SearchResultsPage clickSearchButton() {
		System.out.println("clicking the search button");
		WebElement searchButtonElement=driver.findElement(searchButton);
		if(searchButtonElement.isDisplayed()||searchButtonElement.isEnabled())
		{
			searchButtonElement.click();
		}
		else System.out.println("Element not found");
		
		return new SearchResultsPage(driver);
	}
		
}