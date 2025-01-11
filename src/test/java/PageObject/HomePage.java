package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{


public HomePage (WebDriver driver )
{
	super(driver);
}


@FindBy (xpath="//*[text()='Welcome to Insight ']")
WebElement HomepageTitle;
@FindBy (xpath="//*[text()=' Survey']")
WebElement survey_tab;
@FindBy(xpath="//a[normalize-space()='Survey Manager']")
WebElement SurveyManager_tab;
@FindBy(xpath="//*[@name='SsSurveys[id]']")
WebElement survey_idsearching;
@FindBy(xpath="//img[@alt='update']")
WebElement update_survey_click;
@FindBy (xpath="//*[@style='color: #0E3460']")
WebElement Survey_Name;
@FindBy (xpath="//*[text()=' CI Manager']")
WebElement Ci_Request;
@FindBy (xpath="//*[@class='active']//a")
List <WebElement> side_bar_option;
@FindBy (xpath="//*[@class='breadcrumb']//li")
List<WebElement> breadcrumblisting;





public boolean HomepageTitle()
{
	 try 
	 {
	   return HomepageTitle.isDisplayed();
	 }
	 catch (Exception e)
	 {
		 return false;
	 }
}
	 

public void survey_tab()
{
	survey_tab.click();
	
}
public void SurveyManager_tab()
{
	SurveyManager_tab.click();
	
}
public void survey_idsearching(String survey_id)
{
	
	WebDriverWait webdriverwait= new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement wb=webdriverwait.until(ExpectedConditions.elementToBeClickable(survey_idsearching));
	wb.sendKeys(survey_id);
	Actions act = new Actions(driver);
    act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	
}
 public void update_survey_click()
 {
	 WebDriverWait webdriverwait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement wb=webdriverwait.until(ExpectedConditions.elementToBeClickable(update_survey_click));
		wb.click();
 }
 
public String Survey_Name()
{
	String sname=Survey_Name.getText();
	
	return sname;
}
public void Ci_Request()
{
	Ci_Request.click();
}
public void side_bar_option(String side_bar_options)
{
	for (WebElement opt:side_bar_option)
	{
		if (opt.getText().contains(side_bar_options))
		{
			WebDriverWait Wait  =new WebDriverWait(driver,Duration.ofSeconds(10));
			 WebElement wb=Wait.until(ExpectedConditions.elementToBeClickable(opt));
			wb.click();break;
		}
	}
}

public void breadcrumbselection (String breadcrumbsselection)
{
	for (WebElement opt:breadcrumblisting)
	{
		if (opt.equals(breadcrumbsselection))
		{
			opt.click();
		}
	}
}

}
