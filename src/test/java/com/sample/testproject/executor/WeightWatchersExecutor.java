package com.sample.testproject.executor;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sample.testproject.action.WeightwatchersScenarioAction;
import com.sample.testproject.util.PropertiesResolver;

public class WeightWatchersExecutor {
	
	private static final String WEIGHTWATCHERS_URL = "weightwatchers.url";
	private static final String ZIPCODE = "weightwatchers.meeting.zipcode"; 
	private static final String PAGE_TITLE = "weightwatchers.page.title";
	
	WebDriver driver;
	
	WeightwatchersScenarioAction weightWatchersPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(PropertiesResolver.getProperty(WEIGHTWATCHERS_URL));
		Thread.sleep(3000);
		weightWatchersPage = PageFactory.initElements(driver, WeightwatchersScenarioAction.class);
	}

	@Test
	public void testHomepageTitle(){
		assertEquals(PropertiesResolver.getProperty(PAGE_TITLE), driver.getTitle());		
	}

	@Test
	public void testScheduleMeeting() throws Exception{
		weightWatchersPage.scheduleMeeting(driver);
		weightWatchersPage.meeting(PropertiesResolver.getProperty(ZIPCODE));
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
