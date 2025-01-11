package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsightLoginPage extends BasePage {


	public InsightLoginPage(WebDriver driver)
	{
		super(driver);
	}

 
	
	
@FindBy (xpath="//*[text()='Login Via Email']")
WebElement btn_login;
@FindBy (id="LoginForm_username")
WebElement login_input;
@FindBy (id="get_otp")
WebElement btn_otp;
@FindBy (id="LoginForm_otp")
WebElement otp_field;
@FindBy (xpath="//*[@value='Login']")
WebElement Login_btn;
@FindBy (xpath="//*[@class='fa fa-caret-down']")
WebElement Logout_drpdwn;
@FindBy (xpath="//*[text()=' Logout']")
WebElement logout;




public void btn_login()
{
	btn_login.click();
}

public void login_input(String Username)
{
	login_input.sendKeys(Username);
}

public void get_otp ()
{
	btn_otp.click();
}

public void otp_field(String otp) 
{
	otp_field.sendKeys(otp);
}

public void login_btn()
{
	Login_btn.click();
}

public void Logout_drpdwn()
{
	Logout_drpdwn.click();
	
}

public void logout_btn()
{
	logout.click();
}

}
