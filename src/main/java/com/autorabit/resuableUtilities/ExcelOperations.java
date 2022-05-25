package com.autorabit.resuableUtilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ExcelOperations {
    String TestData_Path=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData"+File.separator;
    Sheet sh;
    public ExcelOperations(String fileName,String sheetName){
        String Excel_filePath = TestData_Path+fileName;
        File data_src = new File(Excel_filePath);
        Workbook wb = null;
            try {
                 wb = WorkbookFactory.create(data_src);
            } catch (IOException e) {
                e.printStackTrace();
            }
        sh = wb.getSheet(sheetName);
    }

    public HashMap<String, String> getDataInMap(int rowNum){
        HashMap<String,String> excel_dataMap = new HashMap<>();
        for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
            String value;
            if(sh.getRow(rowNum).getCell(i) != null) {
                sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
                value = sh.getRow(rowNum).getCell(i).toString();
            }
            else {
                value = "";
            }
            excel_dataMap.put(sh.getRow(0).getCell(i).toString(), value);
        }
        return excel_dataMap;
    }

    public int getRowCount(){
        return sh.getLastRowNum();
    }

    public int getColumnCount(){
        return sh.getRow(0).getLastCellNum();
    }
}
