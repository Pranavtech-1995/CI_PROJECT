package PageObject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContainerCreation_LinkCreation extends BasePage {

	public Select s;
	public ContainerCreation_LinkCreation(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	@FindBy(xpath="//*[text()='Update  Survey']")
	WebElement 	update_survey;
	@FindBy (xpath="//*[@id='SsSurveys_status']")
	WebElement Survey_statusdrpdwn;
	@FindBy (xpath="//*[text()='Save']")
	WebElement save_Btn;
	@FindBy(xpath="//*[@id='paytm_check']")
	WebElement paytm_check;
	@FindBy(xpath="//*[@id='misc_update']")
	WebElement Update_Details_btn;
	@FindBy (xpath="//a[@class='fa fa-pencil pull-right']")
	WebElement container_opening;
	@FindBy (xpath="//*[text()='Containers']")
	WebElement containers_breadcrum;
	@FindBy (xpath="//*[text()='Select All']")
	WebElement Select_All;
	@FindBy (xpath="//*[@name='express[11]']")
	WebElement test_container_on;
	@FindBy(xpath="//*[@value='Create Express Containers']")
	WebElement Create_Express_Containers ;
	@FindBy (xpath="//*[@name='property[2]']")
	WebElement Phone_no_check;
	@FindBy (xpath="//button[@id='add_properties_button']")
	WebElement saves_btn; 
	@FindBy(xpath="//*[@name='utm_source']")
	WebElement utm_source;
	@FindBy(xpath="//*[text()='Break The Glass']")
	WebElement Break_The_Glass;
	@FindBy(xpath="//*[@name='btg_reason']")
	WebElement Reason_drpdown;
	@FindBy(xpath="//*[text()='Generate Link']")
	WebElement Generate_Link ;
	@FindBy(xpath="//*[text()='Proceed']")
	WebElement Proceed ;
	@FindBy(xpath="//span[@id='copy_p']")
	WebElement copy ;
    @FindBy (xpath="//*[@id='survey_type']")
    WebElement survey_type;
    @FindBy(xpath="//*[@id='dynamic_update']")
    WebElement survey_type_update;
    @FindBy (xpath="//*[@name='property[15]']")
    WebElement allow_Survey_On;
	
	
	
	public void  update_survey()
	{
		update_survey.click();
	}
	public void Survey_statusdrpdwn() 
	{
		s= new Select (Survey_statusdrpdwn);
		s.selectByVisibleText("Active/Launched");
	}
	public void save_Btn() throws InterruptedException
	{
		
		save_Btn.click();
		

		WebDriverWait wb= new WebDriverWait(driver,Duration.ofSeconds(10));
		wb.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
	}
	public void paytm_check()
	{
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", paytm_check);
		WebDriverWait wb= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement wait=wb.until((ExpectedConditions.visibilityOf(paytm_check)));
		s=new Select (wait);
	    s.selectByVisibleText("False");
	    
	}
	public void Update_Details_btn()
	{
		Update_Details_btn.click();
	}
	
	public void containers_breadcrum()
	{
		WebDriverWait wb= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement wait=wb.until((ExpectedConditions.visibilityOf(containers_breadcrum)));
		wait.click();
	}
	public void Select_All()
	{
		Select_All.click();
	}
	public void test_container_on()
	{
		test_container_on.click();
	}
	public void container_opening()
	{
		container_opening.click();
	}
	public void Phone_no_check()
	{
		s=new Select (Phone_no_check);
		s.selectByValue("Beginning-auto-login");
	}
	public void saves_btn()
	{
		saves_btn.click();
		WebDriverWait wb= new WebDriverWait(driver,Duration.ofSeconds(10));
		wb.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	public void  utm_source() 
	{
	 s= new Select (utm_source);
	 s.selectByVisibleText("test");
	}
	public void Break_The_Glass()
	{
		Break_The_Glass.click();
	}
	public void Reason_drpdown()
	{
		
		s= new Select (Reason_drpdown);
	    s.selectByVisibleText("External Source");
	}
	public void Generate_Link()
	{
		WebDriverWait wb= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement wait= wb.until(ExpectedConditions.elementToBeClickable(Generate_Link));
		wait.click();
		
	}
	public void Proceed()
	{
		WebDriverWait wb= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement wait= wb.until(ExpectedConditions.elementToBeClickable(Proceed));
		wait.click();
	}
	public void Create_Express_Containers()
	{
		Create_Express_Containers.click();
	}
	public String copylink ()
	{
		return (copy.getText());
	}
	public void survey_type()
	{
		s = new Select(survey_type);
		s.selectByVisibleText("QA");
	}
	public void survey_type_update()
	{
		survey_type_update.click();
		WebDriverWait wb = new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert wait =wb.until(ExpectedConditions.alertIsPresent());
		wait.accept();
	}
	public void allow_Survey_On()
	{
		WebDriverWait wb= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement wait= wb.until(ExpectedConditions.elementToBeClickable(allow_Survey_On));
	     s = new Select(wait);
	     s.selectByValue("0");
	     
	}
	
	

	
	
	
	
	
	
	
	
	

}
