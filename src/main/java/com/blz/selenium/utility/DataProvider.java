package com.blz.selenium.utility;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;

@Feature("Rows and Columns")
@Description("created DataProvider class,stated excelPath of sheet and SheetName")
@Story("Created testData and getData method " +
        "which will take data from excel sheet and " +
        "also returns rowcount and columncount and data")

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "test1")
    public static Object[][] getData() {
        String excelPath =("C:\\Users\\irg\\IdeaProjects\\DataDriven_Demo\\src\\test\\resources\\LoginData.xlsx");
        return testData(excelPath,"Sheet1");
    }

    public static Object[][] testData(String excelPath, String sheetName) {
        ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
        int Row_Count = excel.getRowCount();
        int Column_Count = excel.getColumnCount();

        Object[][] data = new Object[Row_Count - 1][Column_Count];

        for(int i =1;i<Row_Count;i++){
            for(int j=0;j<Column_Count;j++){
                String cellData = excel.getCellData(i,j);
                System.out.print(cellData+" | ");
                data[i-1][j] = cellData;
            }
            System.out.println();
        }
        return data;
    }

}