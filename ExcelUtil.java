package common_utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public String getDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream=new FileInputStream("src\\test\\resources\\Data.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fileInputStream);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row rownum = sheet.getRow(row);
		
		Cell coloumn = rownum.getCell(cell);
		
		String value = coloumn.getStringCellValue();
		
		return value;
	}
}
