package com.utils.displaybookshelves;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class writeExcel {

	/* This method is used to write details in excel file */
	public void showOutputInExcelFile(List<WebElement> names, List<WebElement> prices,String sheetName,String xlFileName) throws Exception {

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet(sheetName);
		TreeMap<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "Name", "Price (Rs)" });
		for (int i = 0; i < 3; i++)
			data.put(Integer.toString(i + 2), new Object[] { names.get(i).getText(), prices.get(i).getText() });

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// this creates a new row in the sheet
			XSSFRow row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				// this line creates a cell in the next column of that row
				XSSFCell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// this Writes the workbook
			FileOutputStream out = new FileOutputStream(
					new File(System.getProperty("user.dir") + "//Excel_Output//"+xlFileName+".xlsx"));
			workbook.write(out);
			out.close();
			System.out.println(xlFileName+".xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* This method is used to write submenu details in excel file */
	public void showMenuInExcel(List<WebElement> allMenu) {

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("MenuList");
		TreeMap<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ListItems" });
		for (int i = 0; i < 13; i++)
			data.put(Integer.toString(i + 2), new Object[] { allMenu.get(i) });

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// this creates a new row in the sheet
			XSSFRow row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				// this line creates a cell in the next column of that row
				XSSFCell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// this Writes the workbook
			FileOutputStream out = new FileOutputStream(
					new File(System.getProperty("user.dir") + "//Excel_Output//MenuList.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("MenuList.xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
