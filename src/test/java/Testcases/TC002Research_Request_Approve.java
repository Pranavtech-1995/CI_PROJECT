package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ResearchConsumerImmersionPage;
import PageObject.ResearchLoginPage;
import PageObject.ResearchRequestListApprovalPage;
import Testbase.BaseClass;

public class TC002Research_Request_Approve extends BaseClass
{

	
	
	@Test
	 public void Research_Login_reg() throws InterruptedException
	 
	 {
		ResearchLoginPage rlp= new ResearchLoginPage(driver);
		rlp.get_url();
		rlp.username_input(p.getProperty("username"));
		rlp.Loginwithpassword();
		rlp.password_input(p.getProperty("Password"));
		rlp.login_button();
		
		
		ResearchConsumerImmersionPage Rcip= new ResearchConsumerImmersionPage(driver);
		Rcip.Customer_Immersionstab();
		
		ResearchRequestListApprovalPage Rap= new ResearchRequestListApprovalPage(driver);
		Rap.Details_btn();
		
		Rap.checkbox_tandc();
		boolean Status=Rap.Approve_btn();
		Rap.Skip_for_now();
		
		if (Status==true)
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}
		
		
	 
	 
	 
	 }
}
