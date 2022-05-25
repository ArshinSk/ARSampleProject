package com.autorabit.suiteBase;

import com.autorabit.resuableUtilities.ExcelOperations;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestData {
    String Suite_TestData_Path=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData"+File.separator;
    public ExcelOperations excel;
    public String testDataFile=null;

    @DataProvider(name="readExcelData")
    public Object[][] testDataSupplier(){
        int noofrows=excel.getRowCount();
        Object[][] obj = new Object[noofrows][1];
        for(int i=1; i<noofrows+1; i++){
            HashMap<String,String> testData = excel.getDataInMap(i);
            obj[i-1][0] = testData;
        }
        return obj;
    }

    @DataProvider(name="readExcelDataFromMultipleSheets")
    public Object[][] testDataSupplierFromSheets(Method m){

    String sheetName="";
        if(m.getName().length()>31)
            sheetName=m.getName().substring(0,31);
        else
            sheetName=m.getName();

        excel = new ExcelOperations(testDataFile,sheetName);
        int noofrows=excel.getRowCount();
        Object[][] obj = new Object[noofrows][1];
        for(int i=1; i<noofrows+1; i++){
            HashMap<String,String> testData = excel.getDataInMap(i);
            obj[i-1][0] = testData;
        }
        return obj;
    }

    @DataProvider(name="readDataFromJson")
    public Object[][] readJson(Method method) {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = null;
        try {
            reader = new FileReader(new File(Suite_TestData_Path+testDataFile));
        } catch (FileNotFoundException fileNotFoundExce) {
            fileNotFoundExce.printStackTrace();
        }
        Object obj=null;
        obj=jsonParser.parse(reader);

        JsonObject jsonObj = (JsonObject) obj;

        JsonArray methodArray = (JsonArray) jsonObj.get(method.getName());
        Object[][] dataObj = null;
        Map<String,Object> dataMap;
        if(methodArray.isJsonArray()) {
            dataObj = new Object[methodArray.size()][1];
            for(int i=0; i<methodArray.size(); i++) {
                JsonObject data = (JsonObject) methodArray.get(i);
                dataMap = new Gson().fromJson(data.toString(), HashMap.class);
                dataObj[i][0] = dataMap;
            }
        }

        return dataObj;
    }


}
