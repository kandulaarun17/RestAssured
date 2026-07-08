package data_driven_testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;

public class Employee {

	@DataProvider(name = "emp")
	public Object[][] provideData() throws IOException {
		File f = new File("D:\\ARUN\\A\\SDET_QA\\API Testing\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rows - 1][cols];
		DataFormatter formatter = new DataFormatter();
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));

			}
		}
		return data;

	}

}
