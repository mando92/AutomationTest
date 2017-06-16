package com.automationpractice.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;

	public static void setExcelFile(String Path, String SheetName)
			throws Exception {

		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet
		excelWBook = new XSSFWorkbook(ExcelFile);
		excelWSheet = excelWBook.getSheet(SheetName);

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			String cellData = "";
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
						
		
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				cellData = cell.getStringCellValue();
				
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				
				if(DateUtil.isCellDateFormatted(cell))
				{
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					cellData=  sdf.format(cell.getDateCellValue());

				
				}else{
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cellData = cell.getStringCellValue();
				}				
			}
			
			System.out.println("Row Num: "+RowNum + "  Column Num: "+ColNum+"\n Value: "+cellData);
			
			return cellData;

		} catch (Exception e) {
			throw e;

		}

	}

	public static void setCellData(String Result, int RowNum, int ColNum)
			throws Exception {

		try {

			row = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum, row.RETURN_BLANK_AS_NULL);
			if (cell == null) {

				cell = row.createCell(ColNum);
				cell.setCellValue(Result);

			} else {
				cell.setCellValue(Result);
			}

			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream("");

			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			throw (e);
		}
	}

}
