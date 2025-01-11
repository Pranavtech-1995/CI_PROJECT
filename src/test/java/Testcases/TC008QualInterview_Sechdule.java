package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ContainerCreation_LinkCreation;
import PageObject.HomePage;
import PageObject.InsightLoginPage;
import PageObject.QualSetUpPage;
import Testbase.BaseClass;

public class TC008QualInterview_Sechdule extends BaseClass{

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
        public void request_tab() throws InterruptedException
    	{
        	
    		QualSetUpPage qsp = new QualSetUpPage(driver);
    		qsp.Open_QualSetUpPage();
    		qsp.check_box_select();
    		qsp.Schedule_Interview_btn();
    		qsp.Topic_input(p.getProperty("Project_name"));
    		qsp.ci_requests_type();
    		qsp.usership_criteria_input();
    		qsp.Meeting_Link();
    		qsp.int_date(p.getProperty("date"));
    		qsp.int_time_from();
    		qsp.int_time_to();
    		qsp.Reward_Amount();
    		qsp.Interviwer_select(p.getProperty("username"));
    		String s=qsp.Save_btn();
    		driver.navigate().refresh();
    		Thread.sleep(3000);
    		qsp.show_interview();
    		qsp.action_for_complete();
    		qsp.mark_complete();
    		
    		
    		System.out.println(s);
    		if (s.equals("Save"))
    		{
    	      Assert.assertTrue(true);
    		}
    		else
    		{
    		  Assert.fail();;
    		}
    		
    	}
        
       







}
