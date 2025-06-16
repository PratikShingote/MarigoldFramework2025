package propertiesUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static String baseDir = System.getProperty("user.dir");
	public static String testDataexcelPath = "\\src\\main\\resources\\propertiesFile\\Google Meet Scenarios.xlsx";
	public static String excelFile =baseDir+testDataexcelPath;



	public static void readExcelData() throws IOException {
		File file = new File (excelFile);
		FileInputStream fis = new FileInputStream(file);
	// create the object of workBook and pass that workbook which need to read
		XSSFWorkbook wb = new XSSFWorkbook(fis);
	   XSSFSheet sheet = wb.getSheet("ExcelTestDataOrangeHRM");
	   XSSFRow row = sheet.getRow(1);
	   XSSFCell cell = row.getCell(1);
	  String data= cell.getStringCellValue();
	  System.out.println(data);
	}
	
	public static void readFullXcelFile() throws IOException {
		File file = new File (excelFile);
		FileInputStream fis = new FileInputStream(file);
	// create the object of workBook and pass that workbook which need to read
		XSSFWorkbook wb = new XSSFWorkbook(fis);
	   XSSFSheet sheet = wb.getSheet("ExcelTestDataOrangeHRM");
	   for(int i= 1 ; i<=sheet.getLastRowNum(); i++) {
		   XSSFRow row = sheet.getRow(i);
		   XSSFCell cell = row.getCell(1);
		  String userNames =cell.getStringCellValue();
		   System.out.println(userNames);
	   }
	}
	

}
