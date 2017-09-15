package com.automationpractice.common;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class OutputToExcel {

	Workbook wb = new XSSFWorkbook();
	CreationHelper creationHelper = wb.getCreationHelper();
	Sheet sheet = wb.createSheet("Sept_13_2017");
	
	
	public void createCellsPractice() throws IOException{
	//Create a row and allocate cells in it.
	Row row = sheet.createRow((short)0);
	
	//Create a cell and put a value in it.
	Cell cell = row.createCell((short)0);
	cell.setCellValue(1);
	
	//numeric value
	row.createCell(2).setCellValue("This is a String cell");
	//Boolean
	row.createCell(3).setCellValue(true);
	//Formula
	row.createCell(4).setCellValue("SUM(A1:B1)");
	//Date
	CellStyle style = wb.createCellStyle();
	style.setDataFormat(creationHelper.createDataFormat().getFormat("mm/dd/yy hh:mm"));
	cell = row.createCell(5);
	cell.setCellValue(new Date());
	cell.setCellStyle(style);
	
	//Write the output to file
	FileOutputStream fileout = new FileOutputStream("ExcelCreationPractice.xlsx");
	wb.write(fileout);
	fileout.flush();
	fileout.close();
	
	}
	
	public void outputResults(String [][] Results) throws IOException {
		FileOutputStream fileout = new FileOutputStream("ExcelCreationPractice.xlsx");
		Row [] row = new Row[Results.length];
		Cell [] [] cell = new Cell[row.length][];
		
		for(int i = 0; i < row.length; i++)
		{
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[Results[i].length];
			
			for(int j =0; j < cell[i].length; j++)
			{
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(Results[i][j]);
			}
		}
		
		//Export Data
		wb.write(fileout);
		fileout.flush();
		fileout.close();
	}
	
	public void newOutputResults (ArrayList<String> testResults) throws IOException {
		
		FileOutputStream fileout = new FileOutputStream("CollectionsPractice.xlsx");
		
		Row row = sheet.createRow(0);
		for(String a: testResults){
			Cell cell = row.createCell(testResults.indexOf(a));
			cell.setCellValue(a);
		
	}
		wb.write(fileout);
		fileout.flush();
		fileout.close();
}
}
