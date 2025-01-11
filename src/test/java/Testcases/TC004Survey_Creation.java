package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BuilderSurveyCreation;
import PageObject.ReportLoginPage;
import Testbase.BaseClass;

public class TC004Survey_Creation extends BaseClass {



	@Test(priority=1,groups={"sanity"})
	public void Builder_login()
	{
		ReportLoginPage rl= new ReportLoginPage(driver);
		rl.Change_Url();
		rl.email_input(p.getProperty("username"));
		rl.password_input(p.getProperty("Password"));
		rl.Login_btn();
		String ver_text=rl.Login_verification();
		if (ver_text.contains("Welcome"))
		{
			Assert.assertTrue(true);
			logger.info(ver_text);
		}
		else 
		{
			Assert.fail();
			logger.info("*****fail*********");
		}
	}
		@Test(priority=2,dependsOnMethods= {"Builder_login"})
		public void BuilderSurveyCreations() throws InterruptedException 
		{
	
		BuilderSurveyCreation Bsc = new BuilderSurveyCreation(driver);
		Bsc.AddSurvey_button();
		Bsc.AddSurvey_Placeholder(p.getProperty("Survey_name"));
		Bsc.Build_Survey_btn();
		Thread.sleep(3000);
		Bsc.Survey_edit_btn();
		Thread.sleep(3000);
		Bsc.Add_ques();
		Bsc.ques_text_field(p.getProperty("ques_text"));
		Bsc.option_text_atindex_o(p.getProperty("Opt0"));
		Bsc.Addmore_option();
		Bsc.option_text_atindex_1(p.getProperty("OPT1"));
		Bsc.save_Btn();
		String Survey_Created_Name=Bsc.Builder_Verification();
		System.out.println(Survey_Created_Name);
		
		if (Survey_Created_Name.contains(p.getProperty("Survey_name")))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
		
		}
	
	
	}




