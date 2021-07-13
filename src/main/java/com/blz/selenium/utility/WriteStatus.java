package com.blz.selenium.utility;


import com.blz.selenium.base.BaseClass;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteStatus extends BaseClass {

    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;

    public static void writeStatus(int rowPosition, int colPosition) throws IOException {

        String excelPath =("C:\\Users\\irg\\IdeaProjects\\DataDriven_Demo\\src\\test\\resources\\LoginData.xlsx");

        workbook = new XSSFWorkbook(new FileInputStream(excelPath));
        sheet = workbook.getSheet("Sheet1");
        row = sheet.getRow(rowPosition);
        row.createCell(3).setCellValue("Status");
        FileOutputStream fileOutputStream = new FileOutputStream(excelPath);
        workbook.write(fileOutputStream);
    }
}
