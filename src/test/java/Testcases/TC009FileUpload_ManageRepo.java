package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.InsightLoginPage;
import PageObject.Manage_RepoPage;
import Testbase.BaseClass;

public class TC009FileUpload_ManageRepo extends BaseClass {

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
        public void survey_id_search() throws InterruptedException	
     
        {
         HomePage hp = new HomePage(driver);
	     hp.survey_tab();
	     hp.SurveyManager_tab();
	     hp.survey_idsearching(p.getProperty("survey_id"));
	     Thread.sleep(5000);
	     hp.update_survey_click();
	     hp.Survey_Name();
	     String survey_name=hp.Survey_Name();
	     System.out.println(survey_name);
	     String sname ="Survey Name - "+(p.getProperty("Survey_name"));
	     System.out.println(sname);
	      if (survey_name.contains(sname))
	      {
	    	  Assert.assertTrue(true);
	      }
	      else 
	      {
	    	 Assert.fail();
	      }
        }
     
	      @Test(priority=3)
	      public void videoupload() throws InterruptedException 
	      {
	    	 
	    	  Manage_RepoPage mr = new Manage_RepoPage(driver);
	    	  mr.Manage_Repo();
	    	  mr.Add_New_file();
	    	  mr.Select_Topic(p.getProperty("Project_name"));
	    	  mr.Report_Type();
	    	  mr.file_type();
	    	  mr.upload_external_file();
	    	  mr.efile_name_input();
	    	  mr.Save();
	    	  String ver=mr.VideoVerification();
	    	  System.out.println("text");
	    	  
	    	  if (ver.equals("Approved"))
	    	  {
	    		  Assert.assertTrue(true);
	    	  }
	    	  else
	    	  {
	    		  Assert.fail();
	    	  }
	    	  
	      }
	      
	}





