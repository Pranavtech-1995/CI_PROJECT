package Testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.InsightLoginPage;
import Testbase.BaseClass;
import Utilities.DataProviders;
import Utilities.ExcelUtility;

public class TC010Exce_Data_Base_LoginTestCases_Sanity extends BaseClass{


@Test (dataProvider="logindata",dataProviderClass=DataProviders.class,groups={"sanity"})
public void login (String usernam ,String Passwor ,String ex,int r) throws IOException 
{
	
         InsightLoginPage ip =  new InsightLoginPage(driver);
         String filepath= System.getProperty("user.dir")+"\\TestData\\Prakash.xlsx";
         ExcelUtility ex1= new ExcelUtility(filepath);
         driver.get(p.getProperty("appurl"));
         ip.btn_login();
         logger.info("**********start*********");
         ip.login_input(usernam);
         ip.get_otp();
         ip.otp_field(Passwor);
         ip.login_btn();
         logger.info("**************end****************");
         HomePage hp = new HomePage(driver);
         boolean status=hp.HomepageTitle();
         
         if (ex.equals("Passed"))
         {
              if (status==true)
             {
        	  
        	 ip.Logout_drpdwn();
        	 ip.logout_btn();
        	 ex1.setcelldata("Sheet1", r, 3, "Passed");
        	 ex1.fillGreencolour( "Sheet1",r, 3);
        	 Assert.assertTrue(true);
         
             }
              else 
              {
             	 
             	 ex1.setcelldata("Sheet1", r, 3, "Failed");
             	 ex1.fillRedColour("Shet1", r, 3);
             	 Assert.fail();
              }
              
              
         }
         if (ex.equals("Failed"))
         {
              if (status==true)
             {
        	  
        	 ip.Logout_drpdwn();
        	 ip.logout_btn();
        	 ex1.setcelldata("Sheet1", r, 3, "Passed");
        	 ex1.fillGreencolour( "Sheet1",r, 3);
        	 Assert.fail();
         
             }
              else 
              {
             	 
             	 ex1.setcelldata("Sheet1", r, 3, "Failed");
             	 ex1.fillRedColour("Sheet1", r, 3);
             	 Assert.assertTrue(true);
              }
              
              
         }
         
}
        
         
}


//MethodMatcherException
//IndexOutOfBoundsException 




