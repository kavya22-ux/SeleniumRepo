package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb = new XSSFWorkbook("./data/CreateLead.xlsx");
		XSSFSheet Sheet = wb.getSheetAt(0);
		
		int rowValue = Sheet.getLastRowNum();
		System.out.println("Row Count: "+rowValue);
		
		
		int cellValue = Sheet.getRow(1).getLastCellNum();
		System.out.println("Cell Value: "+cellValue);
		String name = Sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(name);
		for(int i = 1; i <=rowValue; i++) {
			for(int j = 0; j < cellValue; j++) {
				String value = Sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(value);
			}
			wb.close();
		}

	}

}
