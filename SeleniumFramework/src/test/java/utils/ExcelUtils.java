package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static  XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils (String excelPath, String sheetName) {

		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void main(String[] args) {

		getrowcount();

		getcolumncount();
		getcelldata(1,1);

	}

	public static int getrowcount() {

		int rowcount=0;
		rowcount = sheet.getPhysicalNumberOfRows();

		System.out.println("number of rows  " + rowcount);
		return rowcount;
	}

	public static int getcolumncount() {
		int colcount = 0;

		colcount = sheet.getRow(0).getPhysicalNumberOfCells();

		System.out.println("number of columns  " + colcount);
		return colcount;
	}
	public static String getcelldata(int rowNum, int colNum) {
		String celldata = null;
		celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

		

		return celldata;
		
	}


}
