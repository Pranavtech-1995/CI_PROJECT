package PageObject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Manage_RepoPage extends BasePage {

	public Manage_RepoPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="//a[normalize-space()='Manage Repository']")
	WebElement Manage_Repo;
	@FindBy (xpath="//button[normalize-space()='Add New']")
	WebElement Add_New_file;
	@FindBy (xpath="(//select[@name='interviews_list'])[2]")
	WebElement Select_Topic;
	@FindBy (xpath="//select[@id='select_type']")
	WebElement Report_Type;
	@FindBy (xpath="//select[@id='file_type']")
	WebElement file_type;
	@FindBy (xpath="//input[@id='open_text']")
	WebElement detail_text_input;
	@FindBy (xpath="//span[@id='upload_external_file']//img")
	WebElement upload_external_file;
	@FindBy (xpath="(//*[text()='Save'])[4]")
	WebElement Save_Btn;
	@FindBy (xpath="//tr[1]//td[5]//span")
	WebElement VideoVerification;
	@FindBy (xpath="//input[@id='up_file_name']")
	WebElement Aws_File_name;
	
	
	
	



   public void Manage_Repo()
   {
	   Manage_Repo.click();
   }
   public void Add_New_file()
   {
	   Add_New_file.click();
   }
   public void Select_Topic(String select)
   {
	   Select s= new Select (Select_Topic);
	   s.selectByVisibleText(select);
	}
   public void Report_Type()
   {
	   Select s= new Select (Report_Type);
	   s.selectByVisibleText("AWS File Name");
   }
   
   public void file_type()
   {
	   Select s = new Select (file_type);
	   s.selectByVisibleText("Video");
   }
   public void efile_name_input()
   {
	   
	   detail_text_input.sendKeys("Testforautomation");
   }
   public void upload_external_file() throws InterruptedException
   {
	   
	   
	  String filePath="Mock_1_1725441634373_1731406862269.mp4";
	  Aws_File_name.sendKeys(filePath); 
   }
   public void Save()
   {
	   Save_Btn.click();
	   WebDriverWait wait =  new WebDriverWait (driver,Duration.ofSeconds(10));
	   Alert wb=wait.until(ExpectedConditions.alertIsPresent());
	   wb.accept();
	   
   }
   public String VideoVerification()
   {
	   WebDriverWait wait =  new WebDriverWait (driver,Duration.ofSeconds(10));
	   WebElement wb=wait.until(ExpectedConditions.elementToBeClickable(VideoVerification));
	    return wb.getText();
	   
   }

}
