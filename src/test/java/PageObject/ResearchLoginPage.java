package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class ResearchLoginPage extends BasePage {



public ResearchLoginPage(WebDriver driver)

{
    super(driver);
}

@FindBy (xpath="//*[@name='username']")
WebElement username_input;
@FindBy (xpath="//*[text()='Login with Password']")
WebElement Loginwithpassword;
@FindBy (xpath="//*[@name='password']")
WebElement password_input;
@FindBy (xpath="//span[text()='Login']")
WebElement login_button;


public void get_url()
{
	driver.get("https://research.crownit.in/login");
}
public void username_input(String username)
{
	username_input.sendKeys(username);
}
public void Loginwithpassword()
{
	Loginwithpassword.click();
}
public void password_input(String password)
{
	password_input.sendKeys(password);
}
public void login_button()
{
	login_button.click();
}

}
