package DDTPractise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException{
		FileInputStream fis= new FileInputStream("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\TestScriptDetails.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.createSheet("WriteData1").createRow(2).createCell(3).setCellValue("Selenium");
	
		FileOutputStream fos= new FileOutputStream("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\TestScriptDetails.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Data written sucessfully");
	}

}
