package RaghavMethod.DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChatBot_Raghav {

	
	@Test(dataProvider = "test1data")
	public void test1(String Request, String Response) {
		
		System.out.println(Request);
		System.out.println(Response);
		
	}

			
	@DataProvider(name = "test1data")
	public Object[][] getData() throws Exception{
		
		String excelPath = "C:\\Users\\pankaj.singh\\eclipse-workspace\\chatBot_API Automation\\src\\test\\java\\RaghavPalMethod\\api.xlsx";
		Object data[][] =  testData(excelPath, "Sheet1");
		return data;
		
	}
		
		public static Object[][] testData(String excelPath, String SheetName) throws Exception 
		{

			ExcelUtilsRaghav excel = new ExcelUtilsRaghav(excelPath, SheetName);
			int rowCount = excel.getRowCount();
			int colCount = excel.getColCount();
			
			Object data[][] = new Object[rowCount-1][colCount];
			
			for (int i=1; i<=rowCount; i++)
			{
				for (int j=0;j<colCount;j++)   // Column count, we require only one column for Request.
				{
					String cellData = excel.getCellDataString(i, j);
					System.out.println(cellData);
					data[i-1][j] = cellData;
				}
				
			}
			return data;
			
		}



}
