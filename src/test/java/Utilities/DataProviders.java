package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

@DataProvider(name="logindata")
public Object[][] dataprovider() throws IOException
{
	String filepath= System.getProperty("user.dir")+"\\TestData\\Prakash.xlsx";
	
	      ExcelUtility ex= new ExcelUtility(filepath);
	     
			int noofrows=ex.getrowcount("Sheet1");
			int noofcolumn=ex.getcellcount("Sheet1",1);
			Object logindata[][]= new Object [noofrows][noofcolumn+1];
			
			for (int r=1;r<=noofrows;r++)
			{
				for(int c=0;c<noofcolumn;c++)
				{
					logindata[r-1][c]=ex.getcelldata("Sheet1", r, c);
					
				}
				
				logindata[r-1][noofcolumn]= r ;
			}
			
			return logindata;
			
		
	
	
}








}
