package DDTPractise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTByExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\TestScriptDetails.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String Campaign = wb.getSheet("CampSheet").getRow(1).getCell(2).getStringCellValue();
		String targetSize = wb.getSheet("CampSheet").getRow(1).getCell(3).getStringCellValue();
		System.out.println(Campaign);
		System.out.println(targetSize);

	}

}
