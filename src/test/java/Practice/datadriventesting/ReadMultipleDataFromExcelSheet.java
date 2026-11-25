package Practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\sumit\\\\OneDrive\\\\Desktop\\\\Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		int row = sheet.getLastRowNum();
		
		for(int i=0;i<=row;i++) {
			String data1 = sheet.getRow(i).getCell(0).toString();
			String data2 = sheet.getRow(i).getCell(1).toString();
			System.out.println(data1+"\t"+data2);
			
		}
		wb.close();

	}

}
