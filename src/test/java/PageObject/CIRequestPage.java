package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CIRequestPage extends BasePage{

	public CIRequestPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath="//tbody/tr")
	List<WebElement> rows_count;
	@FindBy (xpath="//tbody//tr")
	List<WebElement> rows_counts;
	@FindBy (xpath="//textarea[@id='feeQuote']")
	WebElement feeQuote_box;
	@FindBy (xpath="//button[@id='sendApproval']")
	WebElement sendApproval;
	
	public String Request_opening(String Project_name)
	{
		String request_id = null;
		for (int r=1;r<=rows_count.size();r++)
		{
			String Survey_name=driver.findElement(By.xpath("//tbody/tr["+r+"]/td[2]")).getText();
		
			if (Survey_name.equals(Project_name))
			{
			     request_id=driver.findElement(By.xpath("//tbody/tr["+r+"]/td[1]")).getText();
				 driver.findElement(By.xpath("//tbody/tr["+r+"]/td[6]//img")).click();break;
			}
		
		}
		
		return request_id;
		
	}
	
	public void Accept_request () throws InterruptedException
	{
		  for (int r=1;r<=2;r++)
		  {
		
		     driver.findElement(By.xpath("//tbody/tr["+r+"]/td[8]/button[1]")).click();
		     driver.switchTo().alert().accept();
		     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		     Alert at= wait.until(ExpectedConditions.alertIsPresent());
		    at.accept();
	
		  }
    
	}
	public void feequote_text(String RandomString)
	{
		feeQuote_box.sendKeys(RandomString);
	}
	public void sendApproval()
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		    WebElement Wb=wait.until(ExpectedConditions.elementToBeClickable(sendApproval));
		    Wb.click();
		    driver.switchTo().alert().accept();
		}
		catch (Exception e)
		{
		    Actions act = new Actions(driver);
			act.scrollToElement(sendApproval);
			act.moveToElement(sendApproval).click().build().perform();
			driver.switchTo().alert().accept();
		}
			
	}


}
