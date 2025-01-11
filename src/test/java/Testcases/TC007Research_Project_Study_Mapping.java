package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ResearchLoginPage;
import PageObject.Research_Project_Study_Mapping_Page;
import Testbase.BaseClass;

public class TC007Research_Project_Study_Mapping extends BaseClass 
{

	@Test(priority=1,groups= {"sanity"})
	 public void Research_Login_reg() throws InterruptedException
	 
	 {
		ResearchLoginPage rlp= new ResearchLoginPage(driver);
		rlp.get_url();
		rlp.username_input(p.getProperty("username"));
		rlp.Loginwithpassword();
		rlp.password_input(p.getProperty("Password"));
		rlp.login_button();
		
	 }
	@Test (priority=2)
	public void survey_project_mapping() throws InterruptedException
	{
		Research_Project_Study_Mapping_Page rmp= new Research_Project_Study_Mapping_Page(driver);
	
	     rmp.Project_btn();
	     rmp.global_search_box_input(p.getProperty("Project_name_research"));
	     rmp.Suggestion_drpdown(p.getProperty("Project_name_research"));
	     rmp.edit_btn();
	     rmp.edit_click();
	     logger.info("********0********************");
	     Thread.sleep(3000);
	     rmp.link_survey();
	     logger.info("********1********************");
	     rmp.Search_Survey(p.getProperty("Survey_name"));
	     logger.info("********2********************");
	     rmp.option_selection_from_list(p.getProperty("Survey_name"));
	     logger.info("********3********************");
	     rmp.Update_btn();
	     boolean status=rmp.verification();
	      
	      if (status=true)
	      {
	    	  Assert.assertTrue(status);
	      }
	      else 
	      {
	    	  Assert.fail();
	      }
	     
	
	
	
	}






}
