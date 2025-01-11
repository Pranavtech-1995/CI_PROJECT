package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Research_Project_Study_Mapping_Page extends BasePage{

	public Research_Project_Study_Mapping_Page(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//img[@src='/assets/images/Projects.png']")
	WebElement Project_btn;
	@FindBy (xpath="//input[@id='global-search-box']")
	WebElement global_search_box_input;
	@FindBy (xpath="//*[@class='search-list']//span")
	List<WebElement> Suggestion_drpdown;
	@FindBy (xpath="(//mat-icon[@role='img'])[4]")
	WebElement edit_btn;
	@FindBy (xpath="//div[@role='menuitem']")
	WebElement edit_click;
	@FindBy (xpath="//div[@id='mat-select-value-3']")
	WebElement link_survey;
	@FindBy (xpath="//input[@placeholder='Search Survey']")
	WebElement Search_Survey ;
	@FindBy (xpath="//*[@role='option']//span")
	List<WebElement> option_selection_from_list;
	@FindBy (xpath="//span[normalize-space()='Update']")
	WebElement Update_btn;
	@FindBy (xpath="//p[@class='notifier__notification-message ng-star-inserted']")
	WebElement ver_message;
	
	public void Project_btn()
	{
		Project_btn.click();
	}
	public void global_search_box_input(String Project_name_research)
	{
		global_search_box_input.sendKeys(Project_name_research);
	}
	public void Suggestion_drpdown(String Project_name_research)
	{
		for (WebElement opt:Suggestion_drpdown)
		{
			if (opt.getText().equals(Project_name_research))
			{
				opt.click();break;
			}
		}
	}
	public void edit_btn()
	{
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		 WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(edit_btn));
		 wb.click();
	
	}
	public void edit_click()
	{
		edit_click.click();
	}
	public void link_survey()
	{
		
		try
		{
			WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
			 WebElement wb=wait.until(ExpectedConditions.visibilityOf(link_survey));
			wb.click();
			
			
		}
		catch (Exception e)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",link_survey );
			
		}
		
	}
	public void Search_Survey(String Survey_name)
	{
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		 WebElement wb=wait.until(ExpectedConditions.visibilityOf(Search_Survey));
		 wb.sendKeys(Survey_name);
	}
	public void option_selection_from_list(String Survey_name )
	{
		for (WebElement opt:option_selection_from_list)
		{
			if (opt.getText().contains(Survey_name))
			{
				System.out.println(opt.getText());
				opt.click();break;
			}
		}
	}
	
	public void Update_btn()
	{
		Update_btn.click();
	}
   public boolean verification()
   {
	   WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
       WebElement wb= wait.until(ExpectedConditions.visibilityOf(ver_message));
	    return wb.isDisplayed();
   }
}
