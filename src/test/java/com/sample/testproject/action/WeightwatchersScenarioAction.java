package com.sample.testproject.action;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sample.testproject.util.PropertiesResolver;

public class WeightwatchersScenarioAction {
	
	private static final String LOAD_TITLE = "weightwatchers.load.title";
	
	@FindBy(id="ela-menu-visitor-desktop-supplementa_find-a-meeting")
	WebElement findMeeting;
	
	@FindBy(id="meetingSearch")
	WebElement zipcodeSearch;
	
	@FindBy(className="input-group-btn")
	WebElement searchButton;
	
	@FindBy(className="location__name")
	WebElement locationName;
	
	@FindBy(className="location__address")
	WebElement locationAddress;
	
	@FindBy(className="location__city-state-zip")
	WebElement locationState;
	
	@FindBy(className="location__distance")
	WebElement locationDistance;
	
	@FindBy(className="meeting-location")
	WebElement meetingLocation;
	
	@FindBy(className="schedule-detailed-day-meetings-item")
	WebElement hoursOfOperation;
	
	@FindBy(xpath=".//*[@id='content']/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[3]/div")
	WebElement listOfHours;
	
	
	public void scheduleMeeting(WebDriver driver) throws Exception{
		//verify title 
		findMeeting.click();
		//verify title
		String actualValue = driver.getTitle();
		Thread.sleep(4000);
		String expectedValue = PropertiesResolver.getProperty(LOAD_TITLE);
		Thread.sleep(4000);
		if(actualValue.contains(expectedValue)){
			return;
		}else{
			System.out.println("Actual Value : " + actualValue);
			System.out.println("Expected Value :" + expectedValue);
			throw new Exception("Weight Watchers Page : Title mismatch");
		}
	}
	
	public void meeting(String zipcode){
		zipcodeSearch.sendKeys(zipcode);
		searchButton.click();
		System.out.println("Title of the first Search : " + locationName.getText());
		meetingLocation.click();
		//verify clicked search equals first search
		//assertTrue(arg0, arg1);
		System.out.println("Todays Hours of operation :" + listOfHours.getText());

	}

}
