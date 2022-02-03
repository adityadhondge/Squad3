package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

	public static String getDataFromDataSheet(int row,int col) throws Exception, Throwable {
		String value;
		
		row=1;
		col=1;
		String path="C:\\Users\\HP\\Desktop\\Testing.xlsx";

		FileInputStream file= new FileInputStream(path);
		

		
		try {
			 value= WorkbookFactory.create(file).getSheet("Sheet5").getRow(row).getCell(col).getStringCellValue();
			System.out.println(value);
		}
		
		catch(IllegalStateException a) {
			double num= WorkbookFactory.create(file).getSheet("Sheet5").getRow(row).getCell(col).getNumericCellValue();
			
					value=Double.toString(num);
					System.out.println(value);
		}
		
	
		return value;
	}
public static void main(String[] args) throws Exception, Throwable {
	Utility a= new Utility();
	a.getDataFromDataSheet(1, 1);
}
	

}
