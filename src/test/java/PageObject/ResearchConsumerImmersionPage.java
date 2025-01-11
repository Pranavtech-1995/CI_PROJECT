package PageObject;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResearchConsumerImmersionPage extends BasePage {

	public ResearchConsumerImmersionPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
@FindBy (xpath="//*[@id='Customer Immersions']")
WebElement Customer_Immersionstab;
@FindBy (xpath="//*[text()='Add New Request']")
WebElement Add_New_Request ;
@FindBy (xpath="//*[@name='title']")
WebElement Project_name;
@FindBy (xpath="//input[@formcontrolname='objective']")
WebElement objective;
@FindBy (xpath="//*[@id='mat-select-value-7']")
WebElement company_name;
@FindBy (xpath="//span[text()='Crownit']")
WebElement select_crownit;
@FindBy (xpath="//input[@formcontrolname='question']")
WebElement Key_question;
@FindBy (id="mat-select-value-3")
WebElement MinLOItab;
@FindBy (xpath="//span[text()='10 min']")
WebElement MinLOI_Select;
@FindBy (xpath="//*[@id='mat-select-value-5']")
WebElement MaxLOItab;
@FindBy (xpath="//span[text()='25 min']")
WebElement MaxLOI_Select;
@FindBy (xpath="//*[contains(@id,'mat-select-value-9')]")
WebElement Gender_tab;
@FindBy(xpath="//*[contains(text(),'Any')]")
WebElement Gender_select;
@FindBy (xpath="//*[@name='Age']")
WebElement Age_input;
@FindBy (xpath="//*[@name='Centers']")
WebElement Centers_input;
@FindBy(xpath="//*[@name='Count']")
WebElement Count_input;
@FindBy (xpath="//*[@name='usership_criteria']")
WebElement usership_criteria;
@FindBy (xpath="//*[@class='copy-icon']")
WebElement copy_usership;
@FindBy(xpath="//*[@class='radio-control']//input[@name='isTranslator']")
List<WebElement> Radiobutton_forTranslators;
@FindBy(xpath="//*[@class='radio-control']//input[@name='isModerator']")
List <WebElement> Radiobutton_forModerators;
@FindBy(xpath="//*[text()='Send Request']")
WebElement Send_Request_button;
@FindBy (xpath="//*[@class='table-col']")
List<WebElement> Get_verification;







public void Customer_Immersionstab()

{
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(Customer_Immersionstab));
	wb.click();
}
public void Add_New_Request()
{ 
	try 
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(Add_New_Request));
		Actions act= new Actions(driver);
		driver.switchTo().defaultContent();
		act.moveToElement(wb).click().build().perform();
		
	} 
	catch (Exception e) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].click();", Add_New_Request);
		e.getMessage();
	}
	
	
	
}
public void Project_name(String Project_names)
{
	Project_name.clear();
	Project_name.sendKeys(Project_names);
}
public void objective(String objectives)
{
	objective.sendKeys(objectives);
}
public void company_name()
{
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(company_name));
	wb.click();
}
public void select_crownit()
{
	select_crownit.click();
}
public void Key_question(String ques)
{
	Key_question.sendKeys(ques);
}
public void MinLOItab()
{
	MinLOItab.click();
}
public void MinLOI_Select()
{
	MinLOI_Select.click();
}
public void MaxLOItab()
{
	MaxLOItab.click();
}
public void MaxLOI_Select()
{
	MaxLOI_Select.click();
}
public void Gender_tab()
{
	Actions act= new Actions (driver);
	act.scrollToElement(Gender_tab);
	act.moveToElement(Gender_tab).click().build().perform();
	
}
public void Gender_select()
{
	Gender_select.click();
}
public void Age_input(String age)
{
	Age_input.sendKeys(age);
}
public void Centers_input(String centreinputs)
{
	Centers_input.sendKeys(centreinputs);
}
public void Count_input(String Count_inputs)
{
	Count_input.sendKeys(Count_inputs);
}
public void usership_criteria(String usership_criterias)
{
	usership_criteria.sendKeys(usership_criterias);
}
public void copy_usership()
{
	copy_usership.click();
}
public void Radiobutton_forTranslator()
{
	for (WebElement opt:Radiobutton_forTranslators)
	{
		if (opt.getAttribute("id").contains("t-yes"))
		{
			opt.click();
		}
	}
}
public void  Radiobutton_forModerators()
{
	for (WebElement opt: Radiobutton_forModerators)
	{
		if (opt.getAttribute("id").contains("m-yes"))
		{
			opt.click();
		}
	}
}

public void Send_Request_button()
{
	Send_Request_button.click();
}

public String Get_verification() throws IOException
{
	String Project_name = null;
	for (WebElement opt:Get_verification)
		
	{
		Properties p= new Properties();
		FileReader file= new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.Properties");
		p.load(file);
		if (opt.getText().equals(p.getProperty("Project_name")))
		{
			  Project_name=opt.getText();break;
			  
		}
	}
	System.out.println(Project_name);
	return Project_name;
}


}
