package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportLoginPage extends BasePage {

	public ReportLoginPage(WebDriver driver) 
	{
		super(driver);
		
	}

	
@FindBy (xpath="//input[@name='inemail']")
WebElement email_input;
@FindBy(xpath="//input[@name='inpassword']")
WebElement password_input;
@FindBy (xpath="//button[normalize-space()='Login']")
WebElement Login_btn;
@FindBy (xpath="//div[@class='welcome_div ng-binding']")
WebElement Login_verification;

public void Change_Url()
{
	driver.get("https://reports.crownit.in/");
}


public void email_input(String Username)
{
	WebDriverWait wb= new WebDriverWait(driver,Duration.ofSeconds(10));
	 WebElement wait=wb.until(ExpectedConditions.visibilityOf(email_input));
	wait.sendKeys(Username);
}

public void password_input (String Password)
{
	password_input.sendKeys(Password);
}
public void Login_btn()
{
	Login_btn.click();
}
public String Login_verification()
{
	
	return (Login_verification.getText());
}

}
