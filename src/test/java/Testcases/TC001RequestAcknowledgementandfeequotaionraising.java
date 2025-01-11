package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CIRequestPage;
import PageObject.HomePage;
import PageObject.InsightLoginPage;
import Testbase.BaseClass;

public class TC001RequestAcknowledgementandfeequotaionraising extends BaseClass {

	@Test (priority=1)
	public void login () 
	{
		
	         InsightLoginPage ip =  new InsightLoginPage(driver);
	         driver.get(p.getProperty("appurl"));
	         ip.btn_login();
	         logger.info("**********start*********");
	         ip.login_input(p.getProperty("username"));
	         ip.get_otp();
	         ip.otp_field(p.getProperty("otp"));
	         ip.login_btn();
	         logger.info("**************end****************");
	         HomePage hp = new HomePage(driver);
	         boolean status=hp.HomepageTitle();
	         
	         if (status==true)
	         {
	        	 Assert.assertTrue(true);
	         }
	         else 
	         {
	        	 Assert.fail();
	         }

	
	 
	         
	         
	}
	
	@Test(priority=2)
	public void request_tab() throws InterruptedException
	{
		HomePage hp=  new HomePage(driver);
		hp.Ci_Request();
		hp.side_bar_option(p.getProperty("Sidebar_options"));
		logger.info("**********8*********");
		
		CIRequestPage cip= new CIRequestPage(driver);
		String id=cip.Request_opening(p.getProperty("Project_name"));
		cip.Accept_request();
		cip.feequote_text(randomString());
		cip.sendApproval();
		
		if (id!=null)
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			Assert.fail();
		}
		
		
	}






}
