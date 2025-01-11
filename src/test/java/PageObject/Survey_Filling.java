package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Survey_Filling  extends BasePage{

	public Survey_Filling(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	@FindBy (xpath="//input[@id='phone_number_input']")
	WebElement phone_number_input;
	@FindBy (xpath="//*[text()='Verify']")
	WebElement Verify_to_get_entry;
	@FindBy (xpath="//*[@name='option']")
	List <WebElement> ques_choice;
    @FindBy(xpath="//input[@type='submit']")
    WebElement next_btn;
    @FindBy (xpath="//*[text()='Awesome!']")
    WebElement Survey_filled_Verification;
    
    
    public void phone_number_input(String phone_no)
    {
    	Actions act = new Actions (driver);
    	act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("I").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
    	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    	WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(phone_number_input));
        wb.sendKeys(phone_no);;
    }
    public void Verify_to_get_entry()
    {
    	Verify_to_get_entry.click();
    }
    public void ques_choice(String choice_for_survey)
    {
    	for (WebElement opt:ques_choice)
    	{
    		if (opt.getAttribute("value").equals(choice_for_survey))
    		{
    			try
    			{
    			System.out.println(opt.getAttribute("Value"));
    			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    			WebElement ws=wait.until(ExpectedConditions.elementToBeClickable(opt));
    			ws.click();
    			}
    			catch (Exception e)
    			{
    			JavascriptExecutor js = (JavascriptExecutor) driver;
    			js.executeScript("arguments[0].click();", opt); break;
    			}
    			
    		}
    	}
    }
    public void next_btn()
    {
    	next_btn.click();
    }
    public boolean Survey_filled_Verification()
    
    {
    	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    	WebElement wb=wait.until(ExpectedConditions.visibilityOf(Survey_filled_Verification));
    	return (wb.isDisplayed());
    }
}
