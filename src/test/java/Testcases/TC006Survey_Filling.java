package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Survey_Filling;
import Testbase.BaseClass;

public class TC006Survey_Filling extends BaseClass{
	
	@Test
	public void survey_filling() throws InterruptedException
	{
		
		
		driver.get(p.getProperty("survey_link"));
		Survey_Filling sf= new Survey_Filling(driver);
		sf.phone_number_input(p.getProperty("phone_no"));
		sf.Verify_to_get_entry();
		System.out.println(p.getProperty("choice_for_survey"));
		
		for (int i=0;i<=1;i++) 
		{
		Thread.sleep(2000);
		sf.ques_choice(p.getProperty("choice_for_survey"));
		sf.next_btn();
		}
		boolean ver=sf.Survey_filled_Verification();
		System.out.println(ver);
		
	    if (ver==true)
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.fail();
	    }
		
		
		 
		
	
	}

}
