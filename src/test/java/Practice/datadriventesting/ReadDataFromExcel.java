package Practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//Step-1 get the Excel path location & java object of the physical ExcelFile
		FileInputStream fis=new FileInputStream("C:\\Users\\sumit\\OneDrive\\Desktop\\Data.xlsx");
		//Step-2 open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		//Step-3 get the control of sheet
		Sheet sheet = wb.getSheet("sheet1");
		//step-4 get the control or row
		Row row = sheet.getRow(3);
		//step-5 get the control of cell and read the value
		Cell cell = row.getCell(3);
		String data = cell.getStringCellValue();
		System.out.println(data);
		//step-6 close the workbook
		wb.close();
		
//		 RichTextString data = WorkbookFactory.create(fis).getSheet("sheet1").getRow(3).getCell(3).getRichStringCellValue();
//         System.out.println(data);
       

	}

}
