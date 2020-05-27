package com.gurubanking.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gurubanking.pageObjects.LoginPage;

import utils.ExcelUtils;

public class TC_LoginTest_001 extends BaseClass
{

	@Test(dataProvider = "test data")
	public  void loginTest(String username, String password)
	{
		
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassWord(password);
		lp.clickSubmit();
		
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			System.out.println("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			System.out.println("Login Pass");
		}
		
		
		
	}
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e)
		{
		return false;	
		}
			
	}
	
	@DataProvider(name = "test data")
	public Object[][] getdata() {


		String excelPath = "D:\\Selenium\\SeleniumFramework\\excel\\testdata.xlsx";
		Object data[][] = testData(excelPath,"sheet1");

		return data;

	}



	public  Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getrowcount();
		int colCount = excel.getcolumncount();

		Object data [][] = new Object[rowCount-1][colCount];	
		for(int i=1; i<rowCount; i++) {
			for (int j=0; j<colCount;j++) {

				String cellData = excel.getcelldata(i, j);

				//System.out.print(cellData +"   ");

				data[i-1][j] = cellData;

			}
			//System.out.println();
		}
		return data;




	}
	
	
}
