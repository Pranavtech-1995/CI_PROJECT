package PageObject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QualSetUpPage extends BasePage {
 
	
	public QualSetUpPage(WebDriver driver)
	{
		super(driver);
	}



@FindBy (xpath="//*[text()='Qual Setup']")
WebElement Open_QualSetUpPage;
@FindBy (xpath="//select[@id='study_mode']")
WebElement study_mode;
@FindBy (xpath="//span[@id='select2-chosen-7']")
WebElement Request_id_tab;
@FindBy (xpath="//input[@id='s2id_autogen7_search']")
WebElement Request_id_name;
@FindBy (xpath="//input[@name='chk_res[]']")
WebElement check_box_select;
@FindBy (xpath="//button[text()='Schedule Interview']")
WebElement Schedule_Interview_btn;
@FindBy (xpath="//input[@name='name']")
WebElement Topic_input;
@FindBy(xpath="(//*[@id='ci_requests']//option)[2]")
WebElement option2;
@FindBy (xpath="//select[@id='ci_requests']")
WebElement ci_requests_type;
@FindBy (xpath="//textarea[@id='usership_criteria']")
WebElement usership_criteria_input;
@FindBy (xpath="(//input[@placeholder='Meeting Link'])[1]")
WebElement Meeting_Link;
@FindBy (xpath="//form[@id='sch_int_form']//input[@name='int_date']")
WebElement int_date;
@FindBy (xpath="(//input[@name='int_time_from'])[1]")
WebElement int_time_from;
@FindBy (xpath="//form[@id='sch_int_form']//input[@name='int_time_to']")
WebElement int_time_to;
@FindBy (xpath="(//input[@placeholder='Reward Amount'])[1]")
WebElement Reward_Amount;
@FindBy (xpath="(//*[@class='select2-choices'])[1]//li//input")
WebElement Interviwer_select;
@FindBy (xpath="(//button[text()='Save'])[1]")
WebElement Save_btn;
@FindBy (xpath="(//*[text()='Show'])[1]")
WebElement show_interview;
@FindBy (xpath="(//*[@class='mark_complete']//i)[1]")
WebElement mark_complete;
@FindBy (xpath="(//*[@class='fa fa-ellipsis-v options'])")
WebElement action_for_complete;






public void  Open_QualSetUpPage()
{
	Open_QualSetUpPage.click();
}
public void study_mode()
{
	Select s= new Select(study_mode);
	s.selectByVisibleText("Qual");
}
public void Request_id_name(String Project_name) throws InterruptedException
{
	Request_id_name.sendKeys(Project_name);
	Thread.sleep(1000);
	Actions act = new Actions(driver);
	act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
}
public void check_box_select()
{
	check_box_select.click();
}
public void Schedule_Interview_btn()
{
	Schedule_Interview_btn.click();
}
public void Topic_input(String input)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(Topic_input));
	wb.sendKeys(input);
}
public void ci_requests_type()
{
	//Select s= new Select(ci_requests_type);
	//s.selectByContainsVisibleText("Any");
	ci_requests_type.click();
	option2.click();
}
public void usership_criteria_input()
{
	usership_criteria_input.sendKeys("Test");
}
public void Meeting_Link()
{
	Meeting_Link.sendKeys("https://www.google.com/");
}
public void int_date(String date)
{
	int_date.sendKeys(date);
}
public void int_time_from()
{
	int_time_from.sendKeys("11:00PM");
}
public void int_time_to()
{
	int_time_to.sendKeys("11:50PM");
}
public void Reward_Amount()
{
	Reward_Amount.sendKeys("10");
}
public void Interviwer_select(String Interviewer )
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(Interviwer_select));
	wb.sendKeys(Interviewer);
	Actions act = new Actions(driver);
	act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
}
public String Save_btn()
{
	Save_btn.click();
	return Save_btn.getText();
}
public void mark_complete()
{
	WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
	WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(mark_complete));
	wb.click();
	Alert alert =wait.until(ExpectedConditions.alertIsPresent());
	alert.accept();
}
public void Request_id_tab()
{
	Request_id_tab.click();
}
public void show_interview()
{
	show_interview.click();
}

public void action_for_complete()
{
	action_for_complete.click();
}

}
