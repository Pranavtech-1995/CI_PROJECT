package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ContainerCreation_LinkCreation;
import PageObject.HomePage;
import PageObject.InsightLoginPage;
import PageObject.Survey_Filling;
import Testbase.BaseClass;

public class TC005Survey_idSearch_LinkCreation_Data_Creation extends BaseClass {

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
      
	@Test (priority=2, dependsOnMethods= {"login"})
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
	
	@Test (priority=3,dependsOnMethods= {"survey_id_search"})
	public void Container_Creation() throws InterruptedException
	{
		
		ContainerCreation_LinkCreation cls= new ContainerCreation_LinkCreation(driver);
		cls.update_survey();
		cls.survey_type();
		cls.survey_type_update();
		logger.info("******start******");
		cls.Survey_statusdrpdwn();
		logger.info("******00******");
		logger.info("******01******");
		cls.save_Btn();
		logger.info("******02******");
		cls.paytm_check();
		logger.info("******03******");
		cls.Update_Details_btn();
		logger.info("******04******");
		Thread.sleep(3000);
		cls.containers_breadcrum();
		logger.info("******05******");
		//cls.Select_All();
		logger.info("******06******");
		//cls.test_container_on();
		logger.info("******07******");
		//cls.Create_Express_Containers();
		cls.container_opening();
		logger.info("******08******");
		cls.Phone_no_check();
		logger.info("******09******");
        cls.allow_Survey_On();
		cls.saves_btn();
		logger.info("******10******");
		cls.utm_source();
		logger.info("******11******");
		cls.Break_The_Glass();
		logger.info("******12******");
		cls.Reason_drpdown();
		logger.info("******13******");
		cls.Generate_Link();
		logger.info("******14******");
		cls.Proceed();
		String link=cls.copylink();
		System.out.println(link);
		
		logger.info("******15******");
		if (link!= null)
		{
			
			driver.get(link);
			Survey_Filling sf= new Survey_Filling(driver);
			sf.phone_number_input(p.getProperty("phone_no"));
			sf.Verify_to_get_entry();
			System.out.println(p.getProperty("choice_for_survey"));
			sf.ques_choice(p.getProperty("choice_for_survey"));
			sf.next_btn();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}
	




}
