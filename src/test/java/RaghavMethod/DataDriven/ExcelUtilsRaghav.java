package RaghavMethod.DataDriven;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsRaghav {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtilsRaghav(String excelPath, String SheetName) throws Exception {

		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet("Sheet1");
	}

	public static int getRowCount() {

		int rowCount = 0;
		rowCount = sheet.getLastRowNum();
		// System.out.println("No. of Rows :" +rowCount);

		return rowCount;
	}

	public static int getColCount() {

		int colCount = 0;

		colCount = sheet.getRow(0).getLastCellNum();
		// System.out.println("No. of Rows :" +colCount);

		return colCount;
	}

	public static String getCellDataString(int rowNum, int colNum) {

		String cellData = null;
		cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		// System.out.println(cellData);

		// DataFormatter formatter = new DataFormatter();
		// Object value =
		// formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		// System.out.println(value);

		return cellData;

	}

	// public static void getCellDataNumber(int rowNum, int colNum)
	// {
	//
	// double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
	// System.out.println(cellData);
	//
	// }

}
