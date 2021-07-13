package com.blz.selenium.utility;

import com.blz.selenium.base.BaseClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Feature("Excel Sheet")
@Description("created excel util class, declared projectpath , workbook , sheet")
@Story("Created constructor for getting excelPath and sheetName" +
        "Created methods getRowCount , getCellCount and getCellData" +
        "which returns row count , column count and cell data ")

public class ExcelUtils extends BaseClass {

    static String projectPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    //constructor
    public ExcelUtils(String excelPath, String sheetName){
        try {
            projectPath = System.getProperty("user.dir");
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public  int getRowCount() {
        int Row_Count = 0;
        try {

            Row_Count = sheet.getPhysicalNumberOfRows();
            System.out.println("Number of rows : "+Row_Count);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Row_Count;
    }

    public  int getColumnCount() {
        int Column_Count = 0;
        try {

            Column_Count = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("Number of columns : "+Column_Count);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Column_Count;
    }

    public  String getCellData(int rowNum,int colNum) {
        String cellData = String.valueOf(1);
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            //System.out.println("Data is : "+cellData);
        } catch (Exception e){
            e.printStackTrace();

        }
        return cellData;
    }

}


