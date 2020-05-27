package utils;

public class ExcelDemo {
	
	
	
	public static void main(String[] args) {
		
		
		String excelPath = "D:\\Selenium\\SeleniumFramework\\excel\\testdata.xlsx";
		
		ExcelUtils excel = new ExcelUtils(excelPath, "sheet1");
		//ExcelUtils excel = new ExcelUtils("D:\\Selenium\\SeleniumFramework\\excel\\testdata.xlsx", "sheet1");
		excel.getrowcount();
		excel.getcolumncount();
		excel.getcelldata(1, 1);
		
	}

}
