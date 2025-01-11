package Testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {


public WebDriver driver;
public Logger  logger;
public Properties p;
@Parameters({"browser","os"})
@BeforeClass (groups="sanity")
public void setup (String br, String os) throws IOException
{
	  logger =LogManager.getLogger(this.getClass());
	  logger.info("***********");
	  FileReader file= new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.Properties");
	  p= new Properties ();
	  p.load(file);
	
	
	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	{
	         
		DesiredCapabilities dc = new DesiredCapabilities();
	          
	          if (os.equalsIgnoreCase("window"))
	          {
	        	  dc.setPlatform(Platform.WIN10);
	          }
	          else if (os.equalsIgnoreCase("mac"))
	          {
	        	  dc.setPlatform(Platform.MAC);
	          }
	          else if (os.equalsIgnoreCase("linux"))
	          {
	        	  dc.setPlatform(Platform.LINUX);
	          }
	          else
	          {
	        	  System.out.println("Invalid OS");
	        	  return;
	          }
	          
	          switch (br.toLowerCase())
	          {
	          
	            case  "chrome" :dc.setBrowserName("chrome");break;
	            case  "edge"   :dc.setBrowserName("MicrosoftEdge");break;
	            case  "firefox":dc.setBrowserName("firefox");break;
	                   default :System.out.println("inavlid browser");return;
	            
	          }
	          
	          driver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);
	
	      }
	
	
	if (p.getProperty("execution_env").equalsIgnoreCase("local")) 
	{
	switch (br.toLowerCase())
	{
	case "chrome" : driver=new ChromeDriver();break;
	case "edge"   : driver =new EdgeDriver();break;
	     default  : System.out.println("invalid browser");return;
	}
	
	}
	
	
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	 
}
 
@AfterClass (groups="sanity")
public void teardown ()
{
	driver.quit();
}


public  String capturescreenshot(WebDriver driver, String tname)
{
	
	   String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
     TakesScreenshot ts= (TakesScreenshot) driver;
     File source=ts.getScreenshotAs(OutputType.FILE);
     
     String targetfilepath =System.getProperty("user.dir")+"\\Screenshot\\"+tname+"_"+timestamp+".png";
     File TargetFile = new File (targetfilepath);
     source.renameTo(TargetFile);
     
     return targetfilepath;
     
     
     

}

public String randomString()
{
	String rs =  RandomStringUtils.randomAlphabetic(5);
	return rs;
}
public String random_numeric()
{
	String num=RandomStringUtils.randomNumeric(2);
	return num;
}
public String randomAlphanumeric()
{
	String Alphanumeric=RandomStringUtils.randomAlphanumeric(6);
	return Alphanumeric;
}



}
