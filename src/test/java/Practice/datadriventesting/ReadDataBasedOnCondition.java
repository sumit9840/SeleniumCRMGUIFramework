package Practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		String expectedName="Nitesh";
		String data0="";
		String data1="";
		String data2="";
		String data3="";
		String data4="";
		String data5="";
		Boolean flag=false;
		FileInputStream fis=new FileInputStream("C:\\Users\\sumit\\OneDrive\\Desktop\\Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		for(int i=0;i<=row;i++) {
			String data="";
			try {
			     data = sheet.getRow(i).getCell(0).toString();
			     if(data.equals(expectedName)) {
			    	 flag=true;
			    	 data0=sheet.getRow(i).getCell(0).toString();
			    	 data1=sheet.getRow(i).getCell(1).toString();
			    	 data2=sheet.getRow(i).getCell(2).toString();
			    	 data3=sheet.getRow(i).getCell(3).toString();
			    	 data4=sheet.getRow(i).getCell(4).toString();
			    	 data5=sheet.getRow(i).getCell(5).toString();
			     }
			}catch (Exception e) {
				
			}
			
		}
		if(flag==true) {
			System.out.println("Name is "+data0+" Age "+data1+" salary "+data2+" prof. "+data3+""
					+ "Mob No. "+data4+" Loc. "+data5);
			/*
			 * System.out.println(data1); System.out.println(data2);
			 * System.out.println(data3); System.out.println(data4);
			 * System.out.println(data5);
			 */
		}else {
			System.out.println(expectedName+" data is not available");
		}
		wb.close();

	}

}
