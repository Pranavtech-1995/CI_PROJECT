package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuilderSurveyCreation extends BasePage {

	public BuilderSurveyCreation(WebDriver driver) 
	{
		super(driver);
		
	}
	public WebDriverWait wait;
	
	@FindBy (xpath="//*[@class='fa fa-plus']")
	WebElement AddSurvey_button;
	@FindBy (xpath="//*[@placeholder='Add New Survey']")
	WebElement AddSurvey_Placeholder;
	@FindBy (xpath="//*[text()='Build Survey']")
	WebElement Build_Survey_btn;
	@FindBy (xpath="//div[contains(text(),'Add Question')]")
	WebElement Add_ques;
	@FindBy (xpath="//input[@id='quesTextField0']")
	WebElement ques_text_field;
	@FindBy (xpath="//input[@name='optionText0']")
	WebElement option_text_atindex_o;
	@FindBy (xpath="//a[normalize-space()='Add Option']")
	WebElement Addmore_option;
	@FindBy (xpath="//input[@name='optionText1']")
	WebElement option_text_atindex_1; 
	@FindBy (xpath="//button[text()='Save']")
	WebElement save_Btn;
	@FindBy(xpath="//*[@class='Survey_Name ng-binding']")
    List <WebElement> Survey_Editing;
	@FindBy (xpath="//*[@src='img/edit.png']")
	WebElement Survey_edit_btn;
	@FindBy (xpath="//p[@class='ng-binding']")
	WebElement Survey_Verification;
	
	public void AddSurvey_button()
	{
		AddSurvey_button.click();
	}
	public void AddSurvey_Placeholder(String Survey_name)
	{
		AddSurvey_Placeholder.sendKeys(Survey_name);
	}
	public void Build_Survey_btn()
	{
		Build_Survey_btn.click();
		driver.switchTo().alert().accept();
		
		
	}
	
	public void Survey_edit_btn()
	{
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement wt=wait.until(ExpectedConditions.elementToBeClickable(Survey_edit_btn));
		wt.click();
	}
	public void Add_ques() 
	{
		 try 
		 {
			WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(Add_ques));
			wb.click();
		 }
		catch(Exception e ) 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", Add_ques);
			e.getMessage();
		}
		
	 }
	public void ques_text_field(String ques)
	{
		WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(ques_text_field));
		wb.sendKeys(ques);
	}
	public void option_text_atindex_o (String ques_text)
	{
		option_text_atindex_o.sendKeys(ques_text);
	}
	public void Addmore_option()
	{
		Addmore_option.click();
	}
	public void option_text_atindex_1(String Option_1)
	{
		option_text_atindex_1.sendKeys(Option_1);
	}
	public void save_Btn()
	{
		save_Btn.click();
	}
	public String Builder_Verification()
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement wt=wait.until(ExpectedConditions.elementToBeClickable(Survey_Verification));
		return (wt.getText());
	}

}
