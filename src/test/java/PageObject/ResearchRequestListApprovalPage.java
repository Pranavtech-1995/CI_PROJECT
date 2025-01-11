package PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResearchRequestListApprovalPage extends BasePage {

	public ResearchRequestListApprovalPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	@FindBy (xpath="//button[text()='Details']")
	WebElement Details_btn;
	@FindBy (xpath="//button[text()='Accept ']")
	WebElement  Approve_btn;
	@FindBy (xpath="//input[@type='checkbox']")
	WebElement checkbox_tandc;
	@FindBy (xpath="//*[@placeholder='Enter here...']")
	WebElement po_open_filed;
	@FindBy (xpath="//*[text()='Submit']")
	WebElement Submit_Po;
	@FindBy (xpath="//*[text()='Skip for now']")
	WebElement Skipfor_now;
	
	public void Details_btn()
	{
		Details_btn.click();
	}
	public boolean  Approve_btn()
	{
		 try{
			 WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		  WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(Approve_btn));
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView(true);", wb);
		  wb.click();
		 }
		 catch(Exception e)
		 {
			 Actions act = new Actions(driver);
			 act.scrollToElement(Approve_btn).perform();
			 act.moveToElement(Approve_btn).click().build().perform(); 
			 e.printStackTrace();
			 e.getMessage();
	     }
		
		
	return  Approve_btn.isEnabled();
	}
	public void checkbox_tandc()
	{
		 WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		  WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(checkbox_tandc));
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView(true);", wb);
		  wb.click();
	}
	public void po_open_filed()
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value','Testing')",po_open_filed );
		  
		}
		catch (Exception e)
		{
			
			po_open_filed.click();
			System.out.println(e.getMessage());
		}
		  
	}
	public void Submit_Po()
	{
		Submit_Po.click();
	}
	public void Skip_for_now()
	{
		Skipfor_now.click();
	}
	
}
