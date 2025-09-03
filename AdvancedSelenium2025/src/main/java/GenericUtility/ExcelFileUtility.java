package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String readingDataFromExcel(String sheet, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\TestScriptDetails.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue(); //method chaining
		return data;		
	}
	
	public int getRowcount(String sheetName) throws Throwable
	{
		FileInputStream fis= new FileInputStream("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\TestScriptDetails.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum,int celNum,String data) throws Throwable
	{
		FileInputStream fis= new FileInputStream("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\TestScriptDetails.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos= new FileOutputStream("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\TestScriptDetails.xlsx");
		wb.write(fos);
		wb.close();
	}
}
