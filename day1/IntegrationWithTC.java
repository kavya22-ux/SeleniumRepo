package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IntegrationWithTC {
	public static String[][] readExcel() throws IOException{
		XSSFWorkbook wb = new XSSFWorkbook("./data/CreateLead.xlsx");
		XSSFSheet sheetAt = wb.getSheetAt(0);
		
		int rowValue = sheetAt.getLastRowNum();
		int cellValue = sheetAt.getRow(1).getLastCellNum();
		String[][] data = new String[rowValue][cellValue];
		for(int i = 1; i <= rowValue; i++) {
			for(int j = 0; j < cellValue; j++) {
				String value = sheetAt.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = value;
			}
		}
		wb.close();
		return data;
		
	}

}
