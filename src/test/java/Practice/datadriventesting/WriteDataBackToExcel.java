package Practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\sumit\\OneDrive\\Desktop\\Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		Cell cell = row.createCell(6);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("Pass");
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\sumit\\OneDrive\\Desktop\\Data.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("=====executed=======");

	}

}
