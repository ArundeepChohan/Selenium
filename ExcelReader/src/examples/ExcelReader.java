package examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	String path = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	public ExcelReader() throws IOException {
		path = System.getProperty("user.dir")+"\\testdata\\testdata.xlsx";
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
	}
	public int getSheetRow(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		return(sheet.getLastRowNum()+1);
	}
	public int getSheetCol(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		return (row.getLastCellNum());	
	}
	public String getCellData(String sheetName,int colNum, int rowNum)
	{
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		return (cell.getStringCellValue());	
	}
	public String getCellData(String sheetName,String colName, int rowNum)
	{
		int colNum = -1;
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		for(int i=0;i<getSheetCol(sheetName);i++)
		{
			row = sheet.getRow(0);
			cell = row.getCell(i);	
			if(cell.getStringCellValue().equals(colName))
			{
				colNum = cell.getColumnIndex();
				break;
			}
		}
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		return (cell.getStringCellValue());	
	}
	public void setCellData(String sheetName,int colNum, int rowNum, String str)
	{
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		cell.setCellValue(str);
		try {
			fileOut = new FileOutputStream(path);
			try {
				workbook.write(fileOut);
				fileOut.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]) throws IOException
	{
		ExcelReader reader = new ExcelReader();
		System.out.println("LoginTest sheet");
		System.out.println("Number of rows: "+reader.getSheetRow("LoginTest"));
		System.out.println("Number of cols: "+reader.getSheetCol("LoginTest"));
		System.out.println("Data in: "+"[1,0]: "+reader.getCellData("LoginTest",1,0));
		System.out.println("Row Cell that is under: "+"email col: "+reader.getCellData("LoginTest","email",0));
		reader.setCellData("LoginTest",1,0,"Tarndeep");
		System.out.println("Changing Row Cell that is under: "+"email col: "+reader.getCellData("LoginTest",1,0));
		System.out.println("SignUpTest sheet");
		System.out.println("Number of rows: "+reader.getSheetRow("SignUpTest"));
		System.out.println("Number of cols: "+reader.getSheetCol("SignUpTest"));
		System.out.println("Row Cell that is under: "+"firstname col: "+reader.getCellData("SignUpTest","firstname",1));
		
	}

}
