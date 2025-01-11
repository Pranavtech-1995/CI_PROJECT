package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ResearchConsumerImmersionPage;
import PageObject.ResearchLoginPage;
import Testbase.BaseClass;

public class TC000ResearchRaisingRequest extends BaseClass {




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
	Thread.sleep(3000);
	Rcip.Add_New_Request();
	Rcip.Project_name(p.getProperty("Project_name"));
	Rcip.objective(randomString());
	Rcip.company_name();
	Rcip.select_crownit();
	Rcip.Key_question(randomAlphanumeric());
	Rcip.MinLOItab();
	Rcip.MinLOI_Select();
	Rcip.MaxLOItab();
	Rcip.MaxLOI_Select();
	Rcip.Gender_tab();
	Rcip.Gender_select();
	Rcip.Age_input(random_numeric());
	Rcip.Centers_input(random_numeric());
	Rcip.Count_input(p.getProperty("Interview_count"));
	Rcip.usership_criteria(randomAlphanumeric());
	Rcip.copy_usership();
	Rcip.Radiobutton_forTranslator();
	Rcip.Radiobutton_forModerators();
	Rcip.Send_Request_button();
	Thread.sleep(3000);
	try {
		String Project_names=Rcip.Get_verification();
		System.out.println(Project_names);
		
		if (Project_names.equals(p.getProperty("Project_name")))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}
	
	
	} 
	catch (IOException e) 
	{
		
		e.printStackTrace();
	}
	

	
	 
 }




}
